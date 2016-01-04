<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Escribir aquí aquellos atributos generales que requieran estar en todas las pantallas de aministrador --%>
<%
    String principalPage = "Administrador.jsp";
    String userName = "";
    if( session.getAttribute("session") == null ) {
        response.sendRedirect("../Index");
    }else {
        if (session.getAttribute("userName") == null){
        	userName = "Admin";
        }
        else{
        	userName = session.getAttribute("userName").toString( );
        }
    }
%>