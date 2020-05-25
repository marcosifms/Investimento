/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcos
 */
public class InvestimentoDiarioDAO extends DAOAbstract {
    private Object beanBanco;
    
    @Override
    public void insert(Object objeto) {
        session.beginTransaction();
        session.save(objeto);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object objeto) {
        session.beginTransaction();
	session.flush();
	session.clear();	        
        session.update(objeto);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object objeto) {
        session.beginTransaction();
	session.flush();
	session.clear();	        
        session.delete(objeto);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(beanBanco.getClass());
        criteria.add(Restrictions.eq("idusuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista.get(0);
    }

    @Override
    public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(beanBanco.getClass());
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
    }

    /**
     * @return the beanBanco
     */
    public Object getBeanBanco() {
        return beanBanco;
    }

    /**
     * @param beanBanco the beanBanco to set
     */
    public void setBeanBanco(Object beanBanco) {
        this.beanBanco = beanBanco;
    }
    
}
