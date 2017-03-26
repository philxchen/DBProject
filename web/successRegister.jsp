<%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-26
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successfully Registered</title>
</head>
<body>
Your UserID is <%= session.getAttribute("userID")
%>
<br/>
Click <a href="index.jsp">here</a> to login

</body>
</html>
