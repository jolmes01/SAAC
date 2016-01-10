/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table (name = "configuracionMtto")
public class configuracionMtto implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idConfiguracionMtto;
    @Column (name = "porcentajeCuota")
    private int porcentajeCouta;
    private Date fechaLimite;
    @OneToOne
    @JoinColumn (name="idEdificio")
    private Edificio edificio;

    public int getIdConfiguracionMtto() {
        return idConfiguracionMtto;
    }

    public void setIdConfiguracionMtto(int idConfiguracionMtto) {
        this.idConfiguracionMtto = idConfiguracionMtto;
    }

    public int getPorcentajeCouta() {
        return porcentajeCouta;
    }

    public void setPorcentajeCouta(int porcentajeCouta) {
        this.porcentajeCouta = porcentajeCouta;
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
        return "configuracionMtto{" + "idConfiguracionMtto=" + idConfiguracionMtto + ", porcentajeCouta=" + porcentajeCouta + ", fechaLimite=" + fechaLimite + ", edificio=" + edificio + '}';
    }
}
