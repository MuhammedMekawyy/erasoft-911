<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Account" %>

<%

    String type = request.getParameter("type");
    boolean isDeposit = "deposit".equalsIgnoreCase(type);

    String title = isDeposit ? "💰 Deposit Money" : "💸 Withdraw Money";
    String subtitle = isDeposit
            ? "Enter the amount you would like to deposit."
            : "Enter the amount you would like to withdraw.";

    String buttonText = isDeposit ? "Deposit" : "Withdraw";
    String action = isDeposit ? "deposit" : "withdraw";
    String buttonClass = isDeposit ? "deposit-btn" : "withdraw-btn";
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title><%= title %></title>

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
    width:430px;
    background:rgba(255,255,255,.12);
    backdrop-filter:blur(18px);
    border-radius:25px;
    padding:40px;
    box-shadow:0 20px 60px rgba(0,0,0,.35);
}

h1{
    color:white;
    text-align:center;
    margin-bottom:10px;
}

.subtitle{
    color:#dbeafe;
    text-align:center;
    margin-bottom:30px;
}

.input-group{
    margin-bottom:20px;
}

.input-group label{
    display:block;
    color:white;
    margin-bottom:8px;
}

.input-group input{
    width:100%;
    padding:14px;
    border:none;
    border-radius:12px;
    font-size:16px;
}

.deposit-btn,
.withdraw-btn{
    width:100%;
    padding:14px;
    border:none;
    border-radius:12px;
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
}

.deposit-btn{
    background:#22c55e;
}

.deposit-btn:hover{
    background:#16a34a;
}

.withdraw-btn{
    background:#ef4444;
}

.withdraw-btn:hover{
    background:#dc2626;
}

.back{
    margin-top:20px;
    text-align:center;
}

.back a{
    color:white;
    text-decoration:none;
}

</style>

</head>

<body>

<div class="container">

    <h1><%= title %></h1>

    <p class="subtitle"><%= subtitle %></p>

    <form action="/EwalletSystem/WalletController" method="post">

        <input type="hidden" name="action" value="<%= action %>">

        <div class="input-group">

            <label>Amount</label>
    

            <input
                type="number"
                name="amount"
                min="100"
                step="100"
                placeholder="Enter amount"
                required>

        </div>

        <button class="<%= buttonClass %>" type="submit">
            <%= buttonText %>
        </button>

    </form>

    <div class="back">
        <a href="mainProfile.jsp">← Back to Profile</a>
    </div>

</div>

</body>
</html>