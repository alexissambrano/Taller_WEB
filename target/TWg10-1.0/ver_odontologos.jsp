<%@page import="persistencia.Odontologo"%>
<%@page import="java.util.List"%>
r<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="componentes/header.jsp"%>
<%@include file="componentes/body_primera_parte.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body id="page-top">
    <!-- Nav Item - Tables -->
            <li class="nav-item active">
                <a class="nav-link" href="ver_odontologos.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Odontologos</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Odontologos</h1>
                    <p class="mb-4">Lista de odontologos disponibles</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Apellido</th>
                                            <th>Especialidad</th>
                                            <th>DNI</th>
                                            <th>Telefono</th>
                                            <th>Direccion</th>
                                            <th>Fecha Nacimiento</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            List<Odontologo> listaOdontologos = (List<Odontologo>) request.getAttribute("listaOdontologos");
                                            for (Odontologo odontologo : listaOdontologos) {
                                        %>
                                        <tr>
                                            <td><%= odontologo.getApellido() %></td>
                                            <td><%= odontologo.getEspecialidad() %></td>
                                            <td><%= odontologo.getDni() %></td>
                                            <td><%= odontologo.getTelefono() %></td>
                                            <td><%= odontologo.getDireccion() %></td>
                                            <td><%= odontologo.getFecha_nac() %></td>
                                            <!-- Agrega más columnas según tu modelo de datos -->
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
</body>

</html>
<%@include file="componentes/body_final.jsp"%>