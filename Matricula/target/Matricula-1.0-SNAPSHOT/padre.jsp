<%
    if (session.getAttribute("index") != "ok") {
     response.sendRedirect("Controlador_inicio");
    }
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : seccion
    Created on : 11 nov. 2021, 18:18:44
    Author     : Jhonny
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Student</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>
        <!-- SideBar -->
        <jsp:include page="WEB-INF/sidebar.jsp">


            <jsp:param name="action" value="view"></jsp:param>

        </jsp:include>

        <!-- Content page-->
        <section class="full-box dashboard-contentPage">
            <!-- NavBar -->
            <nav class="full-box dashboard-Navbar">
                <ul class="full-box list-unstyled text-right">
                    <li class="pull-left">
                        <a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
                    </li>
                   
                    <li>
                        <a href="Lagout" class="btn-block">
                            <i class="zmdi zmdi-power"></i>
                        </a>
                    </li>
                 
                </ul>
            </nav>
            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-face zmdi-hc-fw"></i>Usuarios <small>Padre</small></h1>
                </div>
                <div>
                    <td><a href="PadreControlador?action=add&id_padre=${0}" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-edit zmdi-hc-fw"></i>Nuevo</a></td>
                </div>
                <div class="full-box text-center" style="padding: 0px 0px;margin-top: 0px;">
               	
                </div>

            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12">


                        <div class="tab-pane active in fade" id="list">
                            <div class="table-responsive">
                                <table class="table table-hover text-center">
                                    <thead>
                                        <tr>
                                            <th class="text-center">ID</th>
                                            <th class="text-center">Nombre</th>
                                            <th class="text-center">Telefono</th>
                                            <th class="text-center">Direccion</th>


                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${pads}">

                                            <tr>
                                                <td>${item.id_padre}</td>
                                                <td>${item.nombre}</td>
                                                <td>${item.telefono}</td>
                                                <td>${item.direcion}</td>
                                               
                                                <td><a href="PadreControlador?action=edit&id_padre=${item.id_padre}" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i> Editar</a></td>
                                                <td><a href="PadreControlador?action=delete&id_padre=${item.id_padre}" onclick="return(confirm('Esta seguro que desea eliminar ???'))" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a> Eliminar</td>
                                           
                                            </tr>  

                                        </c:forEach>




                                    </tbody>
                                </table>
                             
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

   
    <!--====== Scripts -->
    <script src="./js/jquery-3.1.1.min.js"></script>
    <script src="./js/sweetalert2.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/material.min.js"></script>
    <script src="./js/ripples.min.js"></script>
    <script src="./js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="./js/main.js"></script>
    <script>
        $.material.init();
    </script>
</body>
</html>

