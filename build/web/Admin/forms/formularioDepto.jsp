<%-- 
    Document   : formularioDepto
    Created on : 13/11/2015, 12:18:13 AM
    Author     : JL
--%>

<%@page import="com.ipn.mx.model.dao.DepartamentoDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.model.dao.UsuarioDAO"%>
<%@page import="com.ipn.mx.model.dto.Usuario"%>
<%@page import="com.ipn.mx.model.dto.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String operacion = "";
    String codeOperation = "";
    Departamento depa = null;
    List<Usuario> list = null;
    operacion = request.getParameter("param");
    UsuarioDAO uDAO = new UsuarioDAO();
    list = uDAO.readAll();
    if (operacion.equals("Actualizar")) {
        int id = Integer.parseInt(request.getParameter("id"));
        depa = new Departamento();
        depa.setIdDepartamento(id);
        DepartamentoDAO dDAO = new DepartamentoDAO();
        depa = dDAO.read(depa);
    }
    if (request.getParameter("code") != null && !request.getParameter("code").isEmpty()) {
        codeOperation = request.getParameter("code");
        if ("102".equals(codeOperation)) {
            codeOperation = "<strong>Oops!</strong> El departamento ya existe";
        }
        if ("204".equals(codeOperation)) {
            codeOperation = "<strong>Oops!</strong> Hubo un problema, vuelve a intentarlo";
        }
    }
%>
<div class="box box-info">
    <div class="box-header">
        <h3 class="box-title"><%= operacion%> departamento</h3>
        <!-- tools box -->
        <div class="pull-right box-tools">
            <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
        </div><!-- /. tools -->
        <div class="box-body">
            <form class="form-horizontal" id="formDepto" action="../AddCondomino?param=<%= operacion%>" method="post">
                <% if (!codeOperation.equals("")) {%>
                <div class="form-group">
                    <div class="alert alert-danger alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <%= codeOperation%>
                    </div>
                </div>
                <% } %>
                <div class="form-group">
                    <label for="inputDepto" class="col-sm-2 control-label">Número de departamento</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputDepto" name="inputDepto" required placeholder="101" <% if (depa != null) {%><%= "readonly =\"true\" value=\"" + depa.getIdDepartamento() + "\""%><%}%> >
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDueno" class="col-sm-2 control-label">Propietario</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="inputDueno" name="inputDueno" required>
                            <% for (Usuario u : list) { %>
                            <% if (depa != null) {%>
                            <option selected="true" value="<%= u.getIdUsuario()%>"><%= u.getFullName( )%></option>
                            <% } else {%>
                            <option value="<%= u.getIdUsuario()%>"><%= u.getFullName( )%></option>
                            <% }
                                } %>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputHabitantes" class="col-sm-2 control-label">Número de habitantes</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputHabitantes" name="inputHabitantes" required placeholder="4" <% if (depa != null) {%><%= "value=\"" + depa.getPersonas() + "\""%><%}%> >
                        <input type="hidden" id="SaldoFavor" name="SaldoFavor" value="<% if (depa != null) {%><%= depa.getSaldoFavor()%><%} else {%>0.0<% }%>">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="box-footer clearfix">
        <button class="pull-right btn btn-success" form="formDepto">Enviar datos <i class="glyphicon glyphicon-ok"></i></button>
    </div>
</div>