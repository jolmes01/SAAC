/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.EdificioDAO;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Edificio;
import java.util.List;

/**
 *
 * @author JL
 */
public class EdificioFacade {
    private EdificioDAO dao;

    public EdificioFacade() {
        dao = new EdificioDAO();
    }
    
    public int create(Edificio object) {
        return dao.create(object);
    }

    public void update(Edificio object) {
        dao.update(object);
    }

    public void delete(Edificio object){
        dao.delete(object);
    }

    public Edificio read(Edificio object){
        return dao.read(object);
    }

    public List readAll(){
        return dao.readAll();
    }
}
