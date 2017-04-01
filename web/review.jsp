<%@ page import="dbbeans.DoesBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-04-01
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userId=(Integer)session.getAttribute("userId");
%>
<a href="studentMain.jsp">Home</a>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%">
    <tr>
        <th>The jobs you have did</th>
    </tr>
    <tr><%
        out.print((new DoesBean()).getDoesJobList(userId));
    %>
    </tr>
</table>
</body>
</html>
