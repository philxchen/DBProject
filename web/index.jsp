<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login to the Co-op system</h1>
<p>Please select your role:</p>
<form method="post" action="LoginServlet">
    <input type="radio" name="roles" value="student" checked>
    Student
    <br>
    <input type="radio" name="roles" value="moderator">
    Moderator
    <br>
    <input type="radio" name="roles" value="administrator">
    Administrator
    <br>
    <table>
        <tr>
            <td>User ID</td>
            <td><label><input type="text" name="userId"></label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label><input type="password" name="password"></label></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Submit">
</form>
<br>
You're a student but not yet registered? Click <a href="register.jsp">here</a> to register
<br>
<a href="forgotUserId.jsp">Forgot your User ID?</a>
</body>
</html>
