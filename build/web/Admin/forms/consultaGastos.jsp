<%-- 
    Document   : consultaGastos
    Created on : 13/11/2015, 12:55:22 AM
    Author     : JL
--%>

<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.model.dao.GastosDAO"%>
<%@page import="com.ipn.mx.model.dto.Gastos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GastosDAO gDAO = new GastosDAO();
    List<Gastos> gastosList = gDAO.readAll();
%>

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
                        <th>Concepto del gasto</th>
                        <th>Cantidad gastada</th>
                        <th>Fecha del gasto</th>
                        <th>Actualizar</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Gastos g:gastosList) {%>
                    <tr>
                        <td><%= g.getConcepto() %> </td>
                        <td>$<%= g.getImporte() %></td>
                        <td><%= g.getFechaGasto() %></td>
                        <td>
                            <a href="./Gastos.jsp?param=Actualizar&id=<%= g.getIdGasto() %>" class="btn btn-default">
                                <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
                            </a>
                        </td>
                        <td>
                            <a href="../AddGasto?param=Eliminar&id=<%= g.getIdGasto()%>" class="btn btn-default">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            </a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </div>
</div>