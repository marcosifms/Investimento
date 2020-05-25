/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Marcos
 */
public abstract class DAOAbstract {
   public Session session;

    public DAOAbstract() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();        
    }
 
    public abstract void insert(Object objeto);

    public abstract void update(Object objeto);

    public abstract void delete(Object objeto);        
    
    public abstract Object list(int codigo);
    
    public abstract ArrayList listAll();  
  
}
