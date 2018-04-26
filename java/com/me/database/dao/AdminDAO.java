package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.database.pojo.Admin;
import com.me.database.pojo.User;

public class AdminDAO extends DAO{
	public AdminDAO() {
    }

    public Admin get(String adminname)
        throws Exception {
        try {
            begin();
            Query q = getSession().createQuery("from Admin where userName = :adminname");
            System.out.println(adminname);
            q.setString("adminname", adminname);
            
            Admin admin = (Admin) q.uniqueResult();
            System.out.println(admin.getAdminName());
            commit();
            return admin;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    public Admin create(String username, String password, String firstName, String lastName)
            throws Exception {
        try {

            begin();
            Admin admin=new Admin(username,password,firstName,lastName);
            getSession().save(admin);
            commit();
            return admin;
        } catch (Exception e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
              throw new Exception("Exception while creating admin: " + e.getMessage());
            
        }
    }

    public List<Admin> Getadmins(){
		
		begin();
        Query q = getSession().createQuery("from Admin");
        List<Admin> list = new ArrayList<Admin>();
        list=q.list();
        commit();
        close();
        return list;
	}
    
    public void delete(Admin admin)
            throws Exception {
        try {
            begin();
            getSession().delete(admin);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete user " + admin.getFirstName(), e);
        }
    }

}
