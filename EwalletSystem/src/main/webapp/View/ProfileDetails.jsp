<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account"%>

<%
    Account account = (Account) session.getAttribute("account");

    if (account == null) {
        response.sendRedirect("Signup.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Details</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:"Poppins","Segoe UI",sans-serif;
}

body{
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#0f172a,#1e3a8a,#2563eb);
}

.container{
    width:500px;
    background:rgba(255,255,255,.12);
    backdrop-filter:blur(18px);
    border-radius:25px;
    padding:35px;
    color:white;
    box-shadow:0 20px 60px rgba(0,0,0,.35);
}

h1{
    text-align:center;
    margin-bottom:30px;
}

.row{
    display:flex;
    justify-content:space-between;
    margin:18px 0;
    padding:12px;
    background:rgba(255,255,255,.12);
    border-radius:10px;
}

.label{
    font-weight:bold;
}

.value{
    color:#dbeafe;
}

.back{
    margin-top:30px;
    text-align:center;
}

.back a{
    text-decoration:none;
    color:white;
    background:#2563eb;
    padding:12px 25px;
    border-radius:10px;
}

.back a:hover{
    background:#1d4ed8;
}

</style>

</head>
<body>

<div class="container">

    <h1>👤 Profile Details</h1>

    <div class="row">
        <span class="label">Account ID</span>
        <span class="value"><%= account.getId() %></span>
    </div>

    <div class="row">
        <span class="label">Username</span>
        <span class="value"><%= account.getUsername() %></span>
    </div>

    <div class="row">
        <span class="label">Phone Number</span>
        <span class="value"><%= account.getPhoneNumber() %></span>
    </div>

    <div class="row">
        <span class="label">Age</span>
        <span class="value"><%= account.getAge() %></span>
    </div>

    <div class="row">
        <span class="label">Balance</span>
        <span class="value">$ <%= account.getBalance() %></span>
    </div>

    <div class="back">
        <a href="View/mainProfile.jsp">← Back to Main Profile</a>
    </div>

</div>

</body>
</html>