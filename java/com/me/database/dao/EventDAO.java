package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.me.database.pojo.Characters;
import com.me.database.pojo.Events;
import com.me.database.pojo.Participants;
import com.me.database.pojo.ParticipantsInGame;

public class EventDAO extends DAO {

	 public Events create(int partId,int weaponId,int X,int A,int B)
	            throws Exception {
	        try {
	            begin();
	            Events event=new Events(partId,weaponId,X,A,B);
	            getSession().save(event);
	            commit();
	            close();
	            
	            return event;
	        } catch (Exception e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	              throw new Exception("Exception while creating user: " + e.getMessage());
	        }
	    }
}
