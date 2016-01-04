/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author JL
 */
@Entity
@Table (name = "gas")
public class Gas implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idGas;
    private int idDepartamento;
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

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
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

    @Override
    public String toString() {
        return "idGas = " + idGas + " idDepartamento = " + idDepartamento
                + " lecturaAnterior = " + lecturaAnterior + " lecturaActual = " + lecturaActual
                + " consumoMes = " + consumoMes + " cantidad = " + cantidad + " estado = " + estado
                + " fechaPago = " + fechaPago;
    }
}
