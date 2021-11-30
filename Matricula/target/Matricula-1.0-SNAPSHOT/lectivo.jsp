
<%
    if (session.getAttribute("index") != "ok") {
     response.sendRedirect("Controlador_inicio");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : student
    Created on : 7 nov. 2021, 15:21:46
    Author     : Jhonny
--%>
<%
    String opcion = request.getParameter("opcion");
%>
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


            <jsp:param name="opcion" value="nuevolectivo"></jsp:param>

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
                    <h1 class="text-titles"><i class="zmdi zmdi-face zmdi-hc-fw"></i> Administracion <small>Año Lectivo</small></h1>
                </div>
                <div>
                    <td><a href="LectivoControlador?action=add&id_añolectivo=${0}" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-edit zmdi-hc-fw "></i>Nuevo</a></td>
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
                                            <th class="text-center">Inicio</th>
                                            <th class="text-center">Finalizacion</th>
                                            <th class="text-center">Gestion</th>
                                            <th class="text-center">Estado</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${lec}">

                                            <tr>
                                                <td>${item.id_añolectivo}</td>
                                                <td>${item.año_inicio}</td>
                                                <td>${item.año_fin}</td>

                                                <td>${item.año}</td>
                                                <td>${item.estado_año}</td>



                                                <td><a href="LectivoControlador?action=edit&id_añolectivo=${item.id_añolectivo}" class="btn btn-success btn-raised btn-xs"><i class="zmdi zmdi-refresh"></i> Editar</a></td>
                                                <td><a href="LectivoControlador?action=delete&id_añolectivo=${item.id_añolectivo}" onclick="return(confirm('Esta seguro que desea eliminar ???'))" class="btn btn-danger btn-raised btn-xs"><i class="zmdi zmdi-delete"></i></a> Eliminar</td>

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
    <!-- Dialog help -->
    <!-- Button trigger modal -->


    <!-- Modal -->
    <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>


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
