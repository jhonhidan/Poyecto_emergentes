
<%
    if (session.getAttribute("index") != "ok") {
        response.sendRedirect("Controlador_inicio");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

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
                                            <form action="ControladorMatricula" method="post">
                                                <fieldset> 
                                                    <h2>
                                                        <c:if test="${mat.id_matricula==0}">
                                                            Nuevo
                                                        </c:if>
                                                        <c:if test="${mat.id_matricula !=0}">
                                                            Editar
                                                        </c:if>
                                                    </h2>
                                                </fieldset>

                                                <div class="container-fluid">

                                                    <div class="col-md-5">
                                                        <div class="form-group label-floating">
                                                            <label class="control-label"></label>
                                                            <input  class="form-control" name="id_matricula" type="text" value="${mat.id_matricula}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" >Curso</label>
                                                            <select class="form-control" name="id_nivel_mat">

                                                                <c:forEach var="item" items="${niv}" >

                                                                    <option value="${item.id_nivel}"

                                                                            <c:if test="${item.id_nivel == mat.id_nivel_mat}">
                                                                                selected
                                                                            </c:if>
                                                                            >
                                                                        ${item.descripcion_niv} ${item.descripcion_sec}

                                                                    </option>

                                                                </c:forEach>

                                                            </select>
                                                        </div>


                                                        <div class="form-group">
                                                            <label class="control-label" >Estudiante</label>
                                                            <select class="form-control" name="id_estudiante">

                                                                <c:forEach var="item" items="${est}" >

                                                                    <option value="${item.id_estudiante}"

                                                                            <c:if test="${item.id_estudiante == mat.id_estudiante}">
                                                                                selected
                                                                            </c:if>
                                                                            >
                                                                        ${item.nombre_es} ${item.apellido}

                                                                    </option>

                                                                </c:forEach>

                                                            </select>
                                                        </div>

                                                    </div>

                                                    <div class="col-md-5">





                                                        <div class="form-group">
                                                            <label class="control-label">Estado</label>
                                                            <select class="form-control" name="estado">
                                                                <option hidden value="${mat.estado}">${mat.estado}</option>
                                                                <option value="activo">activo</option>
                                                                <option value="inactivo">inactivo</option>

                                                            </select>
                                                        </div>
                                                        <div class="form-group label-floating ">
                                                            <label class="control-label">Fecha</label>
                                                            <input  class="form-control" name="fecha_matricula" type="date" value="${mat.fecha_matricula}">
                                                        </div>
                                                    </div>
                                                </div>


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