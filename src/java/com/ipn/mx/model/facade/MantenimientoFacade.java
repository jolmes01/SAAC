/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import java.util.List;

import com.ipn.mx.model.dao.MantenimientoDAO;
import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Mantenimiento;

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

    public List<Mantenimiento> readAll(){
        return dao.readAll();
    }
    
    public List<Mantenimiento> getMantenimientosByDepartamento( Departamento departamento ){
    	return dao.getMantenimientosByDepartamento( departamento );
    }
    
    public List<Mantenimiento> getMantenimientosToPay( Departamento departamento) {
    	return dao.getMantenimientosToPay( departamento );
    }
    
    
    
}
