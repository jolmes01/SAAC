package com.ipn.mx.service;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.omnifaces.util.Faces;

@ManagedBean
@RequestScoped
public class MenuService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5409240995201854635L;
	
	private String getPage( ){
		String url = Faces.getRequestURL( );
		url = url.substring( url.lastIndexOf( '/' ) + 1 );
		
		return url;
	}

	public String getClassMenuClass( int opc ){
		String url = getPage( );

		switch( opc ){
		case 1:
			if( url.equals( "Departamento.jsf" ) || url.equals( "Consulta_Departamentos.jsf" ) ){
				return "active";
			}
			break;
		case 2:
			if( url.equals( "pagos.jsf" ) ){
				return "active";
			}
			break;
		case 3:
			if( url.equals( "Gasto.jsf" ) || url.equals( "Consulta_Gastos.jsf" ) ){
				return "active";
			}
			break;
		case 4:
			//reportes
			break;
		case 5:
			if( url.equals( "Edificio.jsf" ) || url.equals( "Gas.jsf" ) || url.equals( "Mantenimiento.jsf" ) ){
				return "active";
			}
			break;
			
		}
		return "";
	}
	
	public String getSubMenuClass( int opc ){
		String url = getPage( );
		
		switch( opc ){
		case 11:
			if( url.equals( "Departamento.jsf" ) ){
				return "active";
			}
			break;
		case 12:
			if( url.equals( "Consulta_Departamentos.jsf" ) ){
				return "active";
			}
			break;
		case 22:
			if( url.equals( "pagos.jsf" ) ){
				return "active";
			}
			break;
		case 31:
			if( url.equals( "Gasto.jsf" ) ){
				return "active";
			}
			break;
		case 32:
			if( url.equals( "Consulta_Gastos.jsf" ) ){
				return "active";
			}
			break;
		case 4:
			//reportes
			break;
		case 51:
			if( url.equals( "Edificio.jsf" ) ){
				return "active";
			}
			break;
		case 52:
			if( url.equals( "Gas.jsf" ) ){
				return "active";
			}
			break;
		case 53:
			if( url.equals( "Mantenimiento.jsf" ) ){
				return "active";
			}
			break;
			
		}
		
		
		return "";
	}
	
}
