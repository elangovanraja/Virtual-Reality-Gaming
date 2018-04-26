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

import com.me.database.dao.GenreDao;
import com.me.database.dao.WeaponDAO;
import com.me.database.pojo.Genre;
import com.me.database.pojo.Weapons;

@Controller
@RequestMapping("/removeweapons.htm")
public class RemoveWeapons {
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView remove(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("weapons")Weapons weapon,BindingResult result) {
		
		WeaponDAO weapondao=new WeaponDAO();
		List<Weapons> weapons=weapondao.getWeapons();
		String n=request.getParameter("weaponid");

		int id=Integer.parseInt(n);
		Weapons selectedweapon=null;
		for(Weapons W:weapons){
			
			if(W.getWeaponId()==id){
				selectedweapon=W;
			}
		}
		ModelAndView mv=new ModelAndView();
		
		if(selectedweapon==null){
		mv.setViewName("removeweapons");
		mv.addObject("exist", false);
		return mv;
		}
		
		weapondao.Deleteweapon(selectedweapon);
		mv.addObject("removed",true);
		mv.setViewName("removeweapons");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView doSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("weapons")Weapons weapon,BindingResult result) {
		
		ModelAndView mv = new ModelAndView("removeweapons");
		return mv;
	}
}
