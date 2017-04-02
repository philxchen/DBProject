<%@ page import="dbbeans.DoesBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-04-01
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userId = (Integer) session.getAttribute("userId");
%>
<html>
<head>
    <title>Create a review</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<table style="width:100%">
    <th>The jobs you have done</th>
    <%
        out.print((new DoesBean()).getDoesJobList(userId));
    %>
</table>
</body>
</html>
