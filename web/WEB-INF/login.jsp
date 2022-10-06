<%-- 
    Document   : login
    Created on : 4-Oct-2022, 8:49:05 AM
    Author     : puppi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
          <form action="login" method="post">
            Username: <input type="text" name="username"><br>
            Password: <input type="text" name="password"><br>
            <input type="submit" value="submit">
        </form>
        
          <c:if test="${invalid == true}">
              <p>Invalid entry. try again lil bro...</p>
          </c:if>
    </body>
</html>
