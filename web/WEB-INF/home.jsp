<%-- 
    Document   : home
    Created on : 6-Oct-2022, 11:38:43 AM
    Author     : puppi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Home Page</title>
    </head>
    <body>
        <h2>Home Page</h2>
        <h4>Hello ${user.username}</h4>
        <a href="login?logout">Log out</a>
    </body>
</html>
