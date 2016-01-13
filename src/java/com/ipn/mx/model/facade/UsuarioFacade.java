/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.facade;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.dto.Usuario;
import java.util.List;

/**
 *
 * @author JL
 */
public class UsuarioFacade {
    private UsuarioDAO dao;

    public UsuarioFacade() {
        dao = new UsuarioDAO();
    }
    
    public int create(Usuario object) {
        return dao.create(object);
    }

    public void update(Usuario object) {
        dao.update(object);
    }

    public void delete(Usuario object){
        dao.delete(object);
    }

    public Usuario read(Usuario object){
        return dao.read(object);
    }

    public List<Usuario> readAll(int idEdificio){
        return dao.readAll(idEdificio);
    }
    
    public Usuario login(Usuario object){
        return dao.login(object);
    }
    
    public int tipoUsuario(Usuario object){
        return dao.tipoUsuario(object);
    }
    
    public boolean valida(Usuario object){
        return dao.valida(object);
    }
}
