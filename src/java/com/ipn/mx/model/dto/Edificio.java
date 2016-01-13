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
@Table (name="edificio")
public class Edificio implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6867371516154205601L;
	@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idEdificio;
    private String nombre;
    private String direccion;

    public Edificio( ){}
    
    public Edificio( int id ){
    	this.idEdificio = id;
    }
    
    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Edificio{" + "idEdificio=" + idEdificio + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
