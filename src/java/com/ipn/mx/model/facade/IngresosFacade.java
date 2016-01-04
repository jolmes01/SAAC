/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.IngresosDAO;
import com.ipn.mx.model.dto.Ingresos;
import java.util.List;

/**
 *
 * @author JL
 */
public class IngresosFacade {
    private IngresosDAO dao;

    public IngresosFacade() {
        dao = new IngresosDAO();
    }
    
    public int create(Ingresos object) {
        return dao.create(object);
    }

    public void update(Ingresos object) {
        dao.update(object);
    }

    public void delete(Ingresos object){
        dao.delete(object);
    }

    public Ingresos read(Ingresos object){
        return dao.read(object);
    }

    public List readAll(){
        return dao.readAll();
    }
}
