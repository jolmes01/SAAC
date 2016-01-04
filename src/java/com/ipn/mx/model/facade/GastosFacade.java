/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.GasDAO;
import com.ipn.mx.model.dao.GastosDAO;
import com.ipn.mx.model.dto.Gas;
import com.ipn.mx.model.dto.Gastos;
import java.util.List;

/**
 *
 * @author JL
 */
public class GastosFacade {
    private GastosDAO dao;

    public GastosFacade() {
        dao = new GastosDAO();
    }
    
    public int create(Gastos object) {
        return dao.create(object);
    }

    public void update(Gastos object) {
        dao.update(object);
    }

    public void delete(Gastos object){
        dao.delete(object);
    }

    public Gastos read(Gastos object){
        return dao.read(object);
    }

    public List readAll(){
        return dao.readAll();
    }
}
