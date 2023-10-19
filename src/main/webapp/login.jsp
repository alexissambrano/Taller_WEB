<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <title>Login Page</title>
</head>
<body>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Tabs Titles -->
            <h2 class="active"> Iniciar sesión </h2>
            <h2 class="inactive underlineHover">Registrarse </h2>
            <!-- Icon -->
            <div class="fadeIn first">
                <img src="https://www.svgrepo.com/show/313375/user.svg" id="icon" alt="User Icon" /> 
            </div>
            <!-- Login Form -->
            <form action="SvLogin" class="form-signin" method="post"><form>
                <input type="text" id="login" class="fadeIn second" name="usernameE" placeholder="usuario">
                <input type="text" id="password" class "fadeIn third" name="contrasenia" placeholder="contraseña">
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form>
            <!-- Remind Passowrd -->
            <div id="formFooter">
                <a class="underlineHover" href="#">¿Has olvidado tu contraseña?</a>
            </div>
        </div>
    </div>
</body>
</html>
