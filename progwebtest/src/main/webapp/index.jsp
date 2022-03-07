<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.progwebtest.InventoryDB" %>
<%
    InventoryDB.getInventory();
    session.setAttribute("inventory", InventoryDB.inventory);
%>
<html>
<head>
    <title>Products Web App</title>
</head>
<body>
<div align="center">
    <h1>Products Management</h1>
    <h2>
        <a href="/new.jsp">Add New Book</a>
        <br>
        <a href="#">List All Books</a>
    </h2>
</div>
    <h2>List of Products</h2>
    <%= InventoryDB.inventory.toString() %>
</body>
</html>

