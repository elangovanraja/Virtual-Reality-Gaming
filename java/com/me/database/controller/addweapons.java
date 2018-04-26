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

import com.me.database.dao.WeaponDAO;
import com.me.database.pojo.Characters;
import com.me.database.pojo.FlameThrower;
import com.me.database.pojo.Guns;
import com.me.database.pojo.RocketLauncher;
import com.me.database.pojo.Participants;
import com.me.database.pojo.ParticipantsInGame;
import com.me.database.pojo.Weapons;

@Controller
public class addweapons {

	@RequestMapping(value="/addweapons.htm", method = RequestMethod.POST)
	protected String doSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("Guns")Guns gun,@ModelAttribute("weapons")Weapons weapons, @ModelAttribute("FlameThrower")FlameThrower FT ,@ModelAttribute("RocketLauncher")RocketLauncher RL,BindingResult result) 
	{
		return "addweapons";
	}
	
	@RequestMapping(value="/addguns.htm", method = RequestMethod.POST)
	protected ModelAndView AddGuns(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("Guns")Guns gun,@ModelAttribute("weapons")Weapons weapons, @ModelAttribute("FlameThrower")FlameThrower FT ,@ModelAttribute("RocketLauncher")RocketLauncher RL,BindingResult result) 
	{
		
		
		
		
		gun.setWeaponType("Gun");
		WeaponDAO weapondao=new WeaponDAO();
		List<Weapons> listofweapons=weapondao.getWeapons();
		for(Weapons W:listofweapons){
			if(W.getWeaponId()==gun.getWeaponId()){
				ModelAndView M=new ModelAndView("addweapons","alreadyexists",true);
				return M;
			}
			
		}
		try {
			weapondao.createGun(gun.getWeaponId(), gun.getGameId(), gun.getWeaponName(), gun.getWeaponType(), gun.getDescription(), gun.getMass(), gun.getVelocity(), gun.getNumberOfBullets());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	ModelAndView mv=new ModelAndView("addweapons","weapontype",gun);
	mv.addObject("success", true);
	return mv;
		
		
	}
	
	@RequestMapping(value="/addrockets.htm", method = RequestMethod.POST)
	protected ModelAndView AddRocket(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("Guns")Guns gun,@ModelAttribute("weapons")Weapons weapons, @ModelAttribute("FlameThrower")FlameThrower FT ,@ModelAttribute("RocketLauncher")RocketLauncher RL,BindingResult result) 
	{
		
		
		
		
		RL.setWeaponType("rocket");
		WeaponDAO weapondao=new WeaponDAO();
		List<Weapons> listofweapons=weapondao.getWeapons();
		for(Weapons W:listofweapons){
			if(W.getWeaponId()==gun.getWeaponId()){
				ModelAndView M=new ModelAndView("addweapons","alreadyexists",true);
				return M;
			}
			
		}
		try {
			weapondao.createRocket(RL.getWeaponId(), RL.getGameId(), RL.getWeaponName(), RL.getWeaponType(), RL.getDescription(), RL.getVel(), RL.getNumberOfRockets());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	ModelAndView mv=new ModelAndView("addweapons","weapontype",gun);
	mv.addObject("success", true);
	return mv;
		
		
	}
	
	
	
	
	@RequestMapping(value="/addflames.htm", method = RequestMethod.POST)
	protected ModelAndView AddFlame(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("FlameThrower")FlameThrower flame,BindingResult result) 
	{	
		
		
		flame.setWeaponType("FlameThrower");
		WeaponDAO weapondao=new WeaponDAO();
		List<Weapons> listofweapons=weapondao.getWeapons();
		for(Weapons W:listofweapons){
			if(W.getWeaponId()==flame.getWeaponId()){
				ModelAndView M=new ModelAndView("addweapons","alreadyexistsflame",true);
				return M;
			}
			
		}
		try {
			weapondao.createFlame(flame.getWeaponId(), flame.getGameId(), flame.getWeaponName(), flame.getWeaponType(), flame.getDescription(), flame.getIntensity(), flame.getTemperature(), flame.getAmmo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	ModelAndView mv=new ModelAndView("weaponadded","weapontype",flame);
	return mv;
		
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value="/addweapons.htm", method = RequestMethod.GET)
	protected String doSubmit2(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("Guns")Guns gun,@ModelAttribute("weapons")Weapons weapons, @ModelAttribute("FlameThrower")FlameThrower FT ,@ModelAttribute("RocketLauncher")RocketLauncher RL,BindingResult result) 
	{
		return "addweapons";
	}
}