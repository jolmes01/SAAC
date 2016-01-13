/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dao;

import com.ipn.mx.model.dto.Ingresos;
import com.ipn.mx.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JL
 */
public class IngresosDAO {
    public int create(Ingresos ingreso) {
        int value = 1;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.save(ingreso);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
                value = 0;
            }
        }
        return value;
    }

    public void update(Ingresos ingreso) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(ingreso);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public void delete(Ingresos ingreso){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(ingreso);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public Ingresos read(Ingresos ingreso){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            ingreso = (Ingresos) s.get(Ingresos.class, ingreso.getIdIngreso());
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return ingreso;
    }

    public List readAll(int idEdificio){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Ingresos WHERE idEdificio = :edificio_id");
            q.setParameter("edificio_id", idEdificio);
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
