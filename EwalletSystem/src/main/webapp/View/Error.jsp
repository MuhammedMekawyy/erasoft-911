<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.Account" %>

<%
    Account account = (Account) session.getAttribute("account");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Error</title>

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
    overflow:hidden;
}

body::before,
body::after{
    content:"";
    position:absolute;
    border-radius:50%;
    filter:blur(100px);
    z-index:-1;
}

body::before{
    width:300px;
    height:300px;
    background:#38bdf8;
    top:-80px;
    left:-80px;
}

body::after{
    width:350px;
    height:350px;
    background:#7c3aed;
    bottom:-120px;
    right:-120px;
}

.container{
    width:520px;
    background:rgba(255,255,255,.12);
    backdrop-filter:blur(18px);
    border:1px solid rgba(255,255,255,.18);
    border-radius:25px;
    padding:40px;
    box-shadow:0 20px 60px rgba(0,0,0,.35);
    text-align:center;
}

.icon{
    font-size:70px;
    margin-bottom:15px;
}

h1{
    color:white;
    font-size:34px;
    margin-bottom:10px;
}

.message{
    color:#dbeafe;
    font-size:17px;
    line-height:1.6;
    margin-bottom:30px;
    word-break:break-word;
}

.actions{
    display:flex;
    justify-content:center;
}

.actions a{
    display:inline-block;
    text-decoration:none;
    color:white;
    font-weight:600;
    padding:12px 28px;
    border-radius:12px;
    transition:.3s;
    background:linear-gradient(135deg,#3b82f6,#2563eb);
}

.actions a:hover{
    transform:translateY(-2px);
    box-shadow:0 10px 25px rgba(37,99,235,.35);
}

</style>
</head>

<body>

<div class="container">

    <div class="icon">⚠️</div>

    <h1>Something went wrong</h1>

    <div class="message">
        ${errorMessage}
    </div>

    <div class="actions">

        <% if (account != null) { %>

            <a href="<%=request.getContextPath()%>/WalletController?action=mainProfile">
                Back to Main Profile
            </a>

        <% } else { %>

            <a href="<%=request.getContextPath()%>/View/Signup.html">
                Back to Signup
            </a>

        <% } %>

    </div>

</div>

</body>
</html>