<%--
  Created by IntelliJ IDEA.
  User: philxchen
  Date: 3/25/17
  Time: 9:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<h2>Welcome, <%=session.getAttribute("userName")%></h2>
</body>
</html>
