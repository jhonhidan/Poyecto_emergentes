
<%
     if (session.getAttribute("index") != "ok") {
     response.sendRedirect("Controlador_inicio");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                                            <fieldset> 
                                                <h2>
                                                    <c:if test="${lecid.id_añolectivo==0}">
                                                        Nuevo
                                                    </c:if>
                                                    <c:if test="${lecid.id_añolectivo !=0}">
                                                        Editar
                                                    </c:if>
                                                </h2>
                                            </fieldset>
                                            <form action="LectivoControlador" method="post">

                                                <div class="form-group label-floating">

                                                    <c:if test="${lecid.id_añolectivo==0}">
                                                        <label class="control-label">sdfsdf</label>
                                                        <input  class="form-control" name="id_anolectivo" type="text" value="${0}">

                                                    </c:if>
                                                    <c:if test="${lecid.id_añolectivo !=0}">
                                                        <label class="control-label">sdfsdfsfffffffffffffffff</label>
                                                        <input  class="form-control" name="id_anolectivo" type="text" value="${lecid.id_añolectivo}">

                                                    </c:if>

                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Inicio de Año</label>
                                                    <input class="form-control" name="ano_inicio" type="date" value="${lecid.año_inicio}">
                                                </div>
                                                <div class="form-group label-floating">
                                                    <label class="control-label">Fin de Año</label>
                                                    <input class="form-control" name="ano_fin"  type="date" value="${lecid.año_fin}">
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label">Estado</label>
                                                    <select class="form-control" name="estado_ano" >
                                                        <option selected  hidden value="${lecid.estado_año}">${lecid.estado_año}</option>
                                                        <c:if test="${lecid.id_añolectivo==0}">
                                                            <option selected value="">--seleccione--</option>
                                                        </c:if>
                                                        <option value="activo">activo</option>
                                                        <option value="inactivo">inactivo</option>

                                                    </select>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label">Gestion</label>
                                                    <select  class="form-control" name="ano">
                                                       
                                                        <option selected hidden value="${lecid.año}">${lecid.año}</option>
                                                        <c:if test="${lecid.id_añolectivo==0}">
                                                            <option selected value="">--seleccione--</option>
                                                        </c:if>
                                                        <option value="2021">2021</option>
                                                        <option value="2022">2022</option>
                                                        <option value="2023">2023</option>
                                                        <option value="2024">2024</option>
                                                        <option value="2025">2025</option>
                                                        <option value="2026">2026</option>
                                                        <option value="2027">2027</option>
                                                        <option value="2028">2028</option>
                                                        <option value="2029">2029</option>
                                                        <option value="2030">2030</option>
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
