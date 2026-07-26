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
}

body{
    font-family:'Poppins',sans-serif;
    background:linear-gradient(135deg,#141E30,#243B55);
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:40px;
}

.container{
    width:420px;
    background:#ffffff;
    border-radius:20px;
    padding:40px 35px;
    box-shadow:0 20px 50px rgba(0,0,0,.35);
    animation:fadeIn .5s ease;
}

h2{
    text-align:center;
    color:#243B55;
    font-size:32px;
    font-weight:700;
    margin-bottom:10px;
}

.subtitle{
    text-align:center;
    color:#777;
    margin-bottom:30px;
    font-size:15px;
}

label{
    display:block;
    margin-top:18px;
    margin-bottom:8px;
    color:#243B55;
    font-size:15px;
    font-weight:600;
}

input{
    width:100%;
    padding:13px 15px;
    border:2px solid #dbe4ec;
    border-radius:12px;
    font-size:15px;
    outline:none;
    background:#fafafa;
    transition:.3s;
}

input:focus{
    border-color:#00B4D8;
    background:#fff;
    box-shadow:0 0 12px rgba(0,180,216,.3);
}

.buttons{
    display:flex;
    gap:15px;
    margin-top:30px;
}

.btn{
    flex:1;
    padding:13px;
    border:none;
    border-radius:30px;
    font-size:16px;
    font-weight:600;
    cursor:pointer;
    transition:.3s;
    text-decoration:none;
    display:flex;
    justify-content:center;
    align-items:center;
}

.btn:hover{
    transform:translateY(-3px);
}

.btn:active{
    transform:scale(.97);
}

.login-btn{
    background:linear-gradient(135deg,#06D6A0,#1B9AAA);
    color:#fff;
}

.login-btn:hover{
    box-shadow:0 12px 25px rgba(6,214,160,.45);
}

.back-btn{
    background:linear-gradient(135deg,#EF476F,#D90429);
    color:#fff;
}

.back-btn:hover{
    box-shadow:0 12px 25px rgba(217,4,41,.45);
}

.signup{
    text-align:center;
    margin-top:20px;
    color:#666;
    font-size:14px;
}

.signup a{
    text-decoration:none;
    color:#1B9AAA;
    font-weight:600;
    transition:.3s;
}

.signup a:hover{
    color:#06D6A0;
}

@keyframes fadeIn{
    from{
        opacity:0;
        transform:translateY(20px);
    }
    to{
        opacity:1;
        transform:translateY(0);
    }
}
</style>

</head>
<body>

<div class="container">

    <h2>Welcome Back</h2>
    <p class="subtitle">Login to your account</p>

    <form action="/ItemsProject/UserController" method="post">

        <input type="hidden" name="action" value="login">

        <label>Username</label>
        <input type="text" name="username" placeholder="Enter your username" required>

        <label>Password</label>
        <input type="password" name="password" placeholder="Enter your password" required>

        <div class="buttons">
            <button type="submit" class="btn login-btn">Login</button>
            <a href="Signup.html" class="btn back-btn">Back</a>
        </div>

        <div class="signup">
            Forgot Password?
            <a href="ResetPassword.html">Reset Password</a>
        </div>

    </form>

</div>

</body>
</html>