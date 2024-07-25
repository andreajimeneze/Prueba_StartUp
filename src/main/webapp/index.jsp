<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <%@include file="assets/components/head.jsp"%>
  <title>Welcome</title>
</head>
<body class="bg-custom">
<%@include file="assets/components/header.jsp"%>
<br/>
  <div class="mb-5 mt-3 text-center">
    <h1 >Bienvenid@</h1>
    <p>Si estás registrado ingresa a la sesión, de lo contrario accede al botón registrarse de más abajo.</p>
  </div>
  <div class="d-flex justify-content-center align-items-center">
  <button type="button" class="btn btn-outline-primary btn-lg w-33 mx-2">
    <a class="no-underline" href="login.jsp">Ingresar sesión</a>
  </button>
  <button type="button" class="btn btn-outline-primary btn-lg w-33 mx-2">
    <a class="no-underline" href="register.jsp">Registrarse</a>
  </button>
</div>





<%@include file="assets/components/footer.jsp"%>