package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.database.pojo.Participants;
import com.me.database.pojo.User;

public class UserDAO extends DAO{

    public UserDAO() {
    }

    public User get(String username)
        throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from User where userName = :username");
            System.out.println(username);
            q.setString("username", username);
            
            User user = (User) q.uniqueResult();
            System.out.println(user.getUserName());
            commit();
            return user;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    public User create(String username, String password, String firstName, String lastName)
            throws Exception {
        try {

            begin();
            User user=new User(username,password,firstName,lastName);
            getSession().save(user);
            commit();
            return user;
        } catch (Exception e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
              throw new Exception("Exception while creating user: " + e.getMessage());
            
        }
    }

    public List<User> GetUsers(){
		
		begin();
        Query q = getSession().createQuery("from User");
        List<User> list = new ArrayList<User>();
        list=q.list();
        commit();
        close();
        return list;
	}
    
    public void delete(User user)
            throws Exception {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete user " + user.getFirstName(), e);
        }
    }
}

