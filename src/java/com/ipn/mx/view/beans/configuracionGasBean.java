/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.configuracionGas;
import static com.ipn.mx.view.beans.BaseBean.ACC_CREAR;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JL
 */
public class configuracionGasBean extends BaseBean {

    private configuracionGas dto;
    private static final String URL_CONTEXT = "/SAAC/faces/Admin/Configuracion/";
    //Formularios para Gas
    private static final String GAS_FORM = "Gas.xhtml";
    private int idEdificioSession;

    /**
     * Creates a new instance of configuracionGasBean
     */
    public configuracionGasBean() {
        idEdificioSession = 1; //Configurar el id al edificio en session
    }

    //Borrar al terminar el proyecto
    public void configGasPrueba() throws IOException {
        dto = new configuracionGas();
        redirectTo(URL_CONTEXT + GAS_FORM);
    }

    //Actions
    public void nuevo() throws IOException {
        dto = new configuracionGas();
        redirectTo(URL_CONTEXT + GAS_FORM);

    }

    public void crear() throws IOException {
        SAACDelegate sd = new SAACDelegate();
        Edificio e = new Edificio();
        e.setIdEdificio(idEdificioSession);
        dto.setEdificio(e);
        try {
            int value = sd.create(dto, idEdificioSession);
            System.out.println(value);
            if (value == 1) {
                success("INFO: ", "La configuración fue registrada correctamente");
                redirectTo(URL_CONTEXT + GAS_FORM);
                clearBean();
            } else {
                if (value == 2) {
                    success("INFO: ", "La configuración, ya registrada, fue cambiada correctamente");
                    redirectTo(URL_CONTEXT + GAS_FORM);
                    clearBean();
                } else {
                    error("ALERTA", "Hubo un problema con el registro enviado, reintenta más tarde");
                    redirectTo(URL_CONTEXT + GAS_FORM);
                }
            }
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

    private void clearBean() {
        this.dto = new configuracionGas();
    }

}
