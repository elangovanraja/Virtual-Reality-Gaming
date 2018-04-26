package com.me.database.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.database.dao.GenreDao;
import com.me.database.pojo.Genre;
import com.me.database.pojo.User;

@Controller
@RequestMapping("/game.htm")
public class Controller1 {

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView doSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user,@ModelAttribute("genre")Genre genre, BindingResult result) {
		
		GenreDao genreDao = new GenreDao();
		List<Genre> listOfGenres = genreDao.getGenre();
		HttpSession session=request.getSession();	
		String S=(String)session.getAttribute("loggedinUser");
		if(S==null){
			ModelAndView MV=new ModelAndView("login");
			MV.addObject("please", true);
			return MV;
			
		}
		else if(S.equals("")){
			
			ModelAndView MV=new ModelAndView("login");
			MV.addObject("please", true);
			return MV;
		}
		
		ModelAndView mv = new ModelAndView("viewGenre","genreList",listOfGenres);
		return mv;
	}
}
