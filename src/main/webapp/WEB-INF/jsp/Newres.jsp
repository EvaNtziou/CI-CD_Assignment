<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="application.*" %>	
<!-- 
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Resource</title>
</head>
<body>
    <h1>Add New Resource</h1>
    <form action="/api/resources/add" method="POST">
        <label for="name">Resource Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br>
        <button type="submit">Add Resource</button>
    </form>
    <br>
    <a href="/api/resources/view">Back to Resources</a>
</body>
</html>
