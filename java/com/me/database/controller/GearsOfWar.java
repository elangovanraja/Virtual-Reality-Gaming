package com.me.database.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.database.dao.CharacterDAO;
import com.me.database.dao.EventDAO;
import com.me.database.dao.ParticipantDAO;
import com.me.database.dao.ParticipantsInGameDAO;
import com.me.database.dao.WeaponDAO;
import com.me.database.dao.WeaponsInGameDAO;
import com.me.database.pojo.Characters;
import com.me.database.pojo.Games;
import com.me.database.pojo.Participants;
import com.me.database.pojo.ParticipantsInGame;
import com.me.database.pojo.Weapons;
import com.me.database.pojo.WeaponsInGame;

@Controller
@RequestMapping()
public class GearsOfWar {
	private static List<Participants> listOfParts=new ArrayList<Participants>();
	private  List<Characters> listOfCharacters=new ArrayList<Characters>();
	private static List<Participants> listOfAllParts=new ArrayList<Participants>();
	private  List<Characters> listOfAllCharacters=new ArrayList<Characters>();
	private  List<ParticipantsInGame> BadInGAME=new ArrayList<ParticipantsInGame>();
	private  List<ParticipantsInGame> GoodInGAME=new ArrayList<ParticipantsInGame>();
	private  List<ParticipantsInGame> inGAME=new ArrayList<ParticipantsInGame>();
	private  List<WeaponsInGame> weaponsInGAME=new ArrayList<WeaponsInGame>();
	
