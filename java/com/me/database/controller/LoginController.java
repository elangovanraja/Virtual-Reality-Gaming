package com.me.database.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.me.database.dao.AdminDAO;
import com.me.database.dao.UserDAO;
import com.me.database.pojo.Admin;
import com.me.database.pojo.Genre;
import com.me.database.pojo.Person;
import com.me.database.pojo.User;
import com.me.database.controller.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "login.htm", method = RequestMethod.POST)
	public ModelAndView doSubmitaction(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user, BindingResult result)
	{	
		HttpSession session =request.getSession();
		if(session.getAttribute("cannot").equals("No such Username exists!!"))
		{
			ModelAndView mv=new ModelAndView("login");
			mv.addObject("cannot1",1);
			return mv;
			
		}
		
		
		
		AdminDAO adminDAO=new AdminDAO();
		List<Admin> admins=adminDAO.Getadmins();
		UserDAO userdao=new UserDAO();
		List<User> users=userdao.GetUsers();
		
		for(Admin A:admins){
			if(A.getAdminName().equals(user.getUserName())&&A.getPassword().equals(user.getPassword())){
				session.setAttribute("loggedinUser", user.getUserName());
				session.setAttribute("islogged", true);
				session.setAttribute("failed", false);
				session.setAttribute("type", "admin");
				session.setAttribute("log", A);
				ModelAndView mv=new ModelAndView("home");
				return mv;	
			}	
		}
		
		
		for(User A:users){
			if(A.getUserName().equals(user.getUserName())&&A.getPassword().equals(user.getPassword())){
				session.setAttribute("loggedinUser", user.getUserName());
				session.setAttribute("islogged", true);
				session.setAttribute("failed", false);
				session.setAttribute("type", "user");
				session.setAttribute("log", A);
				ModelAndView mv=new ModelAndView("home");
				return mv;	
			}	
		}
		session.setAttribute("failed", true);
		
		ModelAndView mv=new ModelAndView("login");
		mv.addObject("cannot1", 2);
		return mv;
	}
	
	
	@RequestMapping(value="signup.htm", method = RequestMethod.GET)
	public String initializeForm1(@ModelAttribute("user")User user, BindingResult result) {
		return "signUp";
	}
	
	@RequestMapping(value="signUp.htm", method = RequestMethod.POST)
	protected String doSubmitAction(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user")User user, BindingResult result) throws Exception {
		//personValidator.validate(person, result);
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "signUp";
		}
		UserDAO userDao = new UserDAO();
		String type="Person";
		List<User> users=userDao.GetUsers();
		for(User A:users){
			if(A.getUserName().equals(user.getUserName())){
				HttpSession session =request.getSession();
				session.setAttribute("already", true);
				return "signUp";	
			}	
		}
		
		User A=null;
		try {
		A=userDao.create(user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName());
		}
		catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		if(A==null){return "userexists";}
		return "addedUser";
	}
	
	
	@RequestMapping(value = "/loginpage.htm", method = RequestMethod.GET)
	public String initializeForm2(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user")User user, BindingResult result) {
			HttpSession session=request.getSession();
			session.setAttribute("failed", false);
		return "login";
		}
			
	
	@RequestMapping(value="/home.htm", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value="/logoutpage.htm",method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user, BindingResult result){
		HttpSession session=request.getSession();
		session.invalidate();
		session=null;
		response.reset();
        response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0); 
		
        return "home2";	
	}
	
	@RequestMapping(value="/logoutpage.htm",method=RequestMethod.POST)
	public String logout2(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user, BindingResult result){
		HttpSession session=request.getSession();
		session.invalidate();
		session=null;
		return "home2";	
	}
	}
	
	
	

