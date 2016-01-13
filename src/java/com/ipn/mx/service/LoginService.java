package com.ipn.mx.service;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.dto.Usuario;

@ManagedBean
@ViewScoped
public class LoginService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -876053929607795888L;
	private String user;
	private String pass;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void login( ){
		CommonService commonService = null;
        UsuarioDAO uDAO = new UsuarioDAO();
        Usuario u = new Usuario();
        
        u.setUserName( user );
        u.setClaveUser( pass );
        
        try {
        	u = uDAO.login( u );
	        if ( u != null ) {
	            if ( uDAO.tipoUsuario( u ) == 1 ) {
	            	commonService = new CommonService( );
	                HttpSession session = Faces.getSession( true );
	                session.setAttribute("session", true);
	                session.setAttribute("userName", u.getUserName());
	                session.setAttribute("Edificio", "1");
	                commonService.setUsuario( u );
	                Faces.setSessionAttribute( "commonService", commonService );
					Faces.redirect( "Admin/Administrador.jsf" );
	            }
	            if (uDAO.tipoUsuario(u) == 2) {
	                HttpSession session = Faces.getSession( true );
	                session.setAttribute("session", true);
	                session.setAttribute("userName", u.getUserName());
	                session.setAttribute("Edificio", "1");
	                Faces.redirect( "Usuario/Condomino.jsp" );
	            }
	            if (uDAO.tipoUsuario(u) == 0) {
	            	System.err.println( "Tipo de usuario no reconocido" );
	            }
	        } else {
	        	System.out.println( "Usuario o contrasña erronreos" );
	        	Messages.addWarn( "errorLogin", "El usuario o la contrase\u00f1a son incorrectos" );
	        }
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public void logout( ){
		Faces.removeSessionAttribute( "commonService" );
		Faces.invalidateSession( );
		try {
			Faces.redirect( "/SAAC/" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
