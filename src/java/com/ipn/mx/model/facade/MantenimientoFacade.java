/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.MantenimientoDAO;
import com.ipn.mx.model.dto.Mantenimiento;
import java.util.List;

/**
 *
 * @author JL
 */
public class MantenimientoFacade {
    private MantenimientoDAO dao;

    public MantenimientoFacade() {
        dao = new MantenimientoDAO();
    }
    
    public int create(Mantenimiento object) {
        return dao.create(object);
    }

    public void update(Mantenimiento object) {
        dao.update(object);
    }

    public void delete(Mantenimiento object){
        dao.delete(object);
    }

    public Mantenimiento read(Mantenimiento object){
        return dao.read(object);
    }

    public List readAll(){
        return dao.readAll();
    }
}
