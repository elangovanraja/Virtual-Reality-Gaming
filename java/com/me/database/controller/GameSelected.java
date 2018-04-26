package com.me.database.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.me.database.pojo.Games;

@Controller
@RequestMapping("/GameSelected.htm")
public class GameSelected {

	@RequestMapping(method = RequestMethod.POST)
	public String doSubmit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("game")Games game, BindingResult result) {
		
		if(game.getGameName().equals("Gears of war")){
			return "THEGAME";
		}
		else{
			return "Nope";
		}
		
		
	}	
	

}
