<%@page import="model.Item"%>
<%@page import="model.Users"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.Cookie"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Items List</title>

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
    padding:50px;
}

.container{
    width:90%;
    max-width:1200px;
    margin:auto;
    background:#ffffff;
    border-radius:20px;
    padding:35px;
    box-shadow:0 20px 50px rgba(0,0,0,.35);
}

h2{
    text-align:center;
    font-size:34px;
    color:#243B55;
    margin-bottom:30px;
    font-weight:700;
    letter-spacing:1px;
}

.top-bar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:25px;
}

.welcome{
    font-size:20px;
    font-weight:bold;
    color:#243B55;
}

.actions{
    display:flex;
    align-items:center;
    gap:10px;
}

table{
    width:100%;
    border-collapse:collapse;
    overflow:hidden;
    border-radius:15px;
}

th{
    background:linear-gradient(90deg,#00C9A7,#00B4D8);
    color:white;
    padding:18px;
    font-size:15px;
    text-transform:uppercase;
    letter-spacing:1px;
}

td{
    padding:18px;
    text-align:center;
    color:#444;
    font-size:15px;
    border-bottom:1px solid #ececec;
}

tbody tr,
tr{
    transition:.3s;
}

tr:nth-child(even){
    background:#f8fbfd;
}

tr:hover{
    background:#dff8f5;
    transform:scale(1.003);
}

.btn{
    padding:10px 20px;
    border:none;
    border-radius:30px;
    font-size:14px;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
    text-decoration:none;
}

.add-btn{
    background:linear-gradient(135deg,#06D6A0,#1B9AAA);
    color:white;
}

.add-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(6,214,160,.45);
}

.update-btn{
    background:linear-gradient(135deg,#FFB703,#FB8500);
    color:white;
}

.update-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(251,133,0,.4);
}

.add-details-btn{
    background:linear-gradient(135deg,#06D6A0,#1B9AAA);
    color:white;
}

.add-details-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(6,214,160,.45);
}

.update-details-btn{
    background:linear-gradient(135deg,#7B2CBF,#5A189A);
    color:white;
}

.update-details-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(123,44,191,.4);
}

.delete-btn{
    background:linear-gradient(135deg,#EF476F,#D90429);
    color:white;
}

.delete-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(217,4,41,.4);
}

.delete-btn:active{
    transform:scale(.96);
}

.remove-details-btn{
    background:linear-gradient(135deg,#E63946,#9D0208);
    color:white;
}

.remove-details-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(157,2,8,.45);
}

/* New Logout Button */
.logout-btn{
    background:linear-gradient(135deg,#4361EE,#3A0CA3);
    color:white;
}

.logout-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(67,97,238,.4);
}

/* New Delete Account Button */
.delete-account-btn{
    background:linear-gradient(135deg,#8B0000,#4B0000);
    color:white;
}

.delete-account-btn:hover{
    transform:translateY(-3px);
    box-shadow:0 8px 18px rgba(139,0,0,.45);
}

.btn:active{
    transform:scale(.96);
}

.no-items{
    text-align:center;
    padding:30px;
    font-size:18px;
    color:#777;
    font-weight:bold;
}

.account-actions{
    display:flex;
    justify-content:flex-end;
    margin-top:25px;
}
</style>

</head>
<body>

<%
String username = "Guest";

Cookie[] cookies = request.getCookies();

if(cookies != null){
    for(Cookie cookie : cookies){
        if("username".equals(cookie.getName())){
            username = cookie.getValue();
            break;
        }
    }
}
%>

<div class="container">

    <h2>Items List</h2>

    <div class="top-bar">

        <div class="welcome">
            Welcome, <%= username %>
        </div>

        <div class="actions">

            <a href="View/AddItem.html" class="btn add-btn">
                Add Item
            </a>

            <a href="/ItemsProject/UserController?action=logout"
               class="btn logout-btn">
                Logout
            </a>

        </div>

    </div>

    <table>

        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Total Number</th>
            <th>Actions</th>
        </tr>

        <%
        List<Item> items = (List<Item>) request.getAttribute("allItems");

        if(items == null || items.isEmpty()){
        %>

        <tr>
            <td colspan="5" class="no-items">
                No items found.
            </td>
        </tr>

        <%
        }else{
            for(Item item : items){
        %>

        <tr>
            <td><%= item.getId() %></td>
            <td><%= item.getName() %></td>
            <td><%= item.getPrice() %></td>
            <td><%= item.getTotalNumber() %></td>

            <td>

                <a href="/ItemsProject/ItemController?action=showItem&id=<%= item.getId() %>"
                   class="btn update-btn">
                    Update
                </a>
                
<% if(item.isHasDetails()) { %>

    <a href="/ItemsProject/ItemDetailsController?action=showDetails&id=<%= item.getId() %>"
       class="btn update-details-btn">
        Edit Details
    </a>

    <a href="/ItemsProject/ItemDetailsController?action=deleteDetails&id=<%= item.getId() %>"
       class="btn remove-details-btn"
       onclick="return confirm('Are you sure you want to remove this item''s details?');">
        Remove Details
    </a>

<% } else { %>

    <a href="View/AddDetails.jsp?id=<%= item.getId() %>"
       class="btn add-details-btn">
        Add Details
    </a>

<% } %>

                <a href="/ItemsProject/ItemController?action=deleteItem&id=<%= item.getId() %>"
                   class="btn delete-btn"
                   onclick="return confirm('Are you sure you want to delete this item?');">
                    Delete
                </a>

            </td>

        </tr>

        <%
            }
        }
        %>

    </table>

    <!-- Delete Account moved to bottom-right -->
    <div class="account-actions">

        <a href="/ItemsProject/UserController?action=deleteAccount"
           class="btn delete-account-btn"
           onclick="return confirm('Are you sure you want to delete your account?\n\nThis action cannot be undone.');">
            Delete My Account
        </a>

    </div>

</div>

</body>
</html>