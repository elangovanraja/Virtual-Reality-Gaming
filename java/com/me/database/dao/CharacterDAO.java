package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.me.database.pojo.Characters;
import com.me.database.pojo.Participants;

public class CharacterDAO extends DAO {

public List<Characters> getCharacters(){
		
		begin();
        Query q = getSession().createQuery("from Characters");
        List<Characters> list = new ArrayList<Characters>();
        list=q.list();
        commit();
        close();
        return list;
	}

public List<Characters> getchartype(int S){
	
	begin();
    Query q = getSession().createQuery("from Characters where characterId=(select characterId from ParticipantsInGame where partId = :S)");
    q.setInteger("S", S);
    List<Characters> list = new ArrayList<Characters>();
    list=q.list();
    commit();
    return list;
}


}
