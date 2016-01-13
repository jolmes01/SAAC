package com.ipn.mx.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.omnifaces.util.Faces;

import com.ipn.mx.model.dao.UsuarioDAO;
import com.ipn.mx.model.dto.Usuario;
import com.ipn.mx.service.CommonService;

public class Login extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7022414382735355829L;
	private static final int RC_NOT_PARAM = 1;
	private static final int RC_WRONG_USER = 2;
	private static final int RC_INTERNAL_ERROR = 3;
	private static final int RC_OK = 100;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	response.setContentType( "text/plain" );
        String id = request.getParameter("id");
        CommonService commonService = null;
        
        if (id != null) {
            if ( "Ingreso".equals( id ) ) {
            	
                String userName = request.getParameter("userName");
                String claveUser = request.getParameter("claveUser");
                
                UsuarioDAO uDAO = new UsuarioDAO();
                Usuario u = new Usuario();
                u.setUserName(userName);
                u.setClaveUser(claveUser);
                u = uDAO.login(u);
                if ( u != null ) {
                    if (uDAO.tipoUsuario(u) == 1) {
                    	commonService = new CommonService( );
                        HttpSession session = request.getSession(true);
                        session.setAttribute("session", true);
                        session.setAttribute("userName", u.getUserName());
                        session.setAttribute("Edificio", "1");
                        
                        Faces.login( userName, claveUser);
                        
                        commonService.setUsuario( u );
                        Faces.setSessionAttribute( "commonService", commonService );
                        
                        response.getWriter().print( 
                        		new JSONObject( )
                        		.put( "status", RC_OK )
                        		.put( "url", "Admin/Administrador.jsp" )
                        		.toString( )
                        );
                    }
                    if (uDAO.tipoUsuario(u) == 2) {
                        HttpSession session = request.getSession(true);
                        session.setAttribute("session", true);
                        session.setAttribute("userName", u.getUserName());
                        session.setAttribute("Edificio", "1");
                        response.getWriter().print( 
                        		new JSONObject( )
                        		.put( "status", RC_OK )
                        		.put( "url", "Usuario/Condomino.jsp" )
                        		.toString( )
                        );
                    }
                    if (uDAO.tipoUsuario(u) == 0) {
                    	response.getWriter().print( 
                        		new JSONObject( )
                        		.put( "status", RC_INTERNAL_ERROR )
                        		.toString( )
                        );
                    }
                } else {
                	response.getWriter().print( 
                    		new JSONObject( )
                    		.put( "status", RC_WRONG_USER )
                    		.toString( )
                    );
                }
            }
            if ("Salir".equals(id)) {
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("./");
            }
        }
        else{
        	System.out.println( "id is null" );
        	response.getWriter().print( 
            		new JSONObject( )
            		.put( "status", RC_NOT_PARAM )
            		.toString( )
            );
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	processRequest(request, response);
    }
}
