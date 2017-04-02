<%--
  Created by IntelliJ IDEA.
  User: philxchen
  Date: 4/1/17
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot ID</title>
</head>
<body>
<h1>Recover your User ID</h1>
<form method="post" action="ForgotUserIdServlet">
    E-mail: <input type="email" name="email" placeholder="user@example.com">
    <input type="submit" value="Submit">
</form>
</body>
</html>
