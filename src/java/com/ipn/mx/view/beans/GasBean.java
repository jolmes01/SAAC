package com.ipn.mx.view.beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Gas;
import com.ipn.mx.model.dto.configuracionGas;
import com.ipn.mx.model.facade.GasFacade;
import com.ipn.mx.model.facade.configuracionGasFacade;

@ManagedBean
@ViewScoped
public class GasBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4384615597488157210L;
	private Gas gas;
	private configuracionGas configuracion;
	private boolean delayed;

	public List<Gas> getGasExpenses( Departamento departamento ){
		return new GasFacade( ).getGasByDepartamento( departamento );
	}
	
	public List<Gas> getGasToPay( Departamento departamento ){
		return new GasFacade( ).getGasToPay( departamento );
	}
	
	public void prePay( Departamento departamento ){
		gas = new Gas( );
		gas.setDepartamento( departamento );
		if( configuracion == null ){
			configuracion = new configuracionGasFacade( ).readFirst( 
					commonService.getUsuario( ).getEdificio( ).getIdEdificio( ) );			
		}
		gas.setFechaPago( configuracion.getFechaLimite( ) );
		accion = ACC_CREAR;
	}
	
	public void preCheck( Gas gas ){
		this.gas = gas;
		accion = ACC_ACTUALIZAR;
		delayed = new Date( ).compareTo( gas.getFechaPago( ) ) > 0;
	}
	
	public void save( ){
		gas.setLecturaActual( 0 );
		gas.setLecturaAnterior( 0 );
		gas.setCantidad( gas.getConsumoMes( ) * configuracion.getCostoLitro( )  );
		gas.setEstado( Gas.ESTADO_POR_PAGAR );
		new GasFacade( ).create( gas );
	}
	
	public void pay( ){
		gas.setEstado( Gas.ESTADO_PAGADO );
		new GasFacade( ).update( gas );
	}

	public Gas getGas() {
		return gas;
	}

	public void setGas(Gas gas) {
		this.gas = gas;
	}

	public configuracionGas getConfiguracion() {
		return configuracion;
	}

	public boolean isDelayed() {
		return delayed;
	}
}
