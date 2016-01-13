/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author JL
 */
public class BaseBean {

    protected static final String ACC_CREAR = "CREAR";
    protected static final String ACC_ACTUALIZAR = "ACTUALIZAR";

    protected String accion;

    public BaseBean() {
    }

    protected void error(String idMensaje, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(
                idMensaje, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR, idMensaje, mensaje));
    }
    
    protected void success(String idMensaje, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(
                idMensaje, new FacesMessage(
                        FacesMessage.SEVERITY_INFO, idMensaje, mensaje));
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
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
    
    protected void redirectTo(String ruta) throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        context.getExternalContext().redirect(ruta);
    }

}
