<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Item Form</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .form-container { width: 400px; margin: auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; }
        input { width: 100%; padding: 8px; box-sizing: border-box; }
        button { padding: 10px 20px; cursor: pointer; }
    </style>
</head>
<body>

<div class="form-container">
    <h2>${item.id != null ? "Update Item" : "Add Item"}</h2>

    <form action="/save" method="post">

        <input type="hidden" name="id" value="${item.id}">

        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" value="${item.name}" required>
        </div>

        <div class="form-group">
            <label>Price:</label>
            <input type="number" name="price" step="0.01" value="${item.price}" required>
        </div>

        <div class="form-group">
            <label>Total Number:</label>
            <input type="number" name="totalNumber" value="${item.totalNumber}" required>
        </div>

        <button type="submit">Save Item</button>

    </form>
</div>

</body>
</html>