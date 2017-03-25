<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login to the Co-op system</h1>
<p>Please select your role</p>
<form method="post" action="loginForm.jsp">
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
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"><br></td>
        </tr>
    </table>
    <input type="submit" value="Submit">
    Not yet registered? click <a href="register.jsp">here</a> to register
</form>
</body>
</html>
