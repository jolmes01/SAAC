/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import com.ipn.mx.service.UsuarioService;
import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author JL
 */
@ManagedBean(name = "DepartamentoBean1")
@SessionScoped
public class DepartamentoBean1 {
    
    private static final String ACC_CREAR = "CREAR";
    private static final String ACC_ACTUALIZAR = "ACTUALIZAR";

    private String accion;

    private Departamento dto;
    private List<Usuario> usuarios;
    private List<Edificio> edificios;
    private String URL_CONTEXT;

    @ManagedProperty("#{usuarioService}")
    private UsuarioService service;

    @PostConstruct
    public void init() {
        usuarios = service.getUsuarios();
    }

    public DepartamentoBean1() {
        URL_CONTEXT = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/";
    }

    //Actions
    public String nuevo() {
        dto = new Departamento();
        setAccion(ACC_CREAR);
        return URL_CONTEXT + "Admin/Departamentos/Departamento.xhtml";
    }
    
    public String editar() {
        setAccion(ACC_ACTUALIZAR);
        return "Departamento.xhtml";
    }

    public String consultar() {
        return URL_CONTEXT + "Admin/Departamentos/Consulta_Departamentos.xhtml";
    }

    public String crear() {
        Edificio e = new Edificio();
        e.setIdEdificio(1);
        dto.setEdificio(e);
        SAACDelegate sd = new SAACDelegate();
        try {
            int value = sd.create(dto);
            if (value == 1) {
                success("INFO: ", "El departamento fue creado satisfactoriamente");
                return "Consulta_Departamentos.xhtml";
            } else {
                error("ALERTA", "El departamento que quieres crear ya existe");
                return "Departamento.xhtml";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            error("error creando Depto", "Hubo un error al crear el departamento");
            return "Departamento.xhtml";
        }
    }

    public String actualizar() {
        Edificio e = new Edificio();
        e.setIdEdificio(1);
        dto.setEdificio(e);
        SAACDelegate sd = new SAACDelegate();
        try {
            sd.update(dto);
            return URL_CONTEXT + "Consulta_Departamentos.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            error("error editando Depto", "Hubo un error al actualizar la info del departamento");
            return URL_CONTEXT + "Consulta_Departamentos.xhtml";
        }
    }

    public String borrar() {
        SAACDelegate sd = new SAACDelegate();
        try {
            sd.delete(dto);
            return "Consulta_Departamentos.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            error("error editando Depto", "Hubo un error al borrar el departamento");
            return "Consulta_Departamentos.xhtml";
        }
    }
    
    public List getLista(){
        SAACDelegate sd = new SAACDelegate();
        try{
            return sd.readAllDepartamentos(1);
        }catch(Exception ex){
            ex.printStackTrace();
            error("ERROR! :C", "Error al mostrar la lista de artículos");
            return null;
        }
    }
    
    public void seleccionaDepartamento(){
        setAccion(ACC_ACTUALIZAR);
        SAACDelegate sd = new SAACDelegate();
        String claveDepto = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("claveDepto");
        String claveEdificio = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("claveEdificio");
        Edificio e = new Edificio();
        e.setIdEdificio(Integer.parseInt(claveEdificio));
        dto = new Departamento();
        dto.setIdDepartamento(Integer.parseInt(claveDepto));
        dto.setEdificio(e);
        try{
            dto = sd.read(dto);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //Getters and setters    
    public int getIdDepartamento() {
        return dto.getIdDepartamento();
    }

    public void setIdDepartamento(int idDepartamento) {
        dto.setIdDepartamento(idDepartamento);
    }

    public Usuario getUsuario() {
        return dto.getUsuario();
    }

    public void setUsuario(Usuario usuario) {
        dto.setUsuario(usuario);
    }

    public Edificio getEdificio() {
        return dto.getEdificio();
    }

    public void setEdificio(Edificio edificio) {
        dto.setEdificio(edificio);
    }

    public int getPersonas() {
        return dto.getPersonas();
    }

    public void setPersonas(int personas) {
        dto.setPersonas(personas);
    }

    public String getCodigoQR() {
        return dto.getCodigoQR();
    }

    public void setCodigoQR(String codigoQR) {
        dto.setCodigoQR(codigoQR);
    }

    public BigDecimal getSaldoFavor() {
        return dto.getSaldoFavor();
    }

    public void setSaldoFavor(BigDecimal saldoFavor) {
        dto.setSaldoFavor(saldoFavor);
    }

    public String getQrPath() {
        return dto.getQrPath();
    }

    public void setQrPath(String qrPath) {
        dto.setQrPath(qrPath);
    }

    public int getQrLength() {
        return dto.getQrLength();
    }

    public void setQrLength(int qrLength) {
        dto.setQrLength(qrLength);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setService(UsuarioService service) {
        this.service = service;
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
}
