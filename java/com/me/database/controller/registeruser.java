package com.me.database.controller;
import com.me.database.dao.UserDAO;
import com.me.database.pojo.User;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class registeruser {
	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
	@RequestMapping(value="/Profile.htm", method = RequestMethod.GET)
	protected ModelAndView onProfile(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user, BindingResult result) throws Exception
		{
		
		
		
		HttpSession session =request.getSession();
		User user1=(User)session.getAttribute("UUU");
		
		ModelAndView mv=new ModelAndView("ViewProfile","UUU",user1);
		return mv;
		}
	
	
	@RequestMapping(value="/registeruser.htm", method = RequestMethod.POST)
	protected String onSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user, BindingResult result) throws Exception {
        User u=user;
        userValidator.validate(user, result);
		
        UserDAO userdao=new UserDAO();
        
        
        if(user.getFirstName().equals("")||user.getLastName().equals("")||user.getUserName().equals("")||user.getPassword().equals(""))
        {
        	JSONObject obj=new JSONObject();
        	obj.put("failmsg","Please Enter all values");
            obj.put("successmsg","");
            PrintWriter out=response.getWriter();
            out.println(obj);
            return null;
        }
        	
        
        if(user.getUserName().matches("[a-zA-Z0-9]")){
        	JSONObject obj=new JSONObject();
        	obj.put("failmsg","UserName INVALID!");
            obj.put("successmsg","");
            PrintWriter out=response.getWriter();
            out.println(obj);
            return null;
        }
        
        
        
        userdao.create(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName());
        JSONObject obj=new JSONObject();
                obj.put("successmsg","User has been added successfully");
                obj.put("failmsg","");
                PrintWriter out=response.getWriter();
                out.println(obj);     
        return null;// we return null so that we don't navigate to the view
    }		
}
	

