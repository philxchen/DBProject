<%@ page import="dbbeans.DataAccess" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Date" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-26
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int jobId=Integer.parseInt(request.getParameter("jobId"));
    Connection connection= DataAccess.getConnection();
    String companyName="";
    String title="";
    String description="";
    int studentLevel=0;
    int numOfPos=0;
    int salary=0;
    Date startDate= null;
    Date endDate=null;
    try{
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM jobs where Job_ID='"+jobId+"'");
        if(rs.next()){
            companyName=rs.getString("Company_Name");
            title=rs.getString("Title");
            studentLevel=rs.getInt("Student_Level");
            numOfPos=rs.getInt("Number_Of_Positions");
            salary=rs.getInt("Salary");
            startDate=rs.getDate("Start_date");
            endDate=rs.getDate("End_date");
            description=rs.getString("Description");
        }
    }
    catch (Exception e){
        e.printStackTrace();

    }
%>
<html>
<head>
    <title>title  </title>
</head>
<body>
<a href="studentMain.jsp">Home</a>
<a href="job.jsp">Back</a>
<a href="jobReview.jsp">See Review</a>
<a href="logout.jsp">Logout</a>

<br/>
<% out.print(title);%>
<br/>
Description
<br/>
<% out.print(description);%>
<br/>
<br/>
Start Date is <% out.print(startDate); %>
<br/>
End Date is <% out.print(endDate); %>
<br/>
Company Name is <% out.print(companyName);%>
<br/>
Number of position is <% out.print(numOfPos); %>
<br/>
<a href="jobReview.jsp?jobId=<%=jobId%>">See Job Review</a>
<br/>
<a href="applySuccess.jsp?jobId=<%=jobId%>&numOfPos=<%=numOfPos %>">Apply</a>
<br/>
<a href="companyInfo.jsp?companyName=<%=companyName%>">Company Information</a>
</body>

</html>
