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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author JL
 */
@Entity
@Table (name = "usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int idUsuario;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String mail;
    private String telefono;
    private String userName;
    private String claveUser;
    private int tipoUsuario;
    @OneToOne
    @JoinColumn (name="idEdificio")
    private Edificio edificio;

    public Usuario( ){}
    
    public Usuario( int id ){
    	this.idUsuario = id;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClaveUser() {
        return claveUser;
    }

    public void setClaveUser(String claveUser) {
        this.claveUser = claveUser;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public String getFullName( ){
    	return nombre + " " + apPaterno + " " + apMaterno;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", mail=" + mail + ", telefono=" + telefono + ", userName=" + userName + ", claveUser=" + claveUser + ", tipoUsuario=" + tipoUsuario + ", edificio=" + edificio + '}';
    }
}