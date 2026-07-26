<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

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
    filter:blur(120px);
    z-index:-1;
}

body::before{
    width:320px;
    height:320px;
    background:#38bdf8;
    top:-80px;
    left:-80px;
}

body::after{
    width:360px;
    height:360px;
    background:#7c3aed;
    bottom:-120px;
    right:-120px;
}

.container{

    width:430px;
    padding:40px;

    background:rgba(255,255,255,.12);
    backdrop-filter:blur(18px);

    border:1px solid rgba(255,255,255,.18);

    border-radius:25px;

    box-shadow:0 20px 60px rgba(0,0,0,.35);

}

.logo{

    text-align:center;
    font-size:58px;
    margin-bottom:10px;

}

h1{

    color:white;
    text-align:center;
    margin-bottom:8px;
    font-size:34px;

}

.subtitle{

    color:#dbeafe;
    text-align:center;
    margin-bottom:30px;
    font-size:15px;

}

.input-group{

    margin-bottom:18px;

}

.input-group label{

    display:block;
    color:white;
    margin-bottom:8px;
    font-weight:500;

}

.input-group input{

    width:100%;
    padding:14px 16px;

    border:none;
    outline:none;

    border-radius:12px;

    background:rgba(255,255,255,.92);

    font-size:15px;

    transition:.3s;

}

.input-group input:focus{

    box-shadow:0 0 0 3px rgba(59,130,246,.4);

}

.login-btn{

    width:100%;

    margin-top:10px;

    padding:14px;

    border:none;

    border-radius:12px;

    background:linear-gradient(135deg,#2563eb,#1d4ed8);

    color:white;

    font-size:16px;
    font-weight:600;

    cursor:pointer;

    transition:.3s;

}

.login-btn:hover{

    transform:translateY(-3px);

    box-shadow:0 12px 28px rgba(37,99,235,.45);

}

.links{

    margin-top:20px;
    text-align:right;

}

.links a{

    color:#dbeafe;

    text-decoration:none;

    font-size:14px;

    transition:.3s;

}

.links a:hover{

    color:white;

}

.footer{

    margin-top:30px;

    text-align:center;

}

.back-btn{

    background:transparent;

    border:2px solid rgba(255,255,255,.35);

    color:white;

    padding:11px 32px;

    border-radius:12px;

    font-size:15px;

    font-weight:600;

    cursor:pointer;

    transition:.3s;

}

.back-btn:hover{

    background:rgba(255,255,255,.15);

    border-color:white;

    transform:translateY(-2px);

}

</style>

</head>

<body>

<div class="container">

    <div class="logo">🏦</div>

    <h1>Welcome Back</h1>

    <p class="subtitle">
        Login to continue to your banking account.
    </p>

    <form action="/EwalletSystem/AccountController" method="post">

        <input type="hidden" name="action" value="login">

        <div class="input-group">

            <label>Username</label>

            <input
                type="text"
                name="username"
                placeholder="Enter your username"
                required>

        </div>

        <div class="input-group">

            <label>Password</label>

            <input
                type="password"
                name="password"
                placeholder="Enter your password"
                required>

        </div>

        <button class="login-btn" type="submit">
            Login
        </button>

    </form>

    <div class="links">

        <a href="ResetPassword.html">
            Forgot Password?
        </a>

    </div>

    <div class="footer">

        <button
            type="button"
            class="back-btn"
            onclick="window.location.href='Signup.html'">

            ← Back

        </button>

    </div>

</div>

</body>
</html>