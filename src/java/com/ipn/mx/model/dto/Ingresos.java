/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.dto;

import java.io.Serializable;
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
@Table (name="ingresos")
public class Ingresos implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idIngreso;
    private String concepto;
    private double importe;
    private int idEdificio;

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    @Override
    public String toString() {
        return "Ingresos{" + "idIngreso=" + idIngreso + ", concepto=" + concepto + ", importe=" + importe + ", idEdificio=" + idEdificio + '}';
    }
}
