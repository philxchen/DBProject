<%@ page import="dbbeans.JobsBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Job Search</title>
</head>
<body>
<a href="studentMain.jsp">Home</a>
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
    </tr>
    <tr><%
        out.print((new JobsBean()).getAllInformation());
    %>
    </tr>
</table>

</body>
</html>
