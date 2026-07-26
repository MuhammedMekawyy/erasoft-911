<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item Details</title>

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
    width:500px;
    background:#fff;
    padding:35px;
    border-radius:20px;
    box-shadow:0 20px 50px rgba(0,0,0,.35);
}

h2{
    text-align:center;
    color:#243B55;
    margin-bottom:25px;
    font-size:32px;
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
    transition:.3s;
}

textarea{
    resize:vertical;
    min-height:120px;
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
    padding:12px 22px;
    border:none;
    border-radius:30px;
    font-size:15px;
    font-weight:bold;
    cursor:pointer;
    text-decoration:none;
    transition:.3s;
}

.save-btn{
    background:linear-gradient(135deg,#06D6A0,#1B9AAA);
    color:white;
}

.save-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(6,214,160,.45);
}

.cancel-btn{
    background:linear-gradient(135deg,#EF476F,#D90429);
    color:white;
}

.cancel-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(217,4,41,.4);
}

.btn:active{
    transform:scale(.96);
}
</style>

</head>
<body>

<div class="container">

    <h2>Add Item Details</h2>

    <form action="/ItemsProject/ItemDetailsController" method="post">

        <input type="hidden" name="action" value="addDetails">

        <!-- Item ID sent from ItemController -->
        <input type="hidden"
               name="itemId"
               value="<%= request.getParameter("id") %>">

        <div class="input-group">
            <label>Description</label>

            <textarea
                name="description"
                placeholder="Enter item description..."
                required></textarea>
        </div>

        <div class="input-group">
            <label>Warranty (Months)</label>

            <input
                type="number"
                name="warrantyMonths"
                min="0"
                placeholder="Enter warranty period"
                required>
        </div>

        <div class="buttons">

            <button type="submit" class="btn save-btn">
                Save Details
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