<%@ page import="by.bsuir.entities.City" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Client form</h1>
        <form action="clients?action=${client != null ? 'update' : 'add'}" method="POST">
            <input type="hidden" name="id" value="${client != null ? client.id : ''}" />
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" name="name" value="${client != null ? client.surname : ''}" class="form-control" required MAXLENGTH="20"/>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" name="email" value="${client != null ? client.email : ''}" class="form-control" required MAXLENGTH="20"/>
            </div>
            <div class="mb-3">
                <label for="city" class="form-label">City:</label>
                <select name="cityId" class="form-select" required>
                    <%
                        List<City> cities = (List<City>) request.getAttribute("cities");
                        for (City city: cities) {
                    %>
                    <option value="<%= city.getId() %>" ${client != null && client.getCity().getId() == city.getId() ? 'selected' : ''}><%= city.getNameCity() %></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">${client != null ? 'Update' : 'Add'}</button>
        </form>
</div>
</body>
</html>