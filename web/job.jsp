<%@ page import="dbbeans.JobsBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Job Search</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<p>
    Order by
<ul>
    <li><a href="job.jsp?orderBy=student_Level">Student Level</a></li>
    <li><a href="job.jsp?orderBy=Number_Of_Positions">Number of Positions</a></li>
    <li><a href="job.jsp?orderBy=Salary">Salary</a></li>
</ul>
</p>
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
        String orderBy = request.getParameter("orderBy");
        JobsBean jobsBean = new JobsBean();
        int userId = (Integer) session.getAttribute("userId");
        out.print(jobsBean.getAllInformation(
                userId,
                orderBy));
    %>
    </tr>
</table>

</body>
</html>
