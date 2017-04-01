<%@ page import="java.sql.Connection" %>
<%@ page import="dbbeans.DataAccess" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="dbbeans.JobsBean" %>
<%@ page import="dbbeans.ApproveBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-29
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int adminId=(Integer)session.getAttribute("adminId");
    int jobId=Integer.parseInt(request.getParameter("jobId"));
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
        ResultSet rs=st.executeQuery("SELECT * FROM jobPending where Job_ID='"+jobId+"'");
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
<%
    (new JobsBean()).insertJobs(jobId,companyName,title,description,studentLevel,numOfPos,salary,startDate,endDate);
    (new ApproveBean()).insertApprove(adminId,jobId);
%>
<html>
<head>
    <title>Approve</title>
</head>
<body>
<a href="jobPending.jsp">Back</a>
Approve success
</body>
</html>
