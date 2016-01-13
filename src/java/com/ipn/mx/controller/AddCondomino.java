/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipn.mx.model.dao.DepartamentoDAO;
import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;
import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.utils.CodeGenerator;

/**
 *
 * @author JL
 */
public class AddCondomino extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5345694116543174316L;
	

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
        response.setContentType("text/html;charset=UTF-8");
        String rutaDeEnvio = "./Admin/Departamentos.jsp?param=Consultar";
        HttpSession session = request.getSession();
        int inputDepto, inputDueno, inputHabitantes;
        Departamento depto = new Departamento();
        DepartamentoDAO dDAO = new DepartamentoDAO();

        if (request.getParameter("param") != null && !request.getParameter("param").isEmpty()) {
            if (request.getParameter("param").equals("Alta") || request.getParameter("param").equals("Actualizar")) {
                inputDepto = Integer.parseInt(request.getParameter("inputDepto"));
                inputDueno = Integer.parseInt(request.getParameter("inputDueno"));
                inputHabitantes = Integer.parseInt(request.getParameter("inputHabitantes"));

                depto.setIdDepartamento(inputDepto);
                Usuario u = new Usuario();
                u.setIdUsuario(inputDueno);
                depto.setUsuario(u);
                depto.setPersonas(inputHabitantes);
                depto.setSaldoFavor( new BigDecimal( Double.parseDouble(request.getParameter("SaldoFavor") ) ) );
                Edificio e = new Edificio();
                e.setIdEdificio(Integer.parseInt(session.getAttribute("Edificio").toString()));
                depto.setEdificio(e);
            }
            if (request.getParameter("param").equals("Alta")) {
            	depto.setUsuario( new UsuarioDAO( ).read( depto.getUsuario( ) ) );
            	//TODO: actualizar el documento "procesamiento de la captura"
            	depto.setCodigoQR( CodeGenerator.generateSHA( depto.getUsuario( ).getUserName( ) + depto.getUsuario( ).getClaveUser( ) + depto.getIdDepartamento( )  ) );
                String directorio = getServletContext().getRealPath("");
            	DepartamentoDAO.writeQR( depto,directorio );
                if( dDAO.create( depto ) ){
                	rutaDeEnvio = "./Admin/Departamentos.jsp?param=Alta&code=true";
                }
            }
            if (request.getParameter("param").equals("Actualizar")) {
            	dDAO.update(depto);
            }
            if (request.getParameter("param").equals("Eliminar")) {
                depto.setIdDepartamento(Integer.parseInt(request.getParameter("id")));
                dDAO.delete(depto);
            }
        }
        response.sendRedirect(rutaDeEnvio);
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
