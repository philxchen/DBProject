<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Resume</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<h1>
    <%
        out.print(session.getAttribute("userName"));
    %>
</h1>
</body>
</html>
