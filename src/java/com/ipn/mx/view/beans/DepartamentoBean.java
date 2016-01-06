/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import com.ipn.mx.model.dao.DepartamentoDAO;
import com.ipn.mx.service.UsuarioService;
import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.utils.CodeGenerator;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author JL
 */
@ManagedBean(name = "DepartamentoBean")
@SessionScoped
public class DepartamentoBean {

    private boolean flag;

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

    public DepartamentoBean() {
        System.err.println("DepartamentoBean Construido");
        URL_CONTEXT = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath() + "/faces/";
        flag = false;
    }
    
    public String deptoPrueba(boolean isNuevo){
        dto = new Departamento();
        setFlag(true);
        if(isNuevo) return "Admin/Departamentos/Departamento.xhtml";
        else return "Admin/Departamentos/Consulta_Departamentos.xhtml";
    }

    //Actions
    public String nuevo(boolean isExterno) {
        dto = new Departamento();
        setFlag(true);
        if (isExterno) {
            return "Departamentos/Departamento.xhtml";
        } else {
            return "Departamento.xhtml";
        }
    }

    public String editar(int idDepartamento, int idEdificio) {
        dto = new Departamento();
        setFlag(false);
        dto = seleccionaDepartamento(idDepartamento, idEdificio);
        return "Departamento.xhtml";
    }

    public String consultar(boolean isExterno) {
        if (isExterno) {
            return "Departamentos/Consultar_Departamentos.xhtml";
        } else {
            return "Consulta_Departamentos.xhtml";
        }
    }

    public String crear() throws IOException {
        Edificio e = new Edificio();
        e.setIdEdificio(1);
        dto.setEdificio(e);
        dto.setCodigoQR(CodeGenerator.generateSHA(dto.getUsuario().getUserName() + dto.getUsuario().getClaveUser() + dto.getIdDepartamento()));
        String directorio = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
        DepartamentoDAO.writeQR(dto, directorio);
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
            return "Consulta_Departamentos.xhtml";
        } catch (Exception ex) {
            ex.printStackTrace();
            error("error editando Depto", "Hubo un error al actualizar la info del departamento");
            return "Consulta_Departamentos.xhtml";
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

    public List getLista() {
        SAACDelegate sd = new SAACDelegate();
        try {
            return sd.readAllDepartamentos(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            error("ERROR! :C", "Error al mostrar la lista de artículos");
            return null;
        }
    }

    public Departamento seleccionaDepartamento(int idDepartamento, int idEdificio) {
        SAACDelegate sd = new SAACDelegate();
        Edificio e = new Edificio();
        e.setIdEdificio(idEdificio);
        dto = new Departamento();
        dto.setIdDepartamento(idDepartamento);
        dto.setEdificio(e);
        try {
            dto = sd.read(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dto;
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

    public void setFlag(boolean value) {
        this.flag = value;
        System.out.println("Asignado valo: " + flag);
    }

    public boolean getFlag() {
        return this.flag;
    }

    public boolean isModoCrear() {
        if (flag == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isModoActualizar() {
        if (flag == false) {
            return true;
        } else {
            return false;
        }
    }
}
