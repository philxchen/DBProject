<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<jsp:include page="moderatorHeader.jsp"/>
<h2>Welcome, <%=session.getAttribute("userName")%></h2>
</body>
</html>
