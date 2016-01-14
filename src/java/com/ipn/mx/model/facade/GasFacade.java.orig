/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.GasDAO;
import com.ipn.mx.model.dto.Gas;
import java.util.List;

/**
 *
 * @author JL
 */
public class GasFacade {
    private GasDAO dao;

    public GasFacade() {
        dao = new GasDAO();
    }
    
    public int create(Gas object) {
        return dao.create(object);
    }

    public void update(Gas object) {
        dao.update(object);
    }

    public void delete(Gas object){
        dao.delete(object);
    }

    public Gas read(Gas object){
        return dao.read(object);
    }

    public List readAll(){
        return dao.readAll();
    }
}
