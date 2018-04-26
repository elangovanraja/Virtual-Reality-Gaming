package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import com.me.database.pojo.Participants;

public class ParticipantDAO extends DAO{
	
	public List<Participants> GetParticipants(){
		
		begin();
        Query q = getSession().createQuery("from Participants");
        List<Participants> list = new ArrayList<Participants>();
        list=q.list();
        commit();
        close();
        return list;
	}

}
