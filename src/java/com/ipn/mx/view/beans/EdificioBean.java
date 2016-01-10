/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Edificio;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author JL
 */
public class EdificioBean extends BaseBean {
    
    private Edificio dto;
    private static final String URL_CONTEXT = "/SAAC/faces/Admin/Configuracion/";
    //Formularios para Edificio
    private static final String EDIFICIO_FORM = "Edificio.xhtml";

    /**
     * Creates a new instance of EdificioBean
     */
    public EdificioBean() {
        System.err.println("EdificioBean Construido");
    }
    
    //Borrar al terminar el proyecto
    public void edificioPrueba(boolean isNuevo) throws IOException{
        dto = new Edificio();
        setAccion(ACC_CREAR);
        if(isNuevo) redirectTo(URL_CONTEXT + EDIFICIO_FORM);
        else redirectTo(URL_CONTEXT + EDIFICIO_FORM);
    }

    //Actions
    public void nuevo() throws IOException {
        dto = new Edificio();
        setAccion(ACC_CREAR);
        redirectTo(URL_CONTEXT + EDIFICIO_FORM);
        
    }

    public void editar(int idEdificio) throws IOException {
        dto = new Edificio();
        setAccion(ACC_ACTUALIZAR);
        dto = seleccionaEdificio(idEdificio);
        redirectTo(URL_CONTEXT + EDIFICIO_FORM);
    }

    public void consultar() throws IOException {
        redirectTo(URL_CONTEXT + EDIFICIO_FORM);
    }

    public void crear() throws IOException {
        SAACDelegate sd = new SAACDelegate();
        try {
            int value = sd.create(dto);
            if (value == 1) {
                success("INFO: ", "El gasto fue creado satisfactoriamente");
                redirectTo(URL_CONTEXT + EDIFICIO_FORM);
                clearBean();
            } else {
                error("ALERTA", "Hubo un problema con el gasto que quieres crear");
                redirectTo(URL_CONTEXT + EDIFICIO_FORM);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al crear el gasto");
            redirectTo(URL_CONTEXT + EDIFICIO_FORM);
        }
    }

    public void actualizar() throws IOException {
        SAACDelegate sd = new SAACDelegate();
        try {
            sd.update(dto);
            redirectTo(URL_CONTEXT + EDIFICIO_FORM);
            clearBean();
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al actualizar la info del gasto");
            redirectTo(URL_CONTEXT + EDIFICIO_FORM);
        }
    }

    public void borrar(int idEdificio) throws IOException {
        dto = seleccionaEdificio(idEdificio);
        SAACDelegate sd = new SAACDelegate();
        try {
            sd.delete(dto);
            success("Aviso!", "El gasto se borró correctamente");
            redirectTo(URL_CONTEXT + EDIFICIO_FORM);
            clearBean();
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al borrar el gasto");
            redirectTo(URL_CONTEXT + EDIFICIO_FORM);
        }
    }

    public List getLista() {
        SAACDelegate sd = new SAACDelegate();
        try {
            return sd.readAllEdificios();
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Error al mostrar la lista de gastos");
            return null;
        }
    }

    public Edificio seleccionaEdificio(int idEdificio) {
        SAACDelegate sd = new SAACDelegate();
        dto = new Edificio();
        dto.setIdEdificio(idEdificio);
        try {
            dto = sd.read(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dto;
    }
    
    public int getIdEdificio() {
        return this.dto.getIdEdificio();
    }

    public void setIdEdificio(int idEdificio) {
        this.dto.setIdEdificio(idEdificio);
    }

    public String getNombre() {
        return this.dto.getNombre();
    }

    public void setNombre(String nombre) {
        this.dto.setNombre(nombre);
    }

    public String getDireccion() {
        return this.dto.getDireccion();
    }

    public void setDireccion(String direccion) {
        this.dto.setDireccion(direccion);
    }    
    
    private void clearBean(){
        this.dto = new Edificio();
    }
    
}