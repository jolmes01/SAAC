/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.configuracionMttoDAO;
import com.ipn.mx.model.dto.configuracionMtto;
import java.util.List;

/**
 *
 * @author JL
 */
public class configuracionMttoFacade {
    private configuracionMttoDAO dao;

    public configuracionMttoFacade() {
        dao = new configuracionMttoDAO();
    }
    
    public int create(configuracionMtto object) {
        return dao.create(object);
    }

    public void update(configuracionMtto object) {
        dao.update(object);
    }

    public void delete(configuracionMtto object){
        dao.delete(object);
    }

    public configuracionMtto read(configuracionMtto object){
        return dao.read(object);
    }

    public List readAll(){
        return dao.readAll();
    }
}
