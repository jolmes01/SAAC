/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Gas;
import com.ipn.mx.utils.HibernateUtil;

/**
 *
 * @author JL
 */
public class GasDAO {
    public int create(Gas gas) {
        int value = 1;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.save(gas);
            t.commit();
        }catch(HibernateException he){
        	he.printStackTrace( );
            if(t.isActive() && t != null){
                t.rollback();
                value = 0;
            }
        }
        return value;
    }

    public void update(Gas gas) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(gas);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public void delete(Gas gas){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(gas);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public Gas read(Gas gas){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            gas = (Gas) s.get(Gas.class, gas.getIdGas());
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return gas;
    }
    
    @SuppressWarnings("unchecked")
	public List<Gas> getGasByDepartamento( Departamento departamento ){
    	Session session = HibernateUtil.getSessionFactory( ).getCurrentSession( );
    	Transaction transaction = session.getTransaction( );
    	List<Gas> results = null;
    	Query query = null;
    	
		transaction.begin( );
		query = session.createQuery( "FROM Gas WHERE idDepartamento = :idDepartamento" );
		query.setParameter( "idDepartamento" , departamento.getIdDepartamento() );
		results = query.list( );
    	transaction.commit( );
    	
    	return results;
    }
    
    @SuppressWarnings("unchecked")
	public List<Gas> getGasToPay( Departamento departamento ){
    	Session session = HibernateUtil.getSessionFactory( ).getCurrentSession( );
    	Transaction transaction = session.getTransaction( );
    	List<Gas> results = null;
    	Query query = null;
    	
		transaction.begin( );
		query = session.createQuery( "FROM Gas WHERE idDepartamento = :idDepartamento AND estado = :status" );
		query.setParameter( "idDepartamento" , departamento.getIdDepartamento() );
		query.setParameter( "status" , Gas.ESTADO_POR_PAGAR );
		results = query.list( );
    	transaction.commit( );
    	
    	return results;
    }

    @SuppressWarnings("unchecked")
	public List<Gas> readAll(){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Gas> resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Gas");
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return resultados;
    }
    
}
