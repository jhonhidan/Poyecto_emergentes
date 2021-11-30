
<%
    if (session.getAttribute("index") != "ok") {
        response.sendRedirect("Controlador_inicio");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : frmestudiante
    Created on : 27 nov. 2021, 12:41:09
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
            <jsp:param name="opcion" value="aula"></jsp:param>
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
                                                    <c:if test="${est.id_estudiante==0}">
                                                        Nuevo
                                                    </c:if>
                                                    <c:if test="${est.id_estudiante !=0}">
                                                        Editar
                                                    </c:if>
                                                </h2>
                                            </fieldset>

                                            <form action="EstudianteControlador" method="post">

                                                <div class="container-fluid">



                                                    <div class="col-md-5">
                                                        <div class="form-group label-floating ">

                                                            <c:if test="${est.id_estudiante==0}">
                                                                 <input  class="form-control" name="id_estudiante" type="text" value="${0}">
                                                            </c:if>
                                                            <c:if test="${est.id_estudiante !=0}">

                                                                <input  class="form-control" name="id_estudiante" type="text" value="${est.id_estudiante}">
                                                            </c:if>


                                                        </div>



                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Nombre</label>
                                                            <input selected class="form-control" name="nombre_es" type="text" value="${est.nombre_es}">
                                                        </div>

                                                        <div class="form-group label-floating ">
                                                            <label class="control-label">Apellido completo</label>
                                                            <input selected class="form-control" name="apellidos"  type="text" value="${est.apellido}">
                                                        </div>


                                                        <div class="form-group label-floating ">
                                                            <label class="control-label">Cedula</label>
                                                            <input selected class="form-control"name="cedula"  type="text" value="${est.cedula}">
                                                        </div>
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Edad</label>
                                                            <input selected class="form-control" name="edad"  type="number" value="${est.edad}">
                                                        </div>
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Fecha Nacimiento</label>
                                                            <input selected class="form-control" name="fecha_nacimiento"  type="date" value="${est.fecha_naciemto}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label">Genero</label>
                                                            <select class="form-control" name="genero" >
                                                                <option selected hidden value="${est.genero}"  >
                                                                    <c:if test="${est.genero == 'M'}">
                                                                        Masculino
                                                                    </c:if>
                                                                    <c:if test="${est.genero == 'F'}">
                                                                        Femenino
                                                                    </c:if>

                                                                </option>
                                                                <c:if test="${est.id_estudiante==0}">
                                                                    <option selected value="">--Selecione--</option>
                                                                </c:if>

                                                                <option value="M">Maculino</option>
                                                                <option value="F">Femenino</option>

                                                            </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label" >Padre</label>
                                                            <select class="form-control" name="id_padre" >
                                                                <c:if test="${est.id_estudiante==0}">
                                                                    <option selected value="">--Selecione--</option>
                                                                </c:if>

                                                                <c:forEach var="item" items="${pad}" >

                                                                    <option value="${item.id_padre}" <c:if test="${item.id_padre == est.id_padre}">selected </c:if>>
                                                                        ${item.nombre}

                                                                    </option>

                                                                </c:forEach>

                                                            </select>
                                                        </div>
                                                    </div>

                                                    <div class="col-md-5">


                                                        <div class="form-group label-floating">
                                                            <label class="control-label">foto</label>
                                                            <input selected class="form-control" name="foto"  type="text" value="${est.foto}">
                                                        </div>
                                                        <div class="form-group label-floating">
                                                            <label class="control-label">Correo Electronico</label>
                                                            <input selected class="form-control" name="correo_estu"  type="text" value="${est.correo_estu}">
                                                        </div>


                                                        <div class="form-group">
                                                            <label class="control-label">Estado</label>
                                                            <select  class="form-control" name="estado_estu">
                                                                <option selected hidden value="${est.estado_estu}">${est.estado_estu}</option>
                                                                <c:if test="${est.id_estudiante==0}">
                                                                    <option selected value="">--Selecione--</option>
                                                                </c:if>
                                                                <option value="activo">activo</option>
                                                                <option value="inactivo">inactivo</option>

                                                            </select>
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

    </body>
</html>

