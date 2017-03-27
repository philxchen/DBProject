<%@ page import="dbbeans.ApplyBean" %><%--
  Created by IntelliJ IDEA.
  User: michaelhuang
  Date: 2017-03-26
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int jobId=Integer.parseInt(request.getParameter("jobId"));
int numOfPos=Integer.parseInt(request.getParameter("numOfPos"));
int userId=(Integer) session.getAttribute("userId");
boolean exist=(new ApplyBean()).existsApply(userId,jobId);
if(exist){
    out.print("You have already applied this job");
}else if(numOfPos==0){
    out.print("The position is not avaliable anymore");
}
else {
    (new ApplyBean()).insertApply(userId, jobId);
}
%>
<html>
<head>
    <title>Title</title>
</head>
<a href="job.jsp">job page</a>
</body>
</html>
