/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.service;

import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Usuario;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author JL
 */
@ManagedBean(name = "usuarioService", eager = true)
@ApplicationScoped
public class UsuarioService implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4141121076661239655L;
	private List<Usuario> usuarios;
    private int idEdificioSession;

    @PostConstruct
    public void init() {
        idEdificioSession = 1; //Obtener valor de la session
        usuarios = new SAACDelegate().readAllUsuarios(idEdificioSession);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
