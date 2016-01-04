/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.dto.Usuario;

/**
 *
 * @author JL
 */
public class Registrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String parametroOperativo = "";
        if(request.getParameter("param") != null && !request.getParameter("param").isEmpty()){
            parametroOperativo = request.getParameter("param");
        }
        if(parametroOperativo.equals("Alta")){
            altaUsuario(request,response);
        }
        if(parametroOperativo.equals("Actualizar")){
            actualizarUsuario(request,response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void altaUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        /* Variables recibidas
        txtName:String
        txtApellidos:String (Separar en Paterno y Materno
        txtMail:String
        txtContacto:String
        txtUserName:String
        txtUserClave:String
        */
        Usuario u = new Usuario(); //Objeto Usuario
        UsuarioDAO uDAO = new UsuarioDAO(); //Base de datos DAO
        
        String txtName = "",txtMail = "",txtUserName = "",txtUserClave = "", txtContacto = "";
        String apPaterno = "", apMaterno = "";
        txtName = request.getParameter("txtName");
        if(request.getParameter("txtApellidos").split(" ").length == 2){
            apPaterno = request.getParameter("txtApellidos").split(" ")[0];
            apMaterno = request.getParameter("txtApellidos").split(" ")[1];
        }else{
            apPaterno = request.getParameter("txtApellidos");
            apMaterno = " ";
        }
        System.err.println(txtName + " " + apPaterno + " " + apMaterno);
        txtMail = request.getParameter("txtMail");
        txtUserName = request.getParameter("txtUserName");
        txtUserClave = request.getParameter("txtUserClave");
        txtContacto = request.getParameter("txtContacto");
        
        u.setNombre(txtName);
        u.setApPaterno(apPaterno);
        u.setApMaterno(apMaterno);
        u.setMail(txtMail);
        u.setTelefono(txtContacto);
        u.setUserName(txtUserName);
        u.setClaveUser(txtUserClave);
        u.setTipoUsuario(2);
        
        int value = uDAO.create(u);
        if(value == 102){
            response.sendRedirect("./Index?accesoIncorrecto=true&Code="+value);
        }
        if(value == 1){
            response.sendRedirect("./Index?accesoCorrecto=true");
        }
            
    }

    private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
