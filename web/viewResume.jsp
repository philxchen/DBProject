<%@ page import="dbbeans.ResumeBean" %>
<%@ page import="dbbeans.ResumeReviewBean" %>
<%@ page import="dbbeans.ResumeReviewRequestBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Resume</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<%
    int userId = (Integer) session.getAttribute("userId");
    String userName = (String) session.getAttribute("userName");
    int version = Integer.parseInt(request.getParameter("version"));
%>
<h1>
    Resume of
    <%=(userName + ", version " + version) %>
</h1>
<%=(new ResumeBean()).retrieveResumeContent(userId, version) %>
<br>
<h2>Comment</h2>
<p>
    <%
        String comment = (new ResumeReviewBean()).retrieveResumeReviewComment(userId, version);
        if (comment == null || comment.equals("")) {
    %>
    This resume received no comment.
    <a href="<%(new ResumeReviewRequestBean()).insertResumeReviewRequest(userId, version); %>">
        Send a new review request
    </a>.
    <% } else {
        out.print(comment);
    } %>
</p>
</body>
</html>
