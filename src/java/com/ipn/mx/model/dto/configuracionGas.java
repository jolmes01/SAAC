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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author JL
 */
@Entity
@Table (name="configuracionGas")
public class configuracionGas implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idConfiguracion;
    private double costoLitro;
    private Date fechaLimite;
    @OneToOne
    @JoinColumn (name="idEdificio")
    private Edificio edificio;

    public int getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(int idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public double getCostoLitro() {
        return costoLitro;
    }

    public void setCostoLitro(double costoLitro) {
        this.costoLitro = costoLitro;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "configuracionGas{" + "idConfiguracion=" + idConfiguracion + ", costoLitro=" + costoLitro + ", fechaLimite=" + fechaLimite + ", edificio=" + edificio + '}';
    }
}
