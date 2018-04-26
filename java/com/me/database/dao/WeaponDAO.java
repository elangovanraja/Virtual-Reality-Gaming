package com.me.database.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.database.pojo.Admin;
import com.me.database.pojo.Characters;
import com.me.database.pojo.FlameThrower;
import com.me.database.pojo.Guns;
import com.me.database.pojo.Participants;
import com.me.database.pojo.RocketLauncher;
import com.me.database.pojo.Weapons;

public class WeaponDAO extends DAO {

public List<Weapons> getWeapons(){
		
		begin();
        Query q = getSession().createQuery("from Weapons p order by p.weaponId asc");
        List<Weapons> list = new ArrayList<Weapons>();
        list=q.list();
        commit();
        return list;
	}

public void Deleteweapon(Weapons W){
	try {
        begin();
        getSession().delete(W);
        commit();
    } 
    catch (HibernateException e) 
    {
        rollback();
    }
}
	


public RocketLauncher createRocket(int weaponId,int gameId,String weaponName,String weaponType,String description,int velocity,int no)
        throws Exception {
    try {
        begin();
        RocketLauncher RL=new RocketLauncher(weaponId,gameId,weaponName,weaponType,description,velocity,no);
        getSession().save(RL);
        commit();
        return RL;
    } catch (Exception e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
          throw new Exception("Exception while creating admin: " + e.getMessage());
          }
        
    }

public Guns createGun(int weaponId,int gameId,String weaponName,String weaponType,String description,int mass,int velocity,int no)
        throws Exception {
    try {

        begin();
        Guns gun=new Guns(weaponId,gameId,weaponName,weaponType,description,mass,velocity,no);
        getSession().save(gun);
        commit();
        return gun;
    } catch (Exception e) {
        rollback();
        //throw new AdException("Could not create user " + username, e);
          throw new Exception("Exception while creating admin: " + e.getMessage());
          }
        
    }
    
    public FlameThrower createFlame(int weaponId,int gameId,String weaponName,String weaponType,String description,int mass,int velocity,int no)
            throws Exception {
        try {

            begin();
            FlameThrower flame=new FlameThrower(weaponId,gameId,weaponName,weaponType,description,mass,velocity,no);
            getSession().save(flame);
            commit();
            return flame;
        } catch (Exception e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
              throw new Exception("Exception while creating admin: " + e.getMessage());
            
        }
    
    
}

}
