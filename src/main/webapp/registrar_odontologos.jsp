<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body_primera_parte.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Registrar Odontologo</h1>
                            </div>
                            <form action="SvRegistroOdontologo" method="post" class="user">
                                <div class="form-group">
                                    <input name="apellido" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Apellidos">
                                </div>
                                <div class="form-group">
                                    <input name="especialidad" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Especialidad">
                                </div>
                                <div class="form-group">
                                    <input name="dni" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="DNI">
                                </div>
                                <div class="form-group">
                                    <input name="telefono" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Telefono">
                                </div>
                                <div class="form-group">
                                    <input name="direccion" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Dirección">
                                </div>
                                <div class="form-group">
                                    <input name="fecha_nac" type="text" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="Fecha De Nacimiento">
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">Registrar Odontologo</button>
                            </form>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>
<%@include file="componentes/body_final.jsp"%>