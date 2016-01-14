/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import java.io.IOException;
import java.util.Date;

import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.configuracionGas;
import com.ipn.mx.model.facade.configuracionGasFacade;

/**
 *
 * @author JL
 */
public class configuracionGasBean extends BaseBean {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8992429802930033233L;
	private configuracionGas dto;
    private static final String URL_CONTEXT = "/SAAC/Admin/Configuracion/";
    //Formularios para Gas
    private static final String GAS_FORM = "Gas.jsf";
    private int idEdificioSession;

    /**
     * Creates a new instance of configuracionGasBean
     */
    public configuracionGasBean() {
    	super( );
        idEdificioSession = commonService.getUsuario().getEdificio().getIdEdificio(); //Configurar el id al edificio en session
    }

    //Borrar al terminar el proyecto
    public void configGasPrueba() throws IOException {
        dto = new configuracionGas();
        redirectTo(URL_CONTEXT + GAS_FORM);
    }

    //Actions
    public void nuevo() throws IOException {
    	dto = new configuracionGasFacade( ).readFirst( idEdificioSession );
        redirectTo(URL_CONTEXT + GAS_FORM);

    }

    public void crear() throws IOException {
        try {
        	new configuracionGasFacade( ).update( dto );
            success("INFO: ", "La configuración fue registrada correctamente");
            redirectTo(URL_CONTEXT + GAS_FORM);
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al crear el gasto");
            redirectTo(URL_CONTEXT + GAS_FORM);
        }
    }

    public int getIdConfiguracion() {
        return this.dto.getIdConfiguracion();
    }

    public void setIdConfiguracion(int idConfigGas) {
        this.dto.setIdConfiguracion(idConfigGas);
    }

    public double getCostoLitro() {
        return this.dto.getCostoLitro();
    }

    public void setCostoLitro(double costo) {
        this.dto.setCostoLitro(costo);
    }

    public Date getFechaLimite() {
        return this.dto.getFechaLimite();
    }

    public void setFechaLimite(Date fecha) {
        this.dto.setFechaLimite(fecha);
    }

    public Edificio getEdificio() {
        return this.dto.getEdificio();
    }

    public void setEdificio(Edificio edificio) {
        this.dto.setEdificio(edificio);
    }

}
