<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Items</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        table { width: 100%; border-collapse: collapse; margin-bottom: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        a.action-btn {
            display: inline-block;
            margin-right: 5px;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
            font-size: 13px;
        }
        .update-btn { background-color: #ffc107; color: #000; }
        .delete-btn { background-color: #dc3545; color: #fff; }
        .add-btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #28a745;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>

<h2>All Items</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Total Number</th>
        <th>Actions</th>
    </tr>

    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.totalNumber}</td>
            <td>
                <a class="action-btn update-btn" href="/items/edit/${item.id}">Update</a>
                <a class="action-btn delete-btn" href="/items/delete/${item.id}"
                   onclick="return confirm('Delete this item?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a class="add-btn" href="/form">+ Add Item</a>

</body>
</html>