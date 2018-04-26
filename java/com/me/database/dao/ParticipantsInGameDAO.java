package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.me.database.pojo.Games;
import com.me.database.pojo.ParticipantsInGame;
import com.me.database.pojo.WeaponsInGame;

public class ParticipantsInGameDAO extends DAO{
	
	
	public List<ParticipantsInGame> getAll(String S){
		try {
		    begin();
            Query q = getSession().createQuery("from ParticipantsInGame where characterId in (select characterId from Characters where characterType = :S)");
            q.setString("S", S);
            List<ParticipantsInGame> list = new ArrayList<ParticipantsInGame>();
            list=q.list();
            commit();
            close();
            return list;
        } catch (Exception e) {
        	
        	rollback();
            return null;
        }
	
		
	}
		
	
	public List<ParticipantsInGame> getAllchar(){
		try {
		    begin();
            Query q = getSession().createQuery("from ParticipantsInGame");
            List<ParticipantsInGame> list = new ArrayList<ParticipantsInGame>();
            list=q.list();
                       commit();
            close();
            return list;
        } catch (Exception e) {
        	
        	rollback();
            return null;
        }
		
		
		
		
	}
	
	
	public void deleteAll(){
		try {
            begin();
            Query A=getSession().createQuery("from WeaponsInGame");
            List<WeaponsInGame> list2=new ArrayList<WeaponsInGame>();
            Query q = getSession().createQuery("from ParticipantsInGame");
            List<ParticipantsInGame> list = new ArrayList<ParticipantsInGame>();
            list=q.list();
            list2=A.list();
            
           
            if(list.size()>=8)
            {
            	for(WeaponsInGame W:list2){
            		
            		getSession().delete(W);
            	}
            	for(ParticipantsInGame P:list) {
            	getSession().delete(P);}
            
            
            }
            commit();
            close();
        } catch (Exception e) {
            rollback();}
		
	}
    public ParticipantsInGame create(int ParticipantId,int CharacterId)
            throws Exception {
        try {
        	  begin();
            ParticipantsInGame participantInGame=new ParticipantsInGame(ParticipantId,CharacterId);
            getSession().save(participantInGame);
            commit();
            create2();
            close();
            participantInGame.setId((participantInGame.getTableid()%8)+1);
            return participantInGame;
        } catch (Exception e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
              throw new Exception("Exception while creating user: " + e.getMessage());
        }
    }

    public void create2(){
    	try{ begin();
         Query q = getSession().createQuery("update ParticipantsInGame set id=((tableid)%8)+1");
         int a=q.executeUpdate();
         commit();
    	}
    	catch(Exception E){rollback();}
    }
}
