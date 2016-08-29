<%@page import="com.sv.udb.controlador.AlumnosCtrl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://displaytag.sf.net/el" prefix="display" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>GUIA3_POO2_GERSONMENDOZA</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    
    <body>
    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">GUIA3_POO2_GERSONMENDOZA</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Inicio</a>
                        <a href="Alumno.jsp"><i class="fa fa-fw fa-dashboard"></i> Alumnos</a>
                        <a href="grupoalumno.jsp"><i class="fa fa-fw fa-dashboard"></i> Grupos Alumnos</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            LUGAR ACCESO
                            <small>Mantenimiento</small>
                        </h1>
                        <h1>${mensAler}</h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="index.html">Inicio</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-file"></i> Lugar de acceso
                            </li>
                        </ol>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-lg-12">
                        <form role="form" name="alumBton" method="POST" action="AlumnosServ">
                            <div class="form-group">
                                <label>Nombre</label>
                                <input class="form-control" type="hidden" name="codiAlum" value="${codiAlum}">
                                <input class="form-control" type="text" name="nombAlum" value="${nombAlum}" required>
                            </div>
                            <div class="form-group">
                                <label>Apellido</label>
                                <input class="form-control" type="text" name="apelAlum" value="${apelAlum}" required>
                            </div>
                            <div class="form-group">
                                <label>Fecha nacimiento</label>
                                <input class="form-control" type="date" name="fechAlum" value="${fechAlum}" required>
                            </div>
                            <div class="form-group">
                                <label>Email</label>
                                <input class="form-control" type="text" name="mailAlum" value="${mailAlum}" required>
                            </div>
                            <div class="form-group">
                                <label>Telefono</label>
                                <input class="form-control" type="text" name="teleAlum" value="${teleAlum}" required>
                            </div>
                            <div class="form-group">
                                <label>Direccion</label>
                                <input class="form-control" type="text" name="direAlum" value="${direAlum}" required>
                            </div>
                            <div class="form-group">
                                <label>Genero</label>
                                <select class="form-control" name="geneAlum">
                                    <option value="M">Masculino</option>
                                    <option value="F">Femenino</option>
                                </select>
                            </div>
                            <input type="submit" name="alumBton" value="Guardar" class="btn btn-primary"/>
                        </form>
                    </div>
                </div>
                        <br>
                        <div class="row" id="table" >
                <form method="POST" name="Frm" action="AlumnosServ">
                    <% request.setAttribute( "demoAttr", new AlumnosCtrl().consTodo()); %>
                <display:table id="Persona" name="demoAttr" class="table table-hover">
                    <display:column property="nombAlum" title="Nombres" sortable="true"/>
                    <display:column property="apelAlum" title="Apellidos" sortable="true"/>
                    <display:column property="fechNaciAlum" title="Fecha" sortable="true"/>
                    <display:column property="mailAlum" title="Correo" sortable="true"/>
                    <display:column property="teleAlum" title="Telefono" sortable="true"/>
                    <display:column property="direAlum" title="Direccion" sortable="true"/>
                    <display:column property="geneAlum" title="Genero" sortable="true"/>
                </display:table>
                </form>
            </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    </body>

</html>

