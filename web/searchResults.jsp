<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
<%
    switch ((String) session.getAttribute("role")) {
        case "moderator":
%>
<jsp:include page="moderatorHeader.jsp"/>
<%
            break;
        case "administrator":
%>
<jsp:include page="adminHeader.jsp"/>
<%
            break;
    }
%>
<table>
    <th>User ID</th>
    <th>Program</th>
    <th>Level</th>
    <th>Email</th>
    <th>First name</th>
    <th>Last name</th>
    <%

        ArrayList<String[]> results = (ArrayList<String[]>) session.getAttribute("results");
        if (results != null) {
            for (String[] result : results) {
                out.print("<tr>");
                for (String s : result) {
                    out.print("<td>" + s + "</td>");
                }
                out.print("</tr>");
            }
        }

    %>
</table>
</body>
</html>
