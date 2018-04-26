package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.me.database.pojo.Games;

public class GameDAO extends DAO{

public List<String> getGames(int ID) {
		
		begin();
        Query q = getSession().createQuery("from Games A where genreId=:ID");
        Games a= null;
        q.setInteger("ID", ID);
        List<Games> list = new ArrayList<Games>();
        list=q.list();
        List<String> gameNames = new ArrayList<String>();
        for(int i=0;i<list.size();i++) {
        	a=list.get(i);
        	gameNames.add(a.getGameName());
        }
        commit();
        close();
        return gameNames;
	
}
}