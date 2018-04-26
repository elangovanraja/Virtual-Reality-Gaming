package com.me.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.database.pojo.Genre;
@Controller
@RequestMapping("/GoHome.htm")


public class Controller2 {

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("genre")Genre genre, BindingResult result) throws Exception {
		//personValidator.validate(person, result);
		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm() {
		return "home";
	}
}
