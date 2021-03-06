/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author JL
 */
@Entity
@Table (name = "mantenimiento")
public class Mantenimiento implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1498855814631449740L;
	public static final int ESTADO_POR_PAGAR = 1;
	public static final int ESTADO_PAGADO = 2;
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idMantenimiento;
    @ManyToOne
    @JoinColumn( name="idDepartamento" )
    private Departamento departamento;
    private double cantidad;
    private int estado;
    //private int idDepartamento;
    private Date fechaPago;

    public Mantenimiento() {
    }

    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }
    public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public String getStatus( ){
    	switch( estado ){
    	case ESTADO_POR_PAGAR:
    		return "Por pagar";
    	case ESTADO_PAGADO:
    		return "Pagado";
    	}
    	
    	return "";
    }

    @Override
    public String toString() {
        return "idMantenimiento = " + idMantenimiento
                + " cantidad = " + cantidad + " estado = " + estado + " fechaPago = " + fechaPago;
    }

}
