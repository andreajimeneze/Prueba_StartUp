<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <%@include file="assets/components/head.jsp"%>
    <title>Login</title>
</head>
<body class="bg-custom">
<%@include file="assets/components/header.jsp"%>

<h2 class="text-center my-3">Accede a tu cuenta</h2>
<div class="d-flex justify-content-center mt-5">
<form class="card " action="loginServlet" method="post">
<div class="px-3 mx-3 my-3">
    <div class="mt-3">
        <label for="email" class="form-label">Correo electrónico</label>
        <input type="email" class="form-control" id="email"name="email" placeholder="name@example.com">
    </div>
    <div class="mt-3">
        <label for="password" class="form-label">Contraseña</label>
        <input type="password" class="form-control" id="password" name="password">
        <input name="id" value="${user.getId()}" hidden>
    </div>
</div>
    <div class="d-flex justify-content-center mb-5">
        <input type="submit" value="submit" class="btn btn-primary">
    </div>
</form>
</div>

<%@include file="assets/components/message.jsp"%>
<%@include file="assets/components/footer.jsp"%>
