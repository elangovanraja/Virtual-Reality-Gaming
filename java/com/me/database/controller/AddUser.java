package com.me.database.controller;

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

import com.me.database.pojo.*;
import com.me.database.controller.*;
import com.me.database.dao.*;

@Controller
@RequestMapping("/adduser.htm")
public class AddUser {
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("User")User user, BindingResult result) throws Exception {
		//validator.validate(user, result);
		User user1=new User(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName());
		if (result.hasErrors()) {
			return null;
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			userDao.create(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName());	
			// DAO.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		
		}
		ModelAndView mv=new ModelAndView("home2","user",user1);
		return mv;
		
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
		
		return "addUserForm";
	}
}