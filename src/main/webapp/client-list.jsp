<%@ page import="by.bsuir.entities.Person" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Clients</h1>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>City</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Person> clients = (List<Person>) request.getAttribute("clients");
            for (Person client: clients) {
        %>
        <tr>
            <td><%= client.getId() %></td>
            <td><%= client.getSurname() %></td>
            <td><%= client.getEmail() %></td>
            <td><%= client.getCity().getNameCity() %></td>
            <td>
                <a class="btn btn-primary" href="clients?action=edit&id=<%= client.getId() %>">Edit</a>
                <a class="btn btn-danger" href="clients?action=delete&id=<%= client.getId() %>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <br>
    <a class="btn btn-success" href="clients?action=showForm">Add Client</a>
    <a class="btn btn-primary" href="cities">Cities</a>
</div>
</body>
</html>