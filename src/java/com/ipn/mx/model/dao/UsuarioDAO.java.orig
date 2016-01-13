/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dao;

import com.ipn.mx.model.dto.Usuario;
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
public class UsuarioDAO {
    public int create(Usuario usuario) {
        int value = 1;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.save(usuario);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
                value = 0;
            }
        }
        return value;
    }

    public void update(Usuario usuario) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(usuario);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public void delete(Usuario usuario){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(usuario);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public Usuario read(Usuario usuario){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            usuario = (Usuario) s.get(Usuario.class, usuario.getIdUsuario());
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return usuario;
    }

    public List readAll(int idEdificio){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Usuario WHERE idEdificio = :edificio_id");
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
    
    public boolean login(Usuario usuario){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Usuario U WHERE U.userName = :usuario_user AND U.claveUser = :usuario_clave");
            q.setParameter("usuario_user", usuario.getUserName());
            q.setParameter("usuario_clave", usuario.getClaveUser());
            resultados = q.list();
            t.commit();
            if(resultados.size() > 0) return true;
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return false;
    }
    
    public int tipoUsuario(Usuario usuario){
        int idTipoUsuario = 0;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("SELECT U.tipoUsuario FROM Usuario U WHERE U.userName = :usuario_user AND U.claveUser = :usuario_clave");
            q.setParameter("usuario_user", usuario.getUserName());
            q.setParameter("usuario_clave", usuario.getClaveUser());
            resultados = q.list();
            t.commit();
            if(resultados.size() > 0){
                idTipoUsuario = (Integer) resultados.get(0);
            }
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return idTipoUsuario;
    }
    
    public boolean valida(Usuario usuario){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Usuario U WHERE U.userName = :usuario_user");
            q.setParameter("usuario_user", usuario.getUserName());
            resultados = q.list();
            t.commit();
            if(resultados.size() > 0){
                return true;
            }
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return false;
    }
}