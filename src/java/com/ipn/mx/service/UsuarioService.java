/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.service;

import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Usuario;
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
public class UsuarioService {

    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        usuarios = new SAACDelegate().readAllUsuarios();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}