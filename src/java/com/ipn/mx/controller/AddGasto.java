/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JL
 */
public class AddGasto extends HttpServlet {

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
            throws ServletException, IOException {
        String rutaDeEnvio = "./Admin/Gastos.jsp?param=Consultar";
        HttpSession session = request.getSession();
        // inputConcepto, inputCantidad, inputFechaGasto
        int inputDepto, inputDueno, inputHabitantes;
        //Departamento depto = new Departamento();
        //DepartamentoDAO dDAO = new DepartamentoDAO();
        /*
        if (request.getParameter("param") != null && !request.getParameter("param").isEmpty()) {
            if (request.getParameter("param").equals("Alta") || request.getParameter("param").equals("Actualizar")) {
                inputDepto = Integer.parseInt(request.getParameter("inputDepto"));
                inputDueno = Integer.parseInt(request.getParameter("inputDueno"));
                inputHabitantes = Integer.parseInt(request.getParameter("inputHabitantes"));

                depto.setIdDepartamento(inputDepto);
                depto.setIdUsuario(inputDueno);
                depto.setPersonas(inputHabitantes);
                depto.setSaldoFavor(Double.parseDouble(request.getParameter("SaldoFavor")));
                depto.setIdEdificio(Integer.parseInt(session.getAttribute("Edificio").toString()));
            }
            if (request.getParameter("param").equals("Alta")) {
                try {
                    int value = dDAO.create(depto);
                    if(value == 204 || value == 102) rutaDeEnvio = "./Admin/Departamentos.jsp?param=Alta&code="+value;
                } catch (SQLException ex) {
                    Logger.getLogger(AddCondomino.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCondomino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (request.getParameter("param").equals("Actualizar")) {
                try {
                    dDAO.update(depto);
                } catch (SQLException ex) {
                    Logger.getLogger(AddCondomino.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCondomino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (request.getParameter("param").equals("Eliminar")) {
                try {
                    depto.setIdDepartamento(Integer.parseInt(request.getParameter("id")));
                    dDAO.delete(depto);
                } catch (SQLException ex) {
                    Logger.getLogger(AddCondomino.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddCondomino.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        response.sendRedirect(rutaDeEnvio);*/
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
        processRequest(request, response);
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
        processRequest(request, response);
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

}
