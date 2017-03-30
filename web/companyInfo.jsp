<%@ page import="dbbeans.CompanyBean" %>
<%@ page import="dbbeans.JobsBean" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dbbeans.DataAccess" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="dbbeans.ReviewBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-26
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String companyName=request.getParameter("companyName");
double rating=(new CompanyBean()).getRating(companyName);
int jobId=Integer.parseInt(request.getParameter("jobId"));
    Connection connection= DataAccess.getConnection();
    String location="";
    String website="";
    int numOfEmployee=0;

    try {
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM company where Company_Name='" + companyName + "'");
        if (rs.next()) {
            location = rs.getString("Location");
            website = rs.getString("Website");
            numOfEmployee = rs.getInt("Number_Of_Employees");
        }
    }
        catch(Exception e){
        e.printStackTrace();
        }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="studentMain.jsp">Home</a>
<a href="viewJob.jsp?jobId=<%=jobId%>">Back</a>
<br/> <% out.print(companyName);%>
<br/>Company rating is <% out.print(rating); %>
<br/>Number of employee is <% out.print(numOfEmployee);%>
<br/>Location is <% out.print(location);%>
<br/>Website is <% out.print(website);%>
<table style="width:100%">
    <tr>
        <th>Job_ID</th>
        <th>Title</th>
        <th>Level</th>
        <th>Positions</th>
        <th>Salary</th>
        <th>Start_Date</th>
        <th>End_Date</th>
    </tr>
    <tr><%
        out.print((new JobsBean()).getJobsInCompany(companyName));
    %>
    </tr>
</table>
<br/>
<br/>The reviews for this company
<table style="width:100%">
    <tr>
        <th>Title</th>
        <th>Date</th>
        <th>Description</th>
        <th>VoteCount</th>
        <th>Upvote</th>

    </tr>
    <tr><%
        out.print((new ReviewBean()).getReviewInfoBaseOnCompany(companyName));
    %>
    </tr>
</table>

</body>
</html>
