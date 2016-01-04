<%-- 
    Document   : formularioConfigGas
    Created on : 13/11/2015, 01:13:46 AM
    Author     : JL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="box box-info">
    <div class="box-header">
        <h3 class="box-title">Configuración gas</h3>
        <!-- tools box -->
        <div class="pull-right box-tools">
            <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
        </div><!-- /. tools -->
        <div class="box-body">
            <form class="form-horizontal" id="formConfig" action="../AddConfig?param=Gas">
                <div class="form-group">
                    <label for="inputCostoGas" class="col-sm-2 control-label">Costo por litro</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="inputCostoGas" name="inputCostoGas" placeholder="10.7">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputFechaLimite" class="col-sm-2 control-label">Fecha límite de pago</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="inputFechaLimite" name="inputFechaLimite" placeholder="dd/mm/aaaa">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="box-footer clearfix">
        <button class="pull-right btn btn-success" form="formConfig">Configurar <i class="glyphicon glyphicon-ok"></i></button>
    </div>
</div>