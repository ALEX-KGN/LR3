<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>City Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
</head>
<body>
<div class="container">
    <h1>City Form</h1>
    <form action="cities?action=${city != null ? 'update' : 'add'}" method="POST">
        <input type="hidden" name="id" value="${city != null ? city.id : ''}">
        <div class="mb-3">
            <label for="nameCity" class="form-label">Name:</label>
            <input type="text" id="nameCity" name="nameCity" value="${city != null ? city.nameCity : ''}" required class="form-control" MAXLENGTH="10">
        </div>
        <button type="submit" class="btn btn-primary">${city != null ? 'Update' : 'Add'}</button>
    </form>
    <br>
    <a href="cities?action=list" class="btn btn-secondary">Back to City List</a>
</div>
</body>
</html>