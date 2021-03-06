<%
    if (session.getAttribute("index") != "ok") {
     response.sendRedirect("Controlador_inicio");
    }
%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frmrol
    Created on : 12 nov. 2021, 20:41:51
    Author     : Jhonny
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : period
    Created on : 7 nov. 2021, 15:16:35
    Author     : Jhonny
--%>

<html lang="es">
    <head>
        <title>Period</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>
        <!-- SideBar -->
        <jsp:include page="WEB-INF/sidebar.jsp">
            <jsp:param name="opcion" value="lectivo"></jsp:param>
        </jsp:include>
        <section class="full-box dashboard-contentPage">
            <!-- NavBar -->
            <nav class="full-box dashboard-Navbar">
                <ul class="full-box list-unstyled text-right">
                    <li class="pull-left">
                        <a href="#!" class="btn-menu-dashboard"><i class="zmdi zmdi-more-vert"></i></a>
                    </li>
  
                   
                </ul>
            </nav>

            <br>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-12">

                        <div id="myTabContent " class="tab-content">
                            <div class="tab-pane fade active in" id="new">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12 col-md-10 col-md-offset-1">
                                            <form action="ControladorRol" method="post">
                                                <fieldset> 
                                                    <h2>
                                                        <c:if test="${ro.id_rol==0}">
                                                            Nuevo
                                                        </c:if>
                                                        <c:if test="${ro.id_rol !=0}">
                                                            Editar
                                                        </c:if>
                                                    </h2>
                                                </fieldset>
                                                <div class="form-group label-floating">
                                                     <c:if test="${ro.id_rol==0}">
                                                             <label class="control-label"></label>
                                                    <input  class="form-control" name="id_rol" type="text" value="${0}">
                                               
                                                        </c:if>
                                                        <c:if test="${ro.id_rol !=0}">
                                                            <label class="control-label"></label>
                                                    <input  class="form-control" name="id_rol" type="text" value="${ro.id_rol}">
                                               
                                                        </c:if>
                                                   
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label">Roles</label>
                                                    <select  class="form-control" name="descripcion_rol">
                                                       
                                                        <option selected hidden value="${ro.descripcion_rol}">${ro.descripcion_rol}</option>
                                                           <c:if test="${ro.id_rol==0}">
                                                           <option selected value="">--Selecionar--</option>
                                                        </c:if>
                                                        <option value="usuario">Estudiante</option>
                                                        <option value="administrador">Administrador</option>

                                                    </select>
                                                </div>
                                                <br><br>


                                                <p class="text-center">
                                                    <input type="submit" value=" Enviar" class="btn-danger btn-raised btn-lg">
                                                </p>
                                            </form>
                                        </div>
                                    </div>
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
            $('button').click(function () {
                $('#myModal').modal('show');
            });
        </script>
    </body>
</html>
