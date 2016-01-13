/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.DepartamentoDAO;
import com.ipn.mx.model.dto.Departamento;
import java.util.List;

/**
 *
 * @author JL
 */
public class DepartamentoFacade {
    private DepartamentoDAO dao;

    public DepartamentoFacade() {
        dao = new DepartamentoDAO();
    }
    
    public boolean create(Departamento departamento) {
        return dao.create(departamento);
    }

    public void update(Departamento departamento) {
        dao.update(departamento);
    }

    public boolean delete(Departamento departamento){
        return dao.delete(departamento);
    }

    public Departamento read(Departamento departamento){
        return dao.read(departamento);
    }

    public List<Departamento> readAll(int idEdificio){
        return dao.readAll(idEdificio);
    }
}