	@RequestMapping(value="/SHOOTED.htm", method = RequestMethod.POST)
	protected ModelAndView doSubmit3(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("good")Participants Parts,@ModelAttribute("pingame") ParticipantsInGame pingame, @ModelAttribute("bad")Participants parts,BindingResult result) 
		{	ModelAndView M=new ModelAndView("GAMESTARTED","partsInGame",inGAME);
		
			ParticipantsInGameDAO PIGDAO=new ParticipantsInGameDAO();
			List<ParticipantsInGame> listOfPIG=new ArrayList<ParticipantsInGame>();
			inGAME=new ArrayList<ParticipantsInGame>();
			CharacterDAO chardao=new CharacterDAO();
			
			
			//inGAME=GoodInGAME=new ArrayList<ParticipantsInGame>();
			inGAME=PIGDAO.getAllchar();
			
			
			String P=request.getParameter("parti");
			int partID=Integer.parseInt(P);
			List<ParticipantsInGame> list=PIGDAO.getAllchar();
			
			List<Characters> CHA=chardao.getchartype(partID);
			String Side;
			if(CHA.get(0).getCharacterType().equals("g"))
			{
			listOfPIG=PIGDAO.getAll("b");
			Side="Radiant";
			}
			else{
				listOfPIG=PIGDAO.getAll("g");
				Side="Dire";
				
			}
			inGAME=PIGDAO.getAllchar();
			GoodInGAME=new ArrayList<ParticipantsInGame>();
			BadInGAME=new ArrayList<ParticipantsInGame>();
			
			for(ParticipantsInGame PE:inGAME){
				if(PE.getCharacterId()<5){GoodInGAME.add(PE);}
				else{BadInGAME.add(PE);
				
				}
			}
			
			
			
				int X1=0,X2=30,X3=60,X4=90,Y,A,B;
				Random rnd = new Random();
				X1=rnd.nextInt(200)+20;
				Y=70;
				int flag=1;
				while(flag==1){
					X2=rnd.nextInt(200)+20;
					flag=f1(X1,X2);
				}
				flag=1;
				while(flag==1){
					X3=rnd.nextInt(200)+20;
					flag=f2(X1,X2,X3);
				}
				flag=1;
				while(flag==1){
					X4=rnd.nextInt(200)+20;
					flag=f3(X1,X2,X3,X4);
				}
				
				A=rnd.nextInt(200);
				B=rnd.nextInt(100);
//				A=100;
//				X1=100;
//				B=70;
				EventDAO eventdao=new EventDAO();
				Weapons weapon=null;
				
				WeaponDAO weaponDao = new WeaponDAO();
				List<Weapons> listOfWeapons = weaponDao.getWeapons();
				for(Weapons W: listOfWeapons){
					if(W.getWeaponName().equals(request.getParameter("shotweapon")))
						weapon=W;
				}
				M.addObject("Acoord", A);
				M.addObject("Bcoord", B);
				M.addObject("X1coord", X1);
				M.addObject("X2coord", X2);
				M.addObject("X3coord", X3);
				M.addObject("X4coord", X4);
				M.addObject("Ycoord",70);
				
				ParticipantDAO pDAO=new ParticipantDAO();
				List<Participants> listofP=new ArrayList<Participants>();
				listofP=pDAO.GetParticipants();
				for(Participants poo:listofP){
					if(poo.getParticipantId()==partID)
					M.addObject("shootingplayer", poo.getParticipantName());
				}
				M.addObject("shotweapon",request.getParameter("shotweapon"));

				String player1=isShot(X1, A, B);
				if(!(player1.equals("No")))
				{		M.addObject("ishit", true);
						for(Participants poo:listofP)
						{
							if(poo.getParticipantId()==listOfPIG.get(0).getPartId())
								M.addObject("shotplayer", poo.getParticipantName());
							
						}					
				}
				String player2=isShot(X2, A, B);
				if(!(player1.equals("No")))
				{		M.addObject("ishit", true);
					for(Participants poo:listofP)
						{
							if(poo.getParticipantId()==listOfPIG.get(1).getPartId())
								M.addObject("shotplayer", poo.getParticipantName());
								}					
				}
				String player3=isShot(X3, A, B);
				if(!(player1.equals("No")))
				{		M.addObject("ishit", true);
						for(Participants poo:listofP)
						{
							if(poo.getParticipantId()==listOfPIG.get(2).getPartId())
								M.addObject("shotplayer", poo.getParticipantName());
								}					
				}
				String player4=isShot(X4, A, B);
				if(!(player1.equals("No")))
				{		M.addObject("ishit", true);
						for(Participants poo:listofP)
						{
							if(poo.getParticipantId()==listOfPIG.get(3).getPartId())
								M.addObject("shotplayer", poo.getParticipantName());
								}					
				}
				
				if(listOfPIG.get(0).getHitPoints()>0){
					
					try{
						eventdao.create(listOfPIG.get(0).getPartId(), weapon.getWeaponId(), X1, A, B);
					}
					catch(Exception E){   
					}
				}
				if(listOfPIG.get(1).getHitPoints()>0){
					
					try{eventdao.create(listOfPIG.get(1).getPartId(), weapon.getWeaponId(), X2, A, B);}
					catch(Exception E){}
				}
				if(listOfPIG.get(2).getHitPoints()>0){
					
					try{eventdao.create(listOfPIG.get(2).getPartId(), weapon.getWeaponId(), X3, A, B);}
					catch(Exception E){}
				}
				if(listOfPIG.get(3).getHitPoints()>0){
					
					try{eventdao.create(listOfPIG.get(3).getPartId(), weapon.getWeaponId(), X4, A, B);}
					catch(Exception E){}
				}
				inGAME=new ArrayList<ParticipantsInGame>();
				inGAME=PIGDAO.getAllchar();
				
				
				
				GoodInGAME=new ArrayList<ParticipantsInGame>();
				BadInGAME=new ArrayList<ParticipantsInGame>();
				for(ParticipantsInGame PE:inGAME){
					if(PE.getCharacterId()<5){GoodInGAME.add(PE);}
					else{BadInGAME.add(PE);}
				}
			
				if(listOfPIG.get(0).getHitPoints()<=0&&listOfPIG.get(1).getHitPoints()<=0&&listOfPIG.get(2).getHitPoints()<=0&&listOfPIG.get(3).getHitPoints()<=0)
				{
					ModelAndView MV=new ModelAndView("GameEnded","winner",Side);
					return MV;
					
				}
				M.addObject("parts",listOfAllParts);
				M.addObject("chars",listOfAllCharacters);
				M.addObject("good",GoodInGAME);
				M.addObject("bad",BadInGAME);
				M.addObject("WPN", weaponsInGAME);
				M.addObject("wee",listOfWeapons);
				return M;
			
		
		}
	
