<%@ page import="by.bsuir.entities.City" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CITIES</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="container">
    <h1>City List</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<City> cities = (List<City>) request.getAttribute("cities");
            for (City city: cities) {
        %>
        <tr>
            <td><%= city.getId() %></td>
            <td><%= city.getNameCity() %></td>
            <td>
                <a class="btn btn-primary" href="cities?action=edit&id=<%= city.getId() %>">Edit</a>
                <a class="btn btn-danger" href="cities?action=delete&id=<%= city.getId() %>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <br>
    <a class="btn btn-success" href="cities?action=showForm">Add City</a>
    <a class="btn btn-primary" href="clients">Clients</a>
</div>

</body>
</html>