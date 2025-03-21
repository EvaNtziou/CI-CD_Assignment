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
    <title>View Resources</title>
</head>
<body>
    <h1>View Resources</h1>
    <a href="/api/resources/add">Add New Resource</a><br><br>

    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="resource" items="${resources}">
                <tr>
                    <td>${resource.name}</td>
                    <td>${resource.quantity}</td>
                    <td>
                        <a href="/api/resources/${resource.id}/edit">Edit</a>
                        <a href="/api/resources/${resource.id}/delete">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
