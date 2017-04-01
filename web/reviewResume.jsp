<%@ page import="dbbeans.ResumeBean" %>
<%@ page import="dbbeans.UsersBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review a resume</title>
</head>
<%
    int userId = Integer.parseInt(request.getParameter("userId"));
%>
<body>
<jsp:include page="moderatorHeader.jsp"/>
<h2>User Info</h2>
<ul>
    <li>ID: <%=userId%></li>
    <li>Name: <%=(new UsersBean()).getUserName(userId)%></li>
</ul>
<h2>Resume</h2>
<%=(new ResumeBean()).retrieveResumeContent(userId, Integer.parseInt(request.getParameter("version"))) %>
<h2>Add comment</h2>
<form action="CreateResumeReviewServlet?userId=<%=userId%>&version=<%=request.getParameter("version")%>" method="post">
    <textarea name="comment" rows="10" cols="80"></textarea>
    <input type="submit" value="Add">
</form>
</body>
</html>
