/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dao;

import com.ipn.mx.model.dto.configuracionGas;
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
public class configuracionGasDAO {

    public int create(configuracionGas confGas, int idEdificio) {
        int value = 1;
        int existe = 0;
        Session s;
        Transaction t;
        List<configuracionGas> confGasList = readAll(idEdificio);
        if (confGasList != null) {
            existe = confGasList.size();
            s = HibernateUtil.getSessionFactory().getCurrentSession();
            t = s.getTransaction();
        } else {
            return value = 3;
        }
        try {
            t.begin();
            if (existe == 0) {
                s.save(confGas);
            }
            if(existe == 1){
                configuracionGas cg = confGasList.get(0);
                confGas.setEdificio(cg.getEdificio());
                confGas.setIdConfiguracion(cg.getIdConfiguracion());
                s.update(confGas);
                value = 2;
            }
            t.commit();
        } catch (HibernateException he) {
            if (t.isActive() && t != null) {
                t.rollback();
                value = 0;
            }
        }
        return value;
    }

    public void update(configuracionGas confGas) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(confGas);
            t.commit();
        } catch (HibernateException he) {
            if (t.isActive() && t != null) {
                t.rollback();
            }
        }
    }

    public void delete(configuracionGas confGas) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(confGas);
            t.commit();
        } catch (HibernateException he) {
            if (t.isActive() && t != null) {
                t.rollback();
            }
        }
    }

    public configuracionGas read(configuracionGas confGas) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            confGas = (configuracionGas) s.get(configuracionGas.class, confGas.getIdConfiguracion());
            t.commit();
        } catch (HibernateException he) {
            if (t.isActive() && t != null) {
                t.rollback();
            }
        }
        return confGas;
    }

    @SuppressWarnings("unchecked")
	public List<configuracionGas> readAll(int idEdificio) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List<configuracionGas> resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM configuracionGas WHERE idEdificio = :edificio_id");
            q.setParameter("edificio_id", idEdificio);
            resultados = q.list();
            t.commit();
        } catch (HibernateException he) {
            if (t.isActive() && t != null) {
                t.rollback();
            }
        }
        return resultados;
    }
}
