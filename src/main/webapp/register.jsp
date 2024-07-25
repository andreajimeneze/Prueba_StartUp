<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="assets/components/head.jsp"%>
    <title>Register</title>
</head>
<body class="bg-custom">
<%@include file="assets/components/header.jsp"%>

<%@include file="assets/components/message.jsp"%>

<h2 class="text-center my-3">Regístrate</h2>
<div class="d-flex justify-content-center ">
    <form class="card " action="registerServlet" method="post">
        <div class="px-3 mx-3 my-3">
            <div class="d-flex flex-column mt-3">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="d-flex flex-column mt-3">
                <label for="name">Nombre</label>
                <input type="text" id="name" name="name" required>
            </div>
                <div class="d-flex flex-column mt-3">
                    <label for="address">Dirección</label>
                    <input type="text" id="address" name="street" required>
                </div>
                <div class="d-flex flex-column mt-3">
                    <label for="number">Número</label>
                    <input type="number" id="number" name="number" required>
                </div>

            <div class="d-flex flex-column mt-3">
                <label for="nick">Nickname</label>
                <input type="text" id="nick" name="nick" required>
            </div>
            <div class="d-flex flex-column mt-3">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="d-flex flex-column mt-3">
                <label for="weight">Peso</label>
                <input type="text" id="weight" name="weight" required>
            </div>
            <div class="d-flex justify-content-center my-3">
                <input type="submit" value="Registrar" class="btn btn-primary">
            </div>
        </div>
    </form>
</div>
<%@include file="assets/components/footer.jsp"%>
