/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.model.delegate;

import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Gas;
import com.ipn.mx.model.dto.Gastos;
import com.ipn.mx.model.dto.Ingresos;
import com.ipn.mx.model.dto.Mantenimiento;
import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.model.dto.configuracionGas;
import com.ipn.mx.model.facade.DepartamentoFacade;
import com.ipn.mx.model.facade.EdificioFacade;
import com.ipn.mx.model.facade.GasFacade;
import com.ipn.mx.model.facade.GastosFacade;
import com.ipn.mx.model.facade.IngresosFacade;
import com.ipn.mx.model.facade.MantenimientoFacade;
import com.ipn.mx.model.facade.UsuarioFacade;
import com.ipn.mx.model.facade.configuracionGasFacade;
import com.ipn.mx.model.facade.configuracionMttoFacade;
import java.util.List;

/**
 *
 * @author JL
 */
public class SAACDelegate {

    private DepartamentoFacade df;
    private EdificioFacade ef;
    private GasFacade gf;
    private GastosFacade gastosf;
    private IngresosFacade inf;
    private MantenimientoFacade mf;
    private UsuarioFacade uf;
    private configuracionGasFacade cgf;
    private configuracionMttoFacade cmf;

    public SAACDelegate() {
        df = new DepartamentoFacade();
        ef = new EdificioFacade();
        gf = new GasFacade();
        gastosf = new GastosFacade();
        inf = new IngresosFacade();
        mf = new MantenimientoFacade();
        uf = new UsuarioFacade();
        cgf = new configuracionGasFacade();
        cmf = new configuracionMttoFacade();
    }
    
    //Código para Departamento
    public int create(Departamento departamento) {
        return df.create(departamento);
    }

    public void update(Departamento departamento) {
        df.update(departamento);
    }

    public void delete(Departamento departamento){
        df.delete(departamento);
    }

    public Departamento read(Departamento departamento){
        return df.read(departamento);
    }

    public List readAllDepartamentos(int idEdificio){
        return df.readAll(idEdificio);
    }
    
    //Código para Edificio
    public int create(Edificio object) {
        return ef.create(object);
    }

    public void update(Edificio object) {
        ef.update(object);
    }

    public void delete(Edificio object){
        ef.delete(object);
    }

    public Edificio read(Edificio object){
        return ef.read(object);
    }

    public List readAllEdificios(){
        return ef.readAll();
    }
    
    //Código para Gas
    public int create(Gas object) {
        return gf.create(object);
    }

    public void update(Gas object) {
        gf.update(object);
    }

    public void delete(Gas object){
        gf.delete(object);
    }

    public Gas read(Gas object){
        return gf.read(object);
    }

    public List readAllGas(){
        return gf.readAll();
    }
    
    //Código para Gastos
    public int create(Gastos object) {
        return gastosf.create(object);
    }

    public void update(Gastos object) {
        gastosf.update(object);
    }

    public void delete(Gastos object){
        gastosf.delete(object);
    }

    public Gastos read(Gastos object){
        return gastosf.read(object);
    }

    public List readAllGastos(){
        return gastosf.readAll();
    }
    
    //Código para Ingresos
    public int create(Ingresos object) {
        return inf.create(object);
    }

    public void update(Ingresos object) {
        inf.update(object);
    }

    public void delete(Ingresos object){
        inf.delete(object);
    }

    public Ingresos read(Ingresos object){
        return inf.read(object);
    }

    public List readAllIngresos(){
        return inf.readAll();
    }
    
    //Código para Mantenimiento
    public int create(Mantenimiento object) {
        return mf.create(object);
    }

    public void update(Mantenimiento object) {
        mf.update(object);
    }

    public void delete(Mantenimiento object){
        mf.delete(object);
    }

    public Mantenimiento read(Mantenimiento object){
        return mf.read(object);
    }

    public List readAllMantenimientos(){
        return mf.readAll();
    }
    
    //Código para Usuario
    public int create(Usuario object) {
        return uf.create(object);
    }

    public void update(Usuario object) {
        uf.update(object);
    }

    public void delete(Usuario object){
        uf.delete(object);
    }

    public Usuario read(Usuario object){
        return uf.read(object);
    }

    public List readAllUsuarios(){
        return uf.readAll();
    }
    
    public boolean login(Usuario object){
        return uf.login(object);
    }
    
    public int tipoUsuario(Usuario object){
        return uf.tipoUsuario(object);
    }
    
    public boolean valida(Usuario object){
        return uf.valida(object);
    }
    
    //Código para ConfiguracionGas
    public int create(configuracionGas object) {
        return cgf.create(object);
    }

    public void update(configuracionGas object) {
        cgf.update(object);
    }

    public void delete(configuracionGas object){
        cgf.delete(object);
    }

    public configuracionGas read(configuracionGas object){
        return cgf.read(object);
    }

    public List readAllConfigGas(){
        return cgf.readAll();
    }
    
    //Código para ConfiguracionMtto

}
