<%@ page import="dbbeans.CompanyBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-29
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="studentMain.jsp">Home</a>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:100%">
    <tr>
        <th>Company Name</th>
    </tr>
    <tr><%
        out.print((new CompanyBean()).getAllCompanyList());
    %>
    </tr>
</table>

</body>
</html>
