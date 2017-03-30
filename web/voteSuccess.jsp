<%@ page import="dbbeans.UpvoteBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-27
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int reviewId=Integer.parseInt(request.getParameter("reviewId"));
    int userId=(Integer)session.getAttribute("userId");
    (new UpvoteBean()).insertUpvote(userId,reviewId);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Vote Success
<br/>
<a href="job.jsp">Back</a>
<br/>

</body>
</html>
