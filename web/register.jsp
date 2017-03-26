<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String) session.getAttribute("error");
    ArrayList allProgram = (ArrayList) session.getAttribute("programList");
%>
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

            <% if (error != null) {
                if (error.equals("1")) {
                    out.print("first name error");
                } else if (error.equals("2")) {
                    out.print("last name error");
                } else if (error.equals("3")) {
                    out.print("password null");
                } else if (error.equals("4")) {
                    out.print("confirm error");
                }
            }
            %>
        </tr>

        <tr>
            <td>Last Name</td>
            <td><label><input type="text" name="lName"></label></td>

        </tr>

        <tr>
            <td>StudentLevel</td>
            <td><label><select studentLevel="studentLevel">
                <option value=1 selected>1</option>
                <option value=2>2</option>
                <option value=3>3</option>
                <option value=4>4</option>
                <option value=5>5</option>
                <option value=6>6</option>
            </select>
            </label></td>
        </tr>


        <tr>
            <td>Password</td>
            <td><label><input type="password" name="password"></label></td>
        </tr>

        <tr>
            <td>ConfirmPassword</td>
            <td><label><input type="password" name="confirmPassword"></label></td>
        </tr>


        <%--TODO: pwd validation--%>
    </table>
    <input type="submit" value="Register">
</form>
</body>
</html>
