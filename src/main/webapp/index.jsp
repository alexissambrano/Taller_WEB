<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    Object loggedIn = session.getAttribute("loggedIn");
    if (loggedIn == null || !(boolean) loggedIn) {
        response.sendRedirect("login.jsp"); // Redirige al inicio de sesión si no ha iniciado sesión.
    }
%>
<html lang="en">

    <%@include file="componentes/header.jsp"%>
    <%@include file="componentes/body_primera_parte.jsp"%>
    <%@include file="componentes/body_final.jsp"%>

</html>