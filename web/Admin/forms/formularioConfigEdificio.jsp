<%-- 
    Document   : formularioConfig
    Created on : 13/11/2015, 01:09:58 AM
    Author     : JL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="box box-info">
    <div class="box-header">
        <h3 class="box-title">Configuración edificio</h3>
        <!-- tools box -->
        <div class="pull-right box-tools">
            <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
        </div><!-- /. tools -->
        <div class="box-body">
            <form class="form-horizontal" id="formConfig" action="../AddConfig?param=Edificio">
                <div class="form-group">
                    <label for="inputEdificioName" class="col-sm-2 control-label">Nombre del edificio</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputEdificioName" name="inputEdificioName" placeholder="Progreso">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputDireccion" class="col-sm-2 control-label">Dirección del edificio</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputDireccion" name="inputDireccion" placeholder="3059.99">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="box-footer clearfix">
        <button class="pull-right btn btn-success" form="formConfig">Configurar <i class="glyphicon glyphicon-ok"></i></button>
    </div>
</div>