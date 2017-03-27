<%@ page import="dbbeans.ResumeBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Resume</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<h1>
    Resume of
    <% out.print(session.getAttribute("userName") + ", version " + request.getParameter("version")); %>
    <% out.print((new ResumeBean()).retrieveResumeContent(
            (Integer) session.getAttribute("userId"),
            Integer.parseInt(request.getParameter("version"))
    )); %>
</h1>
</body>
</html>
