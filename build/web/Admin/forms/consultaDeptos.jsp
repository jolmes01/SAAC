<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.model.dao.DepartamentoDAO"%>
<%@page import="com.ipn.mx.model.dto.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Departamento> listaDeptos = new DepartamentoDAO( ).readAll();
%>
<script type="text/javascript" src="../plugins/sweetalert/sweetalert.min.js" ></script>
<link href="../plugins/sweetalert/sweetalert.css" rel="stylesheet">
<script type="text/javascript">
	function downloadQR( ){
		var str = '<img src="';
		str += 'DownloadQR?code=';
		str += $( this ).attr( "id" );
		str += '" />';
		console.debug( str );
		
		//$( "#qr-image" ).html( str );
		swal( {
	    	title: "C&oacute;digo QR",
	    	text: str,
	    	html: true,
	    	allowOutsideClick: true,
	    	confirmButtonText: "Aceptar"
	    } );
		
	}
	
	$( document ).ready( function( ){
		$( ".action-down-qr" ).on( { click: downloadQR } );
	} );
</script>
<div class="box box-info">
    <div class="box-header">
        <h3 class="box-title">Lista de departamentos</h3>
        <!-- tools box -->
        <div class="pull-right box-tools">
            <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
        </div><!-- /. tools -->
        <div class="box-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Número de departamento</th>
                        <th>Propietario</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody id="apartment-container">
                    <% for (Departamento departamento: listaDeptos) {%>
                    <tr>
                        <td><%= departamento.getIdDepartamento() %></td>
                        <td><%= departamento.getUsuario( ).getFullName( )%></td>
                        <td>
                            <a href="./Departamentos.jsp?param=Actualizar&id=<%= departamento.getIdDepartamento() %>" class="btn btn-default" title="Actualizar" >
                                <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
                            </a>
                            <a href="../AddCondomino?param=Eliminar&id=<%= departamento.getIdDepartamento() %>" class="btn btn-default" title="Eliminar" >
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            </a>
                            <div class="btn btn-default action-down-qr" title="Descargar QR" id="qr-<%=departamento.getIdDepartamento( )%>" >
                                <span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
                            </div>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </div>
    <div id="qr-image">
    </div>
</div>