	public int f1(int A,int B){
		if(B>(A-20) && B<(A+20)){
			return 1;
		}
		else return 0;
		
	}
	
	
	public int f2(int A,int B,int C){
		if((C>(A-20) && C<(A+20))||(C>(B-20) && C<(B+20))){
			return 1;
		}
		else return 0;
	}
	public int f3(int A,int B,int C,int D){
		if((D>(A-20) && D<(A+20))||(D>(B-20) && D<(B+20))||(D>(C-20) && D<(C+20))){
			return 1;
		}
		else return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/GearsOfWar.htm", method = RequestMethod.POST)
	protected ModelAndView doSubmit2(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("parts")Participants Parts,@ModelAttribute("weapons")Weapons weapons, @ModelAttribute("chars") Characters chars,@ModelAttribute("ParticipantsInGame")ParticipantsInGame PartinGame,BindingResult result) {
		Participants PA=null;
		Characters CA=null;
		ParticipantDAO partDao = new ParticipantDAO();
		CharacterDAO charDao = new CharacterDAO();
		WeaponDAO weaponDao = new WeaponDAO();
		List<Weapons> listOfWeapons = weaponDao.getWeapons();
		
		Weapons weapon1=null,weapon2=null,weapon3=null;
		
		
		
		for(Weapons W: listOfWeapons){
			if(W.getWeaponName().equals(request.getParameter("weapon1Select")))
				weapon1=W;
			if(W.getWeaponName().equals(request.getParameter("weapon2Select")))
				weapon2=W;
			if(W.getWeaponName().equals(request.getParameter("weapon3Select")))
				weapon3=W;
		}
		
		for(Participants P:listOfParts){
			if(P.getParticipantName().equals(Parts.getParticipantName())){
				PA=P;
			}
		}
		
		for(Characters C:listOfCharacters){
			if(C.getCharacterName().equals(request.getParameter("charSelect")))
				CA=C;
		}
		
		ParticipantsInGameDAO partingamedao=new ParticipantsInGameDAO();
		WeaponsInGameDAO weaponsingamedao=new WeaponsInGameDAO();
		
		try	{
			ParticipantsInGame PIG=partingamedao.create(PA.getParticipantId(), CA.getCharacterId());
			inGAME.add(PIG);
			weaponsInGAME.add(weaponsingamedao.create(weapon1.getWeaponId(), PIG.getTableid(), 3));
			weaponsInGAME.add(weaponsingamedao.create(weapon2.getWeaponId(), PIG.getTableid(), 3));
			weaponsInGAME.add(weaponsingamedao.create(weapon3.getWeaponId(), PIG.getTableid(), 3));
			}
		catch(Exception E){}
		listOfCharacters.remove(CA);
		listOfParts.remove(PA);
		
		
		ModelAndView mv = new ModelAndView("ParticipantsInGame","parts",listOfParts);
		mv.addObject("chars", listOfCharacters);
		mv.addObject("weapons", listOfWeapons);
		mv.addObject("weaponsingame", weaponsInGAME);
		if(listOfCharacters.size()==0){
			for(ParticipantsInGame P:inGAME){
				if(P.getCharacterId()<5){GoodInGAME.add(P);}
				else{BadInGAME.add(P);}
			}
			
			ModelAndView M=new ModelAndView("GAMESTARTED","partsInGame",inGAME);
			M.addObject("parts",listOfAllParts);
			M.addObject("chars",listOfAllCharacters);
			M.addObject("good",GoodInGAME);
			M.addObject("bad",BadInGAME);
			M.addObject("WPN", weaponsInGAME);
			M.addObject("wee",listOfWeapons);
			return M;
		}
		return mv;
	}	
	
		
	
	@RequestMapping(value="/GearsOfWar.htm", method = RequestMethod.GET)
	protected ModelAndView doSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("parts")Participants Parts,@ModelAttribute("weapons")Weapons weapons, @ModelAttribute("chars") Characters chars,@ModelAttribute("ParticipantsInGame")ParticipantsInGame PartinGame,BindingResult result) {
		ParticipantsInGameDAO partingamedao=new ParticipantsInGameDAO();
		partingamedao.deleteAll();
		ParticipantDAO partDao = new ParticipantDAO();
		//listOfParts=new ArrayList<Participants>();
		listOfParts = partDao.GetParticipants();
		//listOfAllParts=new ArrayList<Participants>();
		listOfAllParts=partDao.GetParticipants();
		CharacterDAO charDao = new CharacterDAO();
		listOfCharacters = charDao.getCharacters();
		weaponsInGAME=new ArrayList<WeaponsInGame>();
		BadInGAME=new ArrayList<ParticipantsInGame>();
		GoodInGAME=new ArrayList<ParticipantsInGame>();
		inGAME=new ArrayList<ParticipantsInGame>();

		listOfAllCharacters = charDao.getCharacters();
		WeaponDAO weaponDao = new WeaponDAO();
		List<Weapons> listOfWeapons = weaponDao.getWeapons();
		
		ModelAndView mv = new ModelAndView("ParticipantsInGame","parts",listOfParts);
		listOfParts.remove(Parts);
		mv.addObject("chars", listOfCharacters);
		mv.addObject("weapons", listOfWeapons);
		return mv;
	}
	

	public String isShot(int x,int A,int B){
		
		boolean hit;
		String flag;
	    if(Math.pow(x-A,2)+Math.pow(70-B,2)<=100)
	    {	hit=true;
	        flag="Head";}
		
		else if((x-20<=A)&&(x+20>=A)&&(70>=B)&&(0<=B))
		{hit=true;
	        flag="Body";}
	     else 
			{hit=false;
	        flag="No";}
	    
	    return flag;
	    
	    
	}
	
	
	
	
	
	
}
