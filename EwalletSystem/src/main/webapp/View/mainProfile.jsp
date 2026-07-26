<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.Account" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Profile</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:"Poppins","Segoe UI",sans-serif;
}

body{
    min-height:100vh;
    background:linear-gradient(135deg,#0f172a,#1e3a8a,#2563eb);
    display:flex;
    justify-content:center;
    align-items:center;
    overflow:hidden;
}

/* Background Circles */

body::before,
body::after{
    content:"";
    position:absolute;
    border-radius:50%;
    filter:blur(100px);
    z-index:-1;
}

body::before{
    width:280px;
    height:280px;
    background:#38bdf8;
    top:-80px;
    left:-80px;
}

body::after{
    width:320px;
    height:320px;
    background:#7c3aed;
    bottom:-120px;
    right:-120px;
}

/* Main Box */

.dashboard{
    width:95%;
    max-width:1350px;
    background:rgba(255,255,255,.12);
    backdrop-filter:blur(18px);
    border:1px solid rgba(255,255,255,.15);
    border-radius:25px;
    padding:30px;
    box-shadow:0 20px 60px rgba(0,0,0,.35);
}

/* Header */

.header{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:35px;
}

.logo{
    color:white;
    font-size:30px;
    font-weight:700;
    letter-spacing:1px;
}

.logout{
    text-decoration:none;
    color:white;
    background:#ef4444;
    padding:10px 22px;
    border-radius:12px;
    font-weight:600;
    transition:.3s;
}

.logout:hover{
    background:#dc2626;
    transform:translateY(-2px);
}

/* Welcome */

.welcome{
    text-align:center;
    color:white;
    margin-bottom:35px;
}

.welcome h2{
    font-size:36px;
    margin-bottom:10px;
}

.welcome p{
    color:#dbeafe;
    font-size:17px;
}

/* Cards */

.cards{
    display:grid;
    grid-template-columns:repeat(5,1fr);
    gap:22px;
}

.card{
    background:white;
    border-radius:20px;
    padding:22px;
    text-align:center;
    transition:.35s;
    box-shadow:0 12px 25px rgba(0,0,0,.12);
}

.card:hover{
    transform:translateY(-8px);
    box-shadow:0 20px 35px rgba(0,0,0,.22);
}

.icon{
    font-size:48px;
    margin-bottom:15px;
}

.card h3{
    color:#1f2937;
    margin-bottom:10px;
}

.card p{
    color:#6b7280;
    font-size:14px;
    line-height:1.5;
    min-height:45px;
    margin-bottom:18px;
}

/* Buttons */

.card button{
    width:100%;
    border:none;
    padding:12px;
    border-radius:12px;
    color:white;
    font-size:15px;
    font-weight:600;
    cursor:pointer;
    transition:.3s;
}

/* Individual Colors */

.deposit button{
    background:linear-gradient(135deg,#22c55e,#16a34a);
}

.withdraw button{
    background:linear-gradient(135deg,#fb923c,#ea580c);
}

.transfer button{
    background:linear-gradient(135deg,#3b82f6,#2563eb);
}

.details button{
    background:linear-gradient(135deg,#8b5cf6,#7c3aed);
}

.remove button{
    background:linear-gradient(135deg,#ef4444,#dc2626);
}

.card button:hover{
    transform:scale(1.05);
}

/* Responsive */

@media(max-width:1100px){

.cards{
    grid-template-columns:repeat(2,1fr);
}

}

@media(max-width:700px){

.cards{
    grid-template-columns:1fr;
}

.header{
    flex-direction:column;
    gap:15px;
}

.dashboard{
    margin:20px;
}

}

</style>

</head>

<body>


<%
    Account account = (Account) session.getAttribute("account");

    if (account == null) {
        response.sendRedirect("Signup.html");
        return;
    }
%>


<div class="dashboard">

    <div class="header">

        <div class="logo">🏦 EraSoft E-Wallet</div>

        <a href="/EwalletSystem/AccountController?action=logout" class="logout">
            Logout
        </a>

    </div>

    <div class="welcome">

        <h2>Welcome, <%= account.getUsername()%> 👋</h2>

        <p>Select the banking service you want to use.</p>

    </div>

    <div class="cards">

        <div class="card deposit">

            <div class="icon">💰</div>

            <h3>Deposit</h3>

            <p>Add funds securely to your account.</p>

            <form action="Transaction.jsp" method="get">
                <input type="hidden" name="type" value="deposit">
                <button>Deposit</button>
            </form>

        </div>

        <div class="card withdraw">

            <div class="icon">💸</div>

            <h3>Withdraw</h3>

            <p>Withdraw money quickly and safely.</p>

            <form action=Transaction.jsp method="get">
                <input type="hidden" name="type" value="withdraw">
                <button>Withdraw</button>
            </form>

        </div>

        <div class="card transfer">

            <div class="icon">🔄</div>

            <h3>Transfer</h3>

            <p>Send money to another account.</p>

            <form action="Transfer.jsp" method="get">
                <input type="hidden" name="action" value="Transfer">
                <button>Transfer</button>
            </form>

        </div>

        <div class="card details">

            <div class="icon">👤</div>

            <h3>Profile</h3>

            <p>View your personal account details.</p>

            <form action="/EwalletSystem/WalletController" method="get">
                <input type="hidden" name="action" value="showProfileDetails">
                <button>Details</button>
            </form>

        </div>

        <div class="card remove">

            <div class="icon">🗑️</div>

            <h3>Remove</h3>

            <p>Permanently delete your account.</p>

            <form action="/EwalletSystem/AccountController"
                  method="post"
                  onsubmit="return confirm('Are you sure you want to remove your account?');">

                <input type="hidden" name="action" value="deleteAccount">

                <button>Remove</button>

            </form>

        </div>

    </div>

</div>

</body>
</html>