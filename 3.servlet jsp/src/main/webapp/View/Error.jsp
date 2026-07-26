<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family:Arial, sans-serif;
    background:linear-gradient(135deg,#141E30,#243B55);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.container{
    width:500px;
    background:white;
    padding:40px;
    border-radius:15px;
    text-align:center;
    box-shadow:0 15px 40px rgba(0,0,0,.3);
}

h2{
    color:#D90429;
    margin-bottom:20px;
}

p{
    font-size:18px;
    color:#555;
    margin-bottom:30px;
}

a{
    display:inline-block;
    text-decoration:none;
    padding:12px 25px;
    background:#243B55;
    color:white;
    border-radius:25px;
    transition:.3s;
}

a:hover{
    background:#141E30;
}
</style>

</head>
<body>

<div class="container">

<h2>Error</h2>

<p>
<%= request.getAttribute("errorMessage") %>
</p>

<a href="/ItemsProject/ItemController?action=showItems">
Back
</a>

</div>

</body>
</html>