<%@page import="model.ItemDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
ItemDetails itemDetails =
        (ItemDetails) request.getAttribute("SelecteditemDetails");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Item Details</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:'Poppins',sans-serif;
    background:linear-gradient(135deg,#141E30,#243B55);
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:550px;
    background:white;
    padding:35px;
    border-radius:20px;
    box-shadow:0 20px 50px rgba(0,0,0,.35);
}

h2{
    text-align:center;
    color:#243B55;
    margin-bottom:25px;
}

.input-group{
    margin-bottom:20px;
}

label{
    display:block;
    margin-bottom:8px;
    font-weight:bold;
    color:#243B55;
}

input,
textarea{

    width:100%;
    padding:12px;
    border:1px solid #ddd;
    border-radius:10px;
    font-size:15px;
}

textarea{

    resize:vertical;
    min-height:130px;
}

input:focus,
textarea:focus{

    outline:none;
    border-color:#00B4D8;
    box-shadow:0 0 8px rgba(0,180,216,.3);
}

.buttons{

    display:flex;
    justify-content:space-between;
    margin-top:25px;
}

.btn{

    padding:12px 25px;
    border:none;
    border-radius:30px;
    color:white;
    text-decoration:none;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
}

.update-btn{

    background:linear-gradient(135deg,#FFB703,#FB8500);
}

.update-btn:hover{

    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(251,133,0,.4);
}

.cancel-btn{

    background:linear-gradient(135deg,#EF476F,#D90429);
}

.cancel-btn:hover{

    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(217,4,41,.4);
}

</style>

</head>
<body>

<div class="container">

<h2>Update Item Details</h2>

<form action="/ItemsProject/ItemDetailsController" method="post">

    <input type="hidden" name="action" value="updateDetails">

    <input type="hidden"
           name="itemId"
           value="<%= itemDetails.getItem().getId() %>">

    <div class="input-group">

        <label>Description</label>

        <textarea
            name="description"
            required><%= itemDetails.getDescription() %></textarea>

    </div>

    <div class="input-group">

        <label>Warranty (Months)</label>

        <input
            type="number"
            name="warrantyMonths"
            value="<%= itemDetails.getWarrantyMonths() %>"
            required>

    </div>

    <div class="buttons">

        <button class="btn update-btn" type="submit">
            Update
        </button>

        <a href="/ItemsProject/ItemController?action=showItems"
           class="btn cancel-btn">
            Cancel
        </a>

    </div>

</form>

</div>

</body>
</html>