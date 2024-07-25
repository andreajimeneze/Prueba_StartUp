<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <%@include file="assets/components/head.jsp"%>
    <title>Home</title>
</head>
<body>
<%@include file="assets/components/header.jsp"%>

<h2 class="mt-5">Listado de Automóviles y Proveedores</h2>
<table class="table mt-3">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Imagen</th>
        <th scope="col">Modelo</th>
        <th scope="col">Proveedor</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="car" items="${listCars}" >
    <tr>
        <th scope="row">${car.id}</th>
        <td><img class="img img-fluid" src="${car.url}" alt="Imagen de auto ${car.supplierName} ${car.model}"></td>
        <td>${car.model}</td>
        <td>${car.supplierName}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<%@include file="assets/components/footer.jsp"%>

