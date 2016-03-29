<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <!DOCTYPE html>
    <!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
    <!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
    <!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
    <!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <title></title>
            <meta name="description" content="">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="assets/bootstrap-3.3.5/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/bootstrap-3.3.5/css/bootstrap-theme.min.css">

            <style>
                body {
                    padding-top: 50px;
                    padding-bottom: 20px;
                }
                .input-group > span {
                    min-width: 140px;
                    text-align: right;
                }
            </style>

        </head>
        <body>
            <!--[if lt IE 7]>
                <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->
            <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container">
                    <div class="navbar-header" >
                        <span class="navbar-brand">TCC 2 - Ferramenta para criação de ambientes gamificados</span>
                    </div>
                    <div class="nav navbar-nav navbar-right" style="margin-top: 1%;s">
                    </div>
                </div>
            </div>

            <!-- Main jumbotron for a primary marketing message or call to action -->
            <input type="hidden" id="url" value="<%=request.getContextPath()%>"/>
            <div class="jumbotron">
                <div class="container">
                    <div class="row">
                        <!-- ---------------- COFIGURAÇÕES ---------------- -->
                        <div class="col-md-12" >
                            <s:form id="connectionForm" namespace="/" action="index" cssClass="form-horizontal" method="post" theme="simple">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <label style='margin-bottom: 0px;'>
                                                <span class="glyphicon glyphicon-cog"></span> Configure a connection
                                            </label>
                                        </h4>
                                    </div>
                                    <div class="panel-body">
                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Host Address</span>
                                                <s:textfield type="text" id="nrIp" name="connection.nrIp" cssClass="form-control" placeholder="Ex: 127.0.0.1"/>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Port</span>
                                                <s:textfield type="text" id="nrPort" name="connection.nrPort" cssClass="form-control" placeholder="Ex: 5432"/>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Service</span>
                                                <s:textfield type="text" id="nmService" name="connection.nmService" cssClass="form-control"/>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Database</span>
                                                <s:textfield type="text" id="nmDatabase" name="connection.nmDatabase" cssClass="form-control" placeholder="Database name"/>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Usename</span>
                                                <s:textfield type="text" id="nmUser" name="connection.nmUser" cssClass="form-control" placeholder="Ex: root"/>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="input-group">
                                                <span class="input-group-addon">Password</span>
                                                <s:password id="cdPass" name="connection.cdPass" cssClass="form-control" placeholder="Ex: myP@ssword"/>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="panel-footer text-right">
                                        <a class="btn btn-default" onclick="clearForm('connectionForm');"><i class="glyphicon glyphicon-repeat"></i> Clear</a>
                                        <a class="btn btn-default" onclick="testConnection();"><i class="glyphicon glyphicon-play"></i> Test Connection</a>
                                        <a class="btn btn-primary" onclick="saveModifications();"><i class="glyphicon glyphicon-log-in"></i> Save Modifications</a>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                        <!-- ---------------- FIM COFIGURAÇÕES ---------------- -->


                        <!-- ---------------- DASHBOARD ---------------- -->
                        <div class="col-md-12" >
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <label style='margin-bottom: 0px;'>
                                            <span class="glyphicon glyphicon-dashboard"></span> Dashboard 
                                        </label>
                                        <%-- <label class="pull-right">Last Update: <small> <s:date name="dtLastUpdate" format="dd/MM/yyyy HH:MM:ss"/></small></label> --%>
                                    </h4>
                                </div>
                                <div class="panel-body">
                                    <div class="col-md-6">
                                        <div id="memoryGraph" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                    </div>
                                    <div class="col-md-6">
                                        <div id="diskGraph" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <!-- ---------------- FIM DASHBOARD ---------------- -->


                        <!-- ---------------- SOFWTARES ---------------- -->
                        <div class="col-md-12" >
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            <label style='margin-bottom: 0px; width: 100%; cursor: pointer;'>
                                                <span class="glyphicon glyphicon-th-list"></span> Softwares and Aplications Installed
                                                <span class="pull-right">Total: <small> <s:property value="snmpDTO.softwares.size()"/></small></span>
                                            </label>
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="panel-body">
                                        <ul class="list-group">
                                            <s:iterator value="snmpDTO.softwares">
                                                <li class="list-group-item"><s:property /> </li>
                                                </s:iterator>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ---------------- FIM SOFWTARES ---------------- -->

                    </div>
                </div>
            </div>

            <div class="container">
                <!-- ---------------- MEMÓRIA ---------------- -->
                <div class="row">
                    <div class="col-md-12">
                        <div id="log" class="panel-group">
                        </div>
                    </div>
                </div>

                <footer class="row">
                    <div class="col-md-12 text-center">© Copyright 2016.IESAM - UNISC - Universidade de Santa Cruz do Sul - Todos os direitos reservados.</br>
                        <a href="mailto:grohr@mx2.unisc.br">Guilherme Rohr</a>
                    </div>
                </footer>
            </div>
            <!-- /container -->

            <script>window.jQuery || document.write('<script src="assets/jquery/jquery-1.11.3.min.js"><\/script>')</script>
            <script src="assets/bootstrap-3.3.5/js/bootstrap.min.js"></script>
            <script src="assets/main.js"></script>
        </body>
    </html>
