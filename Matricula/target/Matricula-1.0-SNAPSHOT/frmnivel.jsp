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
                                            <fieldset> 
                                                <h2>
                                                    <c:if test="${lis_niv.id_nivel==0}">
                                                        Nuevo
                                                    </c:if>
                                                    <c:if test="${lis_niv.id_nivel !=0}">
                                                        Editar
                                                    </c:if>
                                                </h2>
                                            </fieldset>
                                            <form action="NivelControlador" method="post">

                                                <div class="form-group label-floating">
                                                    <c:if test="${lis_niv.id_nivel==0}">
                                                        <label class="control-label"></label>
                                                        <input  class="form-control" name="Id_nivel" type="text" value="${0}">
                                                    </c:if>
                                                    <c:if test="${lis_niv.id_nivel !=0}">
                                                        <label class="control-label"></label>
                                                        <input  class="form-control" name="Id_nivel" type="text" value="${lis_edi.id_nivel}">
                                                    </c:if>

                                                </div>



                                                <div class="form-group label-floating">
                                                    <label class="control-label">Curso</label>
                                                    <input  class="form-control" name="descripcion_niv" type="text" value="${lis_edi.descripcion_niv}">
                                                </div>

                                                <div class="form-group label-floating">
                                                    <label class="control-label">Fecha </label>
                                                    <input  class="form-control" name="fecha"  type="date" value="${lis_edi.fecha_nive}">
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label" >Seccion</label>
                                                    <select class="form-control" name="id_seccion">
                                                        <c:if test="${lis_niv.id_nivel==0}">
                                                            <option hidden value="">--Seleccione--</option>

                                                        </c:if>
                                                        <c:forEach var="item" items="${lis_sec}" >
                                                            <option value="${item.id_seccion}"<c:if test="${item.id_seccion == lis_edi.id_seccion_niv}">selected</c:if>>
                                                                ${item.descripcion_sec}

                                                            </option>

                                                        </c:forEach>

                                                    </select>
                                                </div>



                                                <div class="form-group">
                                                    <label class="control-label" >Aula</label>
                                                    <select class="form-control" name="id_ula">
                                                        <c:if test="${lis_niv.id_nivel==0}">
                                                            <option  value="">--Seleccione--</option>

                                                        </c:if>

                                                        <c:forEach var="item" items="${lis_aula}" >

                                                            <option value="${item.id_aula}"

                                                                    <c:if test="${item.id_aula == lis_edi.id_aula_niv}">
                                                                        selected
                                                                    </c:if>
                                                                    >
                                                                ${item.descripcion_aula}

                                                            </option>

                                                        </c:forEach>

                                                    </select>
                                                </div>


                                                <div class="form-group">
                                                    <label class="control-label">Estado</label>
                                                    <select  class="form-control" name="estado_niv" >
                                                        <option selected hidden value="${lis_edi.estado_niv}">${lis_edi.estado_niv}</option>
                                                        <c:if test="${lis_niv.id_nivel==0}" >
                                                            <option selected  value="">--Seleccione--</option>

                                                        </c:if>

                                                        <option value="activo">activo</option>
                                                        <option value="inactivo">inactivo</option>

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