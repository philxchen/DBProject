<%@ page import="dbbeans.JobPendingBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-29
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pending Job List</title>
</head>
<body>
<a href="adminMain.jsp">Back</a>
<br/>
<table style="width:100%">
    <tr>
        <th>Job_ID</th>
        <th>Title</th>
        <th>Company</th>
        <th>Level</th>
        <th>Positions</th>
        <th>Salary</th>
        <th>Start_Date</th>
        <th>End_Date</th>
        <th>Description</th>
        <th>Approve</th>
    </tr>
    <tr><%
        out.print((new JobPendingBean()).getAllInformation());
    %>
    </tr>
</table>
</body>
</html>
