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

<html lang="en">
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
                                                    <c:if test="${secid.id_seccion==0}">
                                                        Nuevo
                                                    </c:if>
                                                    <c:if test="${secid.id_seccion !=0}">
                                                        Editar
                                                    </c:if>
                                                </h2>
                                            </fieldset>
                                            <form action="SeccionControlador" method="post">

                                                <div class="form-group label-floating">
                                                    <c:if test="${secid.id_seccion==0}">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label"></label>
                                                            <input  class="form-control" name="id_seccion" type="text"  value="${0}">
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${secid.id_seccion !=0}">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label"></label>
                                                            <input  class="form-control" name="id_seccion" type="text"  value="${secid.id_seccion}">
                                                        </div>
                                                    </c:if>

                                                </div>

                                                <div class="form-group label-floating">
                                                    <label class="control-label">Seccion</label>
                                                    <input selected class="form-control" name="descripcion_sec" type="text" value="${secid.descripcion_sec}">
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label">Estado</label>
                                                    <select  class="form-control" name="estado_sec" ">

                                                        <option selected hidden value="${secid.estado_sec}">${secid.estado_sec}</option>
                                                        <c:if test="${secid.id_seccion==0}">
                                                            <option selected value="">--seleccione--</option>
                                                        </c:if>

                                                        <option value="activo">activo</option>
                                                        <option value="inactivo">inactivo</option>

                                                    </select>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label" >Gestion</label>
                                                    <select class="form-control" name="id_ano_lectivo">
                                                        <option value="">--Seleccione--</option>
                                                        <c:forEach var="item" items="${lecdes}" >
                                                            <c:if test="${item.estado_año=='activo'}">
                                                                <option  value="${item.id_añolectivo}" <c:if test="${item.id_añolectivo == secid.id_ano_lectivo}" >

                                                                         selected
                                                                    </c:if>>

                                                                    ${item.año}
                                                                </option>

                                                            </c:if>



                                                        </c:forEach>
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