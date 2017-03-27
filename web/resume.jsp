<%@ page import="dbbeans.ResumeBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Resume - <% out.print(session.getAttribute("userName")); %></title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<%
    int maxVersion = (new ResumeBean()).retrieveMaxVersionNumber((Integer) session.getAttribute("userId"));
    session.setAttribute("maxVersion", maxVersion);
    if (maxVersion <= 0) {
%>
You currently have no resume.
<% } else { %>
Select a version of Resume:
<form method="post" action="viewResume.jsp">
    <select name="version">
        <c:forEach begin="1" end="${maxVersion}" varStatus="loop">
            <option value="${loop.index}">${loop.index}</option>
        </c:forEach>
    </select>
    <input type="submit" value="View">
</form>
<% } %>
<br>
<a href="createResume.jsp">Create a new one</a>
</body>
</html>
