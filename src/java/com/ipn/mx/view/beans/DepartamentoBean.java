/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.view.beans;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.ipn.mx.model.dao.DepartamentoDAO;
import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.delegate.SAACDelegate;
import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.service.UsuarioService;
import com.ipn.mx.utils.CodeGenerator;

@ManagedBean
@SessionScoped
public class DepartamentoBean extends BaseBean {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 183737522623102520L;
	private int idEdificioSession;
	private static final String QR_PATH = "/home/sonk/Dropbox/Escuela/Ingenieria de software/development/webApp/SAAC/WebContent/";

    private Departamento dto;
    //private List<Edificio> edificios;
    private static final String URL_CONTEXT = "/SAAC/Admin/Departamentos/";
    //Formularios para Departamentos
    private static final String DEPARTAMENTO_FORM = "Departamento.jsf";
    private static final String CONSULTA_DEPARTAMENTOS_FORM = "Consulta_Departamentos.jsf";
    private int usuarioId;

    @ManagedProperty("#{usuarioService}")
    private UsuarioService service;
    
    public DepartamentoBean() {
    	begin( );
    }
    
    @Override
    public void begin() {
    	super.begin();
    	if( commonService.getTemporalObject() instanceof Departamento ){    		
    		dto = (Departamento) commonService.getTemporalObject( );
    	}
    	if( ACC_ACTUALIZAR.equals( commonService.getAction() ) ){
    		usuarioId = dto.getUsuario().getIdUsuario();
    	}
        //Asignar al siguiente elemento el valor del idEdificio asignado en la session activa
        idEdificioSession = 1;
    }

    @PostConstruct
    public void init() {
    	begin( );
    	if( service == null ){
    		service = new UsuarioService( );
    	}
    }

   
    
    //TODO: Borrar al terminar el proyecto
    public void deptoPrueba(boolean isNuevo) throws IOException{
        dto = new Departamento();
        commonService.setTemporalObject( dto );
        setAccion( ACC_CREAR );
        if( isNuevo ){ 
        	redirectTo(URL_CONTEXT + DEPARTAMENTO_FORM);
        }
        else{
        	redirectTo(URL_CONTEXT + CONSULTA_DEPARTAMENTOS_FORM);
        }
    }

    //Actions
    public void nuevo(){
        dto = new Departamento( );
        dto.setUsuario( new Usuario( ) );
        System.out.println( "NUEVO" );
        commonService.setTemporalObject( dto );
        setAccion( ACC_CREAR );
        redirectTo( URL_CONTEXT + DEPARTAMENTO_FORM );
    }
    
    public void nuevo( boolean xd ) {
    	nuevo( );
    }

    public void editar( Departamento departamento ){
    	editar( departamento.getIdDepartamento(), departamento.getEdificio().getIdEdificio() );
    }
    
    public void editar(int idDepartamento, int idEdificio){
        dto = new Departamento();
        setAccion(ACC_ACTUALIZAR);
        dto = seleccionaDepartamento(idDepartamento, idEdificio);
        redirectTo(URL_CONTEXT + DEPARTAMENTO_FORM);
    }

    public void consultar() throws IOException {
        redirectTo(URL_CONTEXT + CONSULTA_DEPARTAMENTOS_FORM);
    }

    public void crear() throws IOException {
        Edificio e = new Edificio();
        Usuario usuario = new UsuarioDAO( ).read( new Usuario( usuarioId ) );
        
        e.setIdEdificio(idEdificioSession);
        dto.setEdificio( e );
        
        dto.setUsuario( usuario );
        
        dto.setCodigoQR( CodeGenerator.generateSHA(dto.getUsuario().getUserName() + dto.getUsuario().getClaveUser() + dto.getIdDepartamento()));
        DepartamentoDAO.writeQR( dto, QR_PATH );
        SAACDelegate sd = new SAACDelegate();
        
        if ( sd.create( dto ) ) {
            success("INFO: ", "El departamento fue creado satisfactoriamente");
            clearBean();
            redirectTo(URL_CONTEXT + CONSULTA_DEPARTAMENTOS_FORM);
        } else {
            error("ALERTA", "El departamento que quieres crear ya existe");
            redirectTo(URL_CONTEXT + DEPARTAMENTO_FORM);
        }

    }

    public void actualizar() throws IOException {
        SAACDelegate sd = new SAACDelegate();
        try {
            success("INFO: ", "El departamento fue editado satisfactoriamente");
            System.out.println("DTO ANTES DE ACTUALIZAR: " + dto);
            sd.update(dto);
            redirectTo(URL_CONTEXT + CONSULTA_DEPARTAMENTOS_FORM);
        } catch (Exception ex) {
            ex.printStackTrace();
            error("error editando Depto", "Hubo un error al actualizar la info del departamento");
            redirectTo(URL_CONTEXT + CONSULTA_DEPARTAMENTOS_FORM);
        }
    }

    public void borrar( Departamento departamento ){
    	borrar( departamento.getIdDepartamento(), departamento.getEdificio().getIdEdificio() );
    }
    
    public void borrar(int idDepartamento, int idEdificio){
        dto = seleccionaDepartamento(idDepartamento, idEdificio);
        SAACDelegate sd = new SAACDelegate();
        if( sd.delete( dto ) ){
        	success("INFO: ", "El departamento fue borrado satisfactoriamente");
        }
        else{
        	error("error editando Depto", "Hubo un error al borrar el departamento");
        }
    }

    public List<Departamento> getLista() {
        SAACDelegate sd = new SAACDelegate();
        try {
            return sd.readAllDepartamentos(idEdificioSession);
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
            System.out.println(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    //Getters and setters    
    public int getIdDepartamento() {
    	if( dto == null ){
    		begin( );
    	}
        return dto.getIdDepartamento();
    }

    public void setIdDepartamento(int idDepartamento) {
        dto.setIdDepartamento(idDepartamento);
    }

    public Usuario getUsuario() {
    	if( dto == null ){
    		begin( );
    	}
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
    	System.out.println( "DepartamentoBean: getUsuarios");
        return new SAACDelegate().readAllUsuarios( idEdificioSession );
    }

    public void setService(UsuarioService service) {
        this.service = service;
    }
    
    private void clearBean(){
        dto = new Departamento();
    }

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	public Departamento getDepartamento( ){
		return dto;
	}
}
