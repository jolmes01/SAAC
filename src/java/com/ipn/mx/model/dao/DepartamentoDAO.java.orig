/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.utils.CodeGenerator;
import com.ipn.mx.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author JL
 */
public class DepartamentoDAO {

    public int create(Departamento departamento) {
        int value = 1;
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.save(departamento);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
                value = 0;
            }
        }
        System.err.println(value);
        return value;
    }

    public void update(Departamento departamento) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.update(departamento);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public void delete(Departamento departamento){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        try {
            t.begin();
            s.delete(departamento);
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
    }

    public Departamento read(Departamento departamento){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Departamento WHERE idDepartamento = :deptartamento_idDepartamento AND idEdificio = :departamento_idEdificio");
            q.setParameter("deptartamento_idDepartamento", departamento.getIdDepartamento());
            q.setParameter("departamento_idEdificio", departamento.getEdificio().getIdEdificio());
            resultados = q.list();
            t.commit();
            if(resultados.size() > 0){
                departamento = (Departamento) resultados.get(0);
            }else{
                departamento = null;
            }
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return departamento;
    }

    public List readAll(int idEdificio){
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = s.getTransaction();
        List resultados = null;
        try {
            t.begin();
            Query q = s.createQuery("FROM Departamento WHERE idEdificio = :departamento_id");
            q.setParameter("departamento_id", idEdificio);
            resultados = q.list();
            t.commit();
        }catch(HibernateException he){
            if(t.isActive() && t != null){
                t.rollback();
            }
        }
        return resultados;
    }

    public static void writeQR(Departamento departamento, String directorio) throws IOException {
        byte[] image = null;
        FileOutputStream fos = null;
        File file = null;
        String path = null;

        path = directorio + "/QR/" + System.currentTimeMillis() + ".png";
        image = CodeGenerator.generateQR(departamento.getCodigoQR(), "png");
        if (image == null || image.length < 1) {
            return;
        }
        file = new File(path);
        fos = new FileOutputStream(file);
        fos.write(image);
        fos.close();

        departamento.setQrLength(image.length);
        departamento.setQrPath(path);
    }
}
