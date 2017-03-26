<%--
  header in student pages
--%>
<%@ page import="dbbeans.UsersBean" %>
<div>
    <a href="studentMain.jsp">Home</a>
    <a href="resume.jsp">Resume</a>
    <a href="job.jsp">Jobs</a>
    <a href="logout.jsp">Logout</a>

    <h2>Welcome,
    <%
        out.print((new UsersBean()).getUserName((Integer) session.getAttribute("userId")));
    %>
    </h2>
</div>
