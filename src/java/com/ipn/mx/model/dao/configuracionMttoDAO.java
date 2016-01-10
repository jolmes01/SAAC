/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dao;

import com.ipn.mx.model.dto.configuracionMtto;
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
public class configuracionMttoDAO {
    public int create(configuracionMtto confMtto, int idEdificio) {
        int value = 1;
        int existe = 0;
        Session s;
        Transaction t;
        List<configuracionMtto> confMttoList = readAll(idEdificio);
        if(confMttoList != null){
            existe = confMttoList.size();
            s = HibernateUtil.getSessionFactory().getCurrentSession();
            t = s.getTransaction();
        }else{
            return value = 3;
        }
        try {
            t.begin();
            if(existe == 0){
                s.save(confMtto);
            }else{
                configuracionMtto cm = confMttoList.get(0);
                confMtto.setEdificio(cm.getEdificio());
                confMtto.setIdConfiguracionMtto(cm.getIdConfiguracionMtto());
                s.update(confMtto);
                value = 2;
            }
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
                value = 0;
            }
        }
        return value;
    }

    public void update(configuracionMtto confMtto) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(confMtto);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public void delete(configuracionMtto confMtto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(confMtto);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public configuracionMtto read(configuracionMtto confMtto){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            confMtto = (configuracionMtto) s.get(configuracionMtto.class, confMtto.getIdConfiguracionMtto());
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return confMtto;
    }

    public List readAll(int idEdificio){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM configuracionMtto WHERE idEdificio = :edificio_id");
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
