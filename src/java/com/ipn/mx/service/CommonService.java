package com.ipn.mx.service;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ipn.mx.model.dto.Usuario;

@ManagedBean
@SessionScoped
public class CommonService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4421157468081591340L;
	private Usuario usuario;
	private Object temporalObject;
	private String action;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Object getTemporalObject() {
		return temporalObject;
	}

	public void setTemporalObject(Object temporalObject) {
		this.temporalObject = temporalObject;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "CommonService [usuario=" + usuario + ", temporalObject="
				+ temporalObject + ", action=" + action + "]";
	}
	
	
	
}
