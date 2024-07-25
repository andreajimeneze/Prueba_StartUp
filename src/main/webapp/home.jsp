<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <%@include file="assets/components/head.jsp"%>
    <title>Home</title>
</head>
<body>
<%@include file="assets/components/header.jsp"%>

    <div class="container ms-5 mb-3">
        <h4 class="text-end mt-3">Bienvenido, ${user.name}</h4>
        <div class="container ms-3 interline ">
            <h5>Datos registrados</h5>
            <div class="text-size mt-2">
                <p>Su correo electrónico es: ${user.email}</p>
                <p>Su dirección es: ${address.street} ${address.number}, Valparaíso </p>
                <p>Su rol es: ${role}</p>
                <c:if test="${isAdmin}">
                    <p><strong>* Como administrador puede acceder al link con el listado de automóviles.</strong></p>
                </c:if>
                <c:if test="${!isAdmin}">
                    <p><strong>* Como usuario NO puede acceder a información privilegiada.</strong></p>
                </c:if>

            </div>
        </div>
    </div>
</body>
<c:if test="${isAdmin}">
<div class="text-center mt-5 interline">
    <p>Acceda a información sobre automóviles y los proveedores asociados.</p>
    <a href="loginServlet?action=viewCars">Informe Automóviles</a>
</div>
</c:if>

<%@include file="assets/components/message.jsp"%>

<%@include file="assets/components/footer.jsp"%>