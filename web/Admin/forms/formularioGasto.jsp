<%-- 
    Document   : formularioGasto
    Created on : 13/11/2015, 12:48:50 AM
    Author     : JL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- String operacion = "";
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
--%>
<div class="box box-info">
    <div class="box-header">
        <h3 class="box-title">Registrar Gastos del condominio</h3>
        <!-- tools box -->
        <div class="pull-right box-tools">
            <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
        </div><!-- /. tools -->
        <div class="box-body">
            <form class="form-horizontal" id="formGasto" action="../AddGasto">
                <div class="form-group">
                    <label for="inputConcepto" class="col-sm-2 control-label">Concepto del gasto</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputConcepto" name="inputConcepto" placeholder="Pago de Luz">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputCantidad" class="col-sm-2 control-label">Cantidad pagada</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputCantidad" name="inputCantidad" placeholder="3059.99">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputFechaGasto" class="col-sm-2 control-label">Fecha del gasto</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="inputFechaGasto" name="inputFechaGasto" placeholder="dd-mm-aaaa">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="box-footer clearfix">
        <button class="pull-right btn btn-success" form="formGasto">Registrar gasto <i class="glyphicon glyphicon-ok"></i></button>
    </div>
</div>