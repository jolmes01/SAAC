/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import java.io.IOException;
import java.io.Serializable;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.ipn.mx.service.CommonService;

/**
 *
 * @author JL
 */
public class BaseBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5281964660181133826L;
	protected static final String ACC_CREAR = "CREAR";
    protected static final String ACC_ACTUALIZAR = "ACTUALIZAR";
    protected CommonService commonService;

    protected String accion;

    public BaseBean() {
    	begin( );
    }
    
    public void begin( ){
    	commonService = Faces.getSessionAttribute( "commonService" );
    	
    	accion = commonService.getAction( );
    	System.out.println( commonService );
    }

    protected void error(String idMensaje, String mensaje) {
    	Messages.addError( idMensaje, mensaje );
    }
    
    protected void success(String idMensaje, String mensaje) {
    	Messages.addInfo( idMensaje, mensaje );
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion( String accion ) {
    	commonService.setAction( accion );
        this.accion = accion;
    }

    public boolean isModoCrear() {
        if (accion != null) {
            System.out.println("MODO_CREAR: " + accion.equals(ACC_CREAR));
            return accion.equals(ACC_CREAR);
        } else {
            System.out.println("MODO_CREAR: false");
            return false;
        }
    }

    public boolean isModoActualizar() {
        if (accion != null) {
            System.out.println("MODO_ACTUALIZAR: " + accion.equals(ACC_ACTUALIZAR));
            return accion.equals(ACC_ACTUALIZAR);
        } else {
            System.out.println("MODO_ACTUALIZAR: false");
            return false;
        }
    }
    
    protected void redirectTo(String path, String... params ) {
        Faces.getFlash( ).setKeepMessages( true );
        Faces.setSessionAttribute( "commonService", commonService);
        try {
			Faces.redirect( path, params );
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
