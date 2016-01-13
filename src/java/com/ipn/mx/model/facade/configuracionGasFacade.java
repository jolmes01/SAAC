/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.configuracionGasDAO;
import com.ipn.mx.model.dto.configuracionGas;
import java.util.List;

/**
 *
 * @author JL
 */
public class configuracionGasFacade {
    private configuracionGasDAO dao;

    public configuracionGasFacade() {
        dao = new configuracionGasDAO();
    }
    
    public int create(configuracionGas object, int idEdificio) {
        return dao.create(object,idEdificio);
    }

    public void update(configuracionGas object) {
        dao.update(object);
    }

    public void delete(configuracionGas object){
        dao.delete(object);
    }

    public configuracionGas read(configuracionGas object){
        return dao.read(object);
    }

    public List readAll(int idEdificio){
        return dao.readAll(idEdificio);
    }
}
