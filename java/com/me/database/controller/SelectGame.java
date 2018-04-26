package com.me.database.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.database.dao.GameDAO;
import com.me.database.pojo.Games;
import com.me.database.pojo.Genre;

@Controller
@RequestMapping("/selectGame.htm")
public class SelectGame {

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("genre")Genre genre,@ModelAttribute("game")Games game, BindingResult result) {
		GameDAO gamesDao = new GameDAO();
		int ID=0;
		if(genre.getGenreName().equals("Shooting")){ID=1;}
		else if(genre.getGenreName().equals("Action")){ID=2;}
		else if(genre.getGenreName().equals("horor")){ID=3;}
		else if(genre.getGenreName().equals("Adventure")){ID=4;}
		else if(genre.getGenreName().equals("Role Playing")){ID=5;}
		List<String> listOfGames = gamesDao.getGames(ID);		
		
		
		ModelAndView mv = new ModelAndView("viewGame","gameList",listOfGames);
		return mv;
	}

}
