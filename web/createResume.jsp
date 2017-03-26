<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Resume</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<h1>Create a resume</h1>
<form method="post" action="CreateResumeServlet">
    <table>
        <tr>
            <td>Education</td>
            <td><textarea name="education" rows="10" cols="80"></textarea></td>
        </tr>
        <tr>
            <td>Skills</td>
            <td><textarea name="skill" rows="10" cols="80"></textarea></td>
        </tr>
        <tr>
            <td>Work experience</td>
            <td><textarea name="workExp" rows="10" cols="80"></textarea></td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Create">
</form>
<a href="resume.jsp"><button>Cancel</button></a>
</body>
</html>
