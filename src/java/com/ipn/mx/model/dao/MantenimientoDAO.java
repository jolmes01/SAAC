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
import com.ipn.mx.model.dto.Mantenimiento;
import com.ipn.mx.utils.HibernateUtil;

/**
 *
 * @author JL
 */
public class MantenimientoDAO {
    public int create(Mantenimiento mantenimiento) {
        int value = 1;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.save(mantenimiento);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
                value = 0;
            }
        }
        return value;
    }

    public void update(Mantenimiento mantenimiento) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(mantenimiento);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public void delete(Mantenimiento mantenimiento){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(mantenimiento);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public Mantenimiento read(Mantenimiento mantenimiento){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            mantenimiento = (Mantenimiento) s.get(Mantenimiento.class, mantenimiento.getIdMantenimiento());
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return mantenimiento;
    }

    @SuppressWarnings("unchecked")
	public List<Mantenimiento> readAll(){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Mantenimiento> resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Mantenimiento");
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return resultados;
    }
    
    @SuppressWarnings("unchecked")
	public List<Mantenimiento> getMantenimientosByDepartamento( Departamento departamento ){
    	Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Mantenimiento> resultados = null;
        
        t.begin();
        Query q = s.createQuery("FROM Mantenimiento WHERE idDepartamento = :idDepartamento");
        q.setParameter( "idDepartamento" , departamento.getIdDepartamento() );
        resultados = q.list();
        t.commit();
        
        return resultados;
    }
    
    @SuppressWarnings("unchecked")
	public List<Mantenimiento> getMantenimientosToPay( Departamento departamento ){
    	Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<Mantenimiento> resultados = null;
        
        t.begin();
        Query q = s.createQuery("FROM Mantenimiento WHERE idDepartamento = :idDepartamento AND estado = :status");
        q.setParameter( "idDepartamento" , departamento.getIdDepartamento() );
        q.setParameter( "status" , Mantenimiento.ESTADO_POR_PAGAR );
        resultados = q.list();
        t.commit();
        
        return resultados;
    }
    
}
