<%@ page import="dbbeans.CompanyBean" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="dbbeans.DataAccess" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-04-01
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String companyName=request.getParameter("companyName");

    double rating=(new CompanyBean()).getRating(companyName);
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
<a href="rateCompany.jsp">Back</a>
<br/> <% out.print(companyName);%>
<br/>Company rating is <% out.print(rating); %>
<br/>Number of employee is <% out.print(numOfEmployee);%>
<br/>Location is <% out.print(location);%>
<br/>Website is <a href="http://<%=website%>"><%=website%></a>
<br/>
<form method="post" action="RateCompanyServlet">
<table>
    <tr>
        <td>Rate Company</td>
        <td><label><select name="rateCompany">
            <option value=0 selected>0</option>
            <option value=1>1</option>
            <option value=2>2</option>
            <option value=3>3</option>
            <option value=4>4</option>
            <option value=5>5</option>
        </select>
        </label></td>
    </tr>
    <input type="hidden" name="companyName" value=<%=companyName.replace(' ','+')%>>
</table>
    <input type="submit" value="Rate">
</form>
</body>
</html>
