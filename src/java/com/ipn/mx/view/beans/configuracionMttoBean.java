/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.configuracionMtto;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author JL
 */
public class configuracionMttoBean extends BaseBean{
    
    private configuracionMtto dto;
    private static final String URL_CONTEXT = "/SAAC/faces/Admin/Configuracion/";
    //Formularios para Gas
    private static final String MTTO_FORM = "Mantenimiento.xhtml";
    private int idEdificioSession;

    /**
     * Creates a new instance of configuracionMttoBean
     */
    public configuracionMttoBean() {
        idEdificioSession = 1; //Configurar el id al edificio en session
    }
    
    //Borrar al terminar el proyecto
    public void configMttoPrueba() throws IOException {
        dto = new configuracionMtto();
        redirectTo(URL_CONTEXT + MTTO_FORM);
    }

    //Actions
    public void nuevo() throws IOException {
        dto = new configuracionMtto();
        redirectTo(URL_CONTEXT + MTTO_FORM);

    }

    public void crear() throws IOException {
        SAACDelegate sd = new SAACDelegate();
        Edificio e = new Edificio();
        e.setIdEdificio(idEdificioSession);
        dto.setEdificio(e);
        try {
            int value = sd.create(dto, idEdificioSession);
            if (value == 1) {
                success("INFO: ", "La configuración fue registrada correctamente");
                redirectTo(URL_CONTEXT + MTTO_FORM);
                clearBean();
            } else {
                if (value == 2) {
                    success("INFO: ", "La configuración, ya registrada, fue cambiada correctamente");
                    redirectTo(URL_CONTEXT + MTTO_FORM);
                    clearBean();
                } else {
                    error("ALERTA", "Hubo un problema con el registro enviado, reintenta más tarde");
                    redirectTo(URL_CONTEXT + MTTO_FORM);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al crear el gasto");
            redirectTo(URL_CONTEXT + MTTO_FORM);
        }
    }

    public int getIdConfiguracionMtto() {
        return this.dto.getIdConfiguracionMtto();
    }

    public void setIdConfiguracionMtto(int idConfigGas) {
        this.dto.setIdConfiguracionMtto(idConfigGas);
    }

    public int getPorcentajeCouta() {
        return this.dto.getPorcentajeCouta();
    }

    public void setPorcentajeCouta(int porcentaje) {
        this.dto.setPorcentajeCouta(porcentaje);
    }

    public Date getFechaLimite() {
        return this.dto.getFechaLimite();
    }

    public void setFechaLimite(Date fecha) {
        this.dto.setFechaLimite(fecha);
    }

    public Edificio getIdEdificio() {
        return this.dto.getEdificio();
    }

    public void setIdEdificio(Edificio edificio) {
        this.dto.setEdificio(edificio);
    }

    private void clearBean() {
        this.dto = new configuracionMtto();
    }
    
}
