package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.me.database.pojo.Genre;

public class GenreDao extends DAO {

	public List<Genre> getGenre() {
		
		begin();
        Query q = getSession().createQuery("from Genre");
        List<Genre> list = new ArrayList<Genre>();
        list=q.list();
        commit();
        close();
        return list;
        
	}
}
