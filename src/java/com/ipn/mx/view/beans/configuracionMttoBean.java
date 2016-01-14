/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import java.io.IOException;
import java.util.Date;

import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.configuracionMtto;
import com.ipn.mx.model.facade.configuracionMttoFacade;

/**
 *
 * @author JL
 */
public class configuracionMttoBean extends BaseBean{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2529783667348449137L;
	private configuracionMtto dto;
    private static final String URL_CONTEXT = "/SAAC/Admin/Configuracion/";
    //Formularios para Gas
    private static final String MTTO_FORM = "Mantenimiento.jsf";
    private int idEdificioSession;

    /**
     * Creates a new instance of configuracionMttoBean
     */
    public configuracionMttoBean() {
    	super( );
    	idEdificioSession = commonService.getUsuario().getEdificio().getIdEdificio(); //Configurar el id al edificio en session
    }
    
    //Borrar al terminar el proyecto
    public void configMttoPrueba() throws IOException {
        //dto = new configuracionMtto();
        redirectTo(URL_CONTEXT + MTTO_FORM);
    }

    //Actions
    public void nuevo() throws IOException {
    	dto = new configuracionMttoFacade( ).readFirst( idEdificioSession );
        redirectTo(URL_CONTEXT + MTTO_FORM);

    }

    public void crear() throws IOException {
        try {
        	new configuracionMttoFacade( ).update( dto );
            success("INFO: ", "La configuración fue registrada correctamente");
            redirectTo(URL_CONTEXT + MTTO_FORM);
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

    
}
