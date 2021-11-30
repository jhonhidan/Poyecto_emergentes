
<%
    if (session.getAttribute("index") != "ok") {
     response.sendRedirect("Controlador_inicio");
    }
%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : impresion_mat
    Created on : 27 nov. 2021, 8:06:26
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
                        <a href="#!" class="btn-search">
                            <i class="zmdi zmdi-search"></i>
                        </a>
                    </li>

                </ul>
            </nav>
            <!-- Content page -->
            <div class="container-fluid">
                <div class="page-header">
                    <h1 class="text-titles"><i class="zmdi zmdi-face zmdi-hc-fw"></i> Administracion <small>Impresion</small></h1>
                </div>


            </div>
            <div class="container"data-spy="scroll" style="width: 600px">

                <div class="card text-center" >
                    
                    <div class="card-header">
                        <b>MATRICULA ESTUDIANTIL EDUCATIVO</b>
                    </div>
                    <div class="card-header">
                        <small><b>UNIDAD EDUCATIVA SAN ROQUE</b></small>
                    </div>
                    <div class="card-body container">
                        <div class="card-header col-md-1">

                            <div class="card-header "width="50%" height="50%">
                                <div class="card-header  ">
                                    <img src="${mat.foto}" width="50px" height="50px" alt="alt"/>
                                </div><!-- comment -->
                                <div class="card-header  ">
                                    <small>${mat.cedula}</small>
                                    <br>
                                    <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Cedula</b></small></small></small>

                                </div>

                            </div>
                        </div>
                        <div class="card-header col-md-2">
                            <div class=" no-paddin-left ">
                                <small><u>${mat.nombre_es} ${mat.apellidos}</u></small>
                                <br>
                                <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Nombre completo</b></small></small></small>
                                <br><!-- comment -->
                                <small><u>${mat.fecha_nacimiento}</u></small>
                                <br>
                                <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Fecha de Nacimiento</b></small></small></small>

                            </div>

                        </div>
                        <div class="card-header  col-md-2">
                            <small><u>${mat.descripcion_niv} / ${mat.descripcion_sec}  </u></small>
                            <br>
                            <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Curso</b></small></small></small>
                            <br>
                            <small><u>${mat.edad} </u></small>
                            <br>
                            <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Edad</b></small></small></small>
                            <br><!-- comment -->

                        </div>
                        <div class="card-header  col-md-1">

                            <small><u>${mat.año} </u></small>
                            <br>
                            <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Gestion</b></small></small></small>
                            <br>
                            <small><u>${mat.descripcion_aula} </u></small>
                            <br>
                            <small style="margin-top: 0px; padding-top: 0px"><small><small><b>Aula</b></small></small></small>

                        </div>
                    </div>
                    <div class="card-footer">
                        <small style="margin-top: 0px; padding-top: 0px"><small><small><b>
                                    

                                    </b></small></small></small>

                        <small style="margin-top: 0px; padding-top: 0px"><small><small><b>LA PAZ-BOLIVIA</b></small></small></small>
                        
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

