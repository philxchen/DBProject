<%@ page import="dbbeans.DataAccess" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-04-01
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int jobId=Integer.parseInt(request.getParameter("jobId"));
    Connection connection= DataAccess.getConnection();
    String companyName="";
    try{
        Statement st=connection.createStatement();
        ResultSet rs=st.executeQuery("SELECT company_name FROM Jobs WHERE Job_ID="+jobId);
        if (rs.next()){
            companyName=rs.getString("company_name");

        }

    }catch (Exception e){
        e.printStackTrace();
    }
    %>
<html>
<head>
    <title>Make review</title>
</head>
<body>
<a href="review.jsp">Back</a>
<h1>Create a review</h1>
<h2>Company Name : <%
    out.println(companyName);
%></h2>
<form method="post" action="CreateReviewServlet">
    <table>
        <tr>
            <td>Title</td>
            <td><textarea name="title" rows="1" cols="20"></textarea></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><textarea name="description" rows="10" cols="80"></textarea></td>
        </tr>
        <input type="hidden" name="companyName" value=<%=companyName.replace(' ','+')%>>
    </table>
    <br>
    <input type="submit" value="Create">
</form>
</body>
</html>
