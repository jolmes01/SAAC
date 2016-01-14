package com.ipn.mx.view.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Mantenimiento;
import com.ipn.mx.model.dto.configuracionMtto;
import com.ipn.mx.model.facade.MantenimientoFacade;
import com.ipn.mx.model.facade.configuracionMttoFacade;

@ManagedBean
@ViewScoped
public class MantenimientoBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8635418520055736426L;
	private Mantenimiento mantenimiento;
	private configuracionMtto configuracion;
	private boolean delayed;

	public List<Mantenimiento> getMantenimientoExpenses( Departamento departamento ){
		return new MantenimientoFacade( ).getMantenimientosByDepartamento( departamento );
	}
	
	public List<Mantenimiento> getMantenimientosToPay( Departamento departamento ){
		return new MantenimientoFacade( ).getMantenimientosToPay(departamento);
	}
	
	public void prePay( Departamento departamento ){
		mantenimiento = new Mantenimiento( );
		mantenimiento.setDepartamento( departamento );
		if( configuracion == null ){
			configuracion = new configuracionMttoFacade( ).readFirst( 
					commonService.getUsuario( ).getEdificio( ).getIdEdificio( ) );			
		}
		
		mantenimiento.setFechaPago( configuracion.getFechaLimite() );
		accion = ACC_CREAR;
	}
	
	public void preCheck( Mantenimiento mantenimiento){
		this.mantenimiento = mantenimiento;
		double porciento = 0;
		if( configuracion == null ){
			configuracion = new configuracionMttoFacade( ).readFirst( 
					commonService.getUsuario( ).getEdificio( ).getIdEdificio( ) );			
		}
		
		delayed = new Date( ).compareTo( mantenimiento.getFechaPago( ) ) > 0;
		if( delayed ){
			porciento = configuracion.getPorcentajeCouta( ) * 0.01;
			porciento = porciento * mantenimiento.getCantidad( );
			this.mantenimiento.setCantidad( mantenimiento.getCantidad() + porciento );
		}
		accion = ACC_ACTUALIZAR;
	}

	public void save( ){
		mantenimiento.setEstado( Mantenimiento.ESTADO_POR_PAGAR );
		new MantenimientoFacade( ).create( mantenimiento );
	}
	
	public void pay( ){
		mantenimiento.setEstado( Mantenimiento.ESTADO_PAGADO );
		new MantenimientoFacade( ).update( mantenimiento );
	}
	
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public configuracionMtto getConfiguracion() {
		return configuracion;
	}

	public boolean isDelayed() {
		return delayed;
	}

	

}
