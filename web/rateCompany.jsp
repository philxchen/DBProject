<%@ page import="dbbeans.CompanyBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-29
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    switch ((String) session.getAttribute("role")) {
        case "moderator":
%>
<jsp:include page="moderatorHeader.jsp"/>
<%
        break;
    case "student":
%>
<jsp:include page="studentHeader.jsp"/>
<%
        break;
    case "administrator":
%>
<jsp:include page="adminHeader.jsp"/>
<%
            break;
    }
%>
<html>
<head>
    <title>Rate company</title>
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
