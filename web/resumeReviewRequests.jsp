<%@ page import="dbbeans.ResumeReviewRequestBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review a resume</title>
</head>
<body>
<jsp:include page="moderatorHeader.jsp"/>
<h1>Pending review requests</h1>
<table>
    <%=(new ResumeReviewRequestBean()).retrieveResumeReviewRequests()%>
</table>
</body>
</html>
