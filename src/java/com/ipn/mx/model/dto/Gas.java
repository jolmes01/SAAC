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
@Table (name = "gas")
public class Gas implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4179162270241982620L;
	public static final int ESTADO_POR_PAGAR = 1;
	public static final int ESTADO_PAGADO = 2;
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idGas;
    @ManyToOne
    @JoinColumn( name="idDepartamento" )
    private Departamento departamento;
    //private int idDepartamento;
    private long lecturaAnterior;
    private long lecturaActual;
    private int consumoMes;
    private double cantidad;
    private int estado;
    private Date fechaPago;

    public Gas() {
    }

    public int getIdGas() {
        return idGas;
    }

    public void setIdGas(int idGas) {
        this.idGas = idGas;
    }

    
    public long getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(long lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public long getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(long lecturaActual) {
        this.lecturaActual = lecturaActual;
    }

    public int getConsumoMes() {
        return consumoMes;
    }

    public void setConsumoMes(int consumoMes) {
        this.consumoMes = consumoMes;
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
    		return "Pendiente de pago";
    	case ESTADO_PAGADO:
    		return "Pago realizado";
    	}
    	return "";
    }
    

    public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
    public String toString() {
        return "idGas = " + idGas 
                + " lecturaAnterior = " + lecturaAnterior + " lecturaActual = " + lecturaActual
                + " consumoMes = " + consumoMes + " cantidad = " + cantidad + " estado = " + estado
                + " fechaPago = " + fechaPago;
    }
}
