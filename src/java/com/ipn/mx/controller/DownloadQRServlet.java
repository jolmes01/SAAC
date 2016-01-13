package com.ipn.mx.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipn.mx.model.dao.DepartamentoDAO;
import com.ipn.mx.model.dto.Departamento;
import com.ipn.mx.model.dto.Edificio;

/**
 * Servlet implementation class DownloadQRServlet
 */
public class DownloadQRServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2671442973923455091L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code;
		String codeString = null;
		Departamento departamento = null;
		DepartamentoDAO dao = null;
		HttpSession session = request.getSession( false );
		String idEdificio = null;
		
		codeString = request.getParameter( "code" );
		if( codeString == null || codeString.isEmpty() ){
			response.sendError(400, "The param \"code\" is missing" );
			return;
		}
		codeString = codeString.substring( codeString.indexOf( '-' ) + 1 );
		code = Integer.parseInt( codeString );
		
		if( session == null ){
			System.err.println( "No se encontr\u00f3 el objeto de sesi\u00f3n" );
			return;
		}
		idEdificio = (String)session.getAttribute( "Edificio" );
		if( idEdificio == null ){
			System.err.println( "El parametro idEdificio no se encontr\u00f3" );
			return;
		}
		dao = new DepartamentoDAO( );
        departamento = new Departamento( );
        departamento.setIdDepartamento( code );
        departamento.setEdificio( new Edificio( Integer.parseInt( idEdificio ) ) );
		departamento = dao.read( departamento );
		
		if( departamento == null ){
			response.sendError( 412, "The id of the 'departamento' was not found, or it has no QR attached" );
			return;
		}
		
		if( departamento.getCodigoQR() == null || departamento.getCodigoQR().isEmpty( ) ){
			generateQR( departamento );
		}
		
		sendImage( departamento, response );
	}
	
	private void generateQR( Departamento departamento ) throws IOException{
		DepartamentoDAO.writeQR( departamento, getServletContext().getRealPath("") );
		new DepartamentoDAO( ).update( departamento );
	}
	
	private byte[] loadImage( Departamento departamento ) throws IOException{
		byte [] image = null;
		File file = null;
		FileInputStream fis = null;
		
		file = new File( departamento.getQrPath( ) );
		fis = new FileInputStream( file );
		image = new byte[departamento.getQrLength( ) ];
		fis.read( image );
		fis.close( );
		
		return image;
	}
	
	private void sendImage( Departamento departamento, HttpServletResponse response) throws IOException{
		byte [] image = null;
		BufferedOutputStream bos = null;
		
		image = loadImage( departamento );
		bos = new BufferedOutputStream( response.getOutputStream() );
		response.setContentType( "image/png" );
		
		bos.write( image );
		bos.flush();
		bos.close( );
	}
	
	
}//end class
