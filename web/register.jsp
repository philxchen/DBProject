<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Register</title>
</head>
<body>
<h1>Register</h1>
<form method="post" action="RegisterServlet">
    <table>
        <tr>
            <td>Email</td>
            <td><label><input type="email" name="email"></label></td>
        </tr>
        <tr>
            <td>First Name</td>
            <td><label><input type="text" name="fName"></label></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><label><input type="text" name="lName"></label></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label><input type="password" name="password"></label></td>
        </tr>
    <%--TODO: pwd validation--%>
    </table>
    <input type="submit" value="Register">
</form>
</body>
</html>
