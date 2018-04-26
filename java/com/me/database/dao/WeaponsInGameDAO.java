package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.me.database.pojo.Characters;
import com.me.database.pojo.Participants;
import com.me.database.pojo.ParticipantsInGame;
import com.me.database.pojo.Weapons;
import com.me.database.pojo.WeaponsInGame;

public class WeaponsInGameDAO extends DAO {
	public WeaponsInGame create(int weaponId,int participantinGameId, int Ammo)
            throws Exception {
        try {
        	
            begin();
            int x=(participantinGameId%8)+1;

    		
            WeaponsInGame weaponsingame=new WeaponsInGame(participantinGameId,weaponId,Ammo,x);
            getSession().save(weaponsingame); 
            commit();
            begin();
            Query q = getSession().createQuery("update WeaponsInGame set actualId=(participantId%8)+1");
            int a=q.executeUpdate();
            commit();
            close();
            return weaponsingame;
        } catch (Exception e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
              throw new Exception("Exception while creating user: " + e.getMessage());
        }
    }
}
