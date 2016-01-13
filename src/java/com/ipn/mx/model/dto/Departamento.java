/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable{

    @Id
    private int idDepartamento;
    
    @OneToOne (cascade = {CascadeType.ALL})
    @JoinColumn (name="idUsuario")
    private Usuario usuario;
    @OneToOne
    @JoinColumn (name="idEdificio")
    private Edificio edificio;
    private int personas;
    private String codigoQR;
    @Column (name = "qr_path")
    private String qrPath;
    @Column (name = "qr_length")
    private int qrLength;
    private BigDecimal saldoFavor;

    public Departamento() {
        saldoFavor = BigDecimal.ZERO;
        qrPath = " ";
        qrLength = 0;
        codigoQR = " ";
    }
    
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public BigDecimal getSaldoFavor() {
        return saldoFavor;
    }

    public void setSaldoFavor(BigDecimal saldoFavor) {
        this.saldoFavor = saldoFavor;
    }

    public String getQrPath() {
        return qrPath;
    }

    public void setQrPath(String qrPath) {
        this.qrPath = qrPath;
    }

    public int getQrLength() {
        return qrLength;
    }

    public void setQrLength(int qrLength) {
        this.qrLength = qrLength;
    }

    @Override
    public String toString() {
        return "Departamento{" + "idDepartamento=" + idDepartamento + ", usuario=" + usuario + ", edificio=" + edificio + ", personas=" + personas + ", codigoQR=" + codigoQR + ", qrPath=" + qrPath + ", qrLength=" + qrLength + ", saldoFavor=" + saldoFavor + '}';
    }
}
