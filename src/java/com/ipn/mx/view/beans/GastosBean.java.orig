/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Gastos;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JL
 */
public class GastosBean extends BaseBean{
    
    private Gastos dto;
    private int idEdificioSession;
    private static final String URL_CONTEXT = "/SAAC/faces/Admin/Gastos/";
    //Formularios para Gastos
    private static final String GASTO_FORM = "Gasto.xhtml";
    private static final String CONSULTA_GASTOS_FORM = "Consulta_Gastos.xhtml";

    /**
     * Creates a new instance of GastosBean
     */
    public GastosBean() {
        //Asignar al siguiente elemento la session activa con el identificador del edificio
        idEdificioSession = 1;
        System.err.println("GastosBean Construido");
    }
    
    //Borrar al terminar el proyecto
    public void gastoPrueba(boolean isNuevo) throws IOException{
        dto = new Gastos();
        setAccion(ACC_CREAR);
        if(isNuevo) redirectTo(URL_CONTEXT + GASTO_FORM);
        else redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
    }

    //Actions
    public void nuevo() throws IOException {
        dto = new Gastos();
        setAccion(ACC_CREAR);
        redirectTo(URL_CONTEXT + GASTO_FORM);
        
    }

    public void editar(int idGastos, int idEdificio) throws IOException {
        dto = new Gastos();
        setAccion(ACC_ACTUALIZAR);
        dto = seleccionaGastos(idGastos, idEdificio);
        redirectTo(URL_CONTEXT + GASTO_FORM);
    }

    public void consultar() throws IOException {
        redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
    }

    public void crear() throws IOException {
        dto.setIdEdificio(idEdificioSession); //Cuando se agreguen las sesiones agregar el identificador obtenido de la sesion actual
        SAACDelegate sd = new SAACDelegate();
        try {
            int value = sd.create(dto);
            if (value == 1) {
                success("INFO: ", "El gasto fue creado satisfactoriamente");
                redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
                clearBean();
            } else {
                error("ALERTA", "Hubo un problema con el gasto que quieres crear");
                redirectTo(URL_CONTEXT + GASTO_FORM);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al crear el gasto");
            redirectTo(URL_CONTEXT + GASTO_FORM);
        }
    }

    public void actualizar() throws IOException {
        dto.setIdEdificio(idEdificioSession);
        SAACDelegate sd = new SAACDelegate();
        try {
            sd.update(dto);
            redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
            clearBean();
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al actualizar la info del gasto");
            redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
        }
    }

    public void borrar(int idGastos, int idEdificio) throws IOException {
        dto = seleccionaGastos(idGastos, idEdificio);
        SAACDelegate sd = new SAACDelegate();
        try {
            sd.delete(dto);
            success("Aviso!", "El gasto se borró correctamente");
            redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
            clearBean();
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Hubo un error al borrar el gasto");
            redirectTo(URL_CONTEXT + CONSULTA_GASTOS_FORM);
        }
    }

    public List getLista() {
        SAACDelegate sd = new SAACDelegate();
        try {
            return sd.readAllGastos(idEdificioSession);
        } catch (Exception ex) {
            ex.printStackTrace();
            error("Houston tenemos un problema... :C", "Error al mostrar la lista de gastos");
            return null;
        }
    }

    public Gastos seleccionaGastos(int idGastos, int idEdificio) {
        SAACDelegate sd = new SAACDelegate();
        dto = new Gastos();
        dto.setIdGasto(idGastos);
        dto.setIdEdificio(idEdificio);
        try {
            dto = sd.read(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    //Getters and setters    
    public int getIdGasto() {
        return dto.getIdGasto();
    }

    public void setIdGasto(int idGastos) {
        dto.setIdGasto(idGastos);
    }

    public String getConcepto(){
        return this.dto.getConcepto();
    }
    
    public void setConcepto(String concepto){
        this.dto.setConcepto(concepto);
    }
    
    public double getImporte(){
        return this.dto.getImporte();
    }
    
    public void setImporte(double importe){
        this.dto.setImporte(importe);
    }
    
    public int getIdEdificio(){
        return this.dto.getIdEdificio();
    }
    
    public void setIdEdificio(int idEdificio){
        this.dto.setIdEdificio(idEdificio);
    }
    
    public Date getFechaGasto(){
        return this.dto.getFechaGasto();
    }
    
    public void setFechaGasto(Date fecha) throws ParseException{
        this.dto.setFechaGasto(fecha);
        System.out.println(fecha.toString());
    }
    
    private void clearBean(){
        this.dto = new Gastos();
    }
}