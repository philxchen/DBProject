<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="resume" class="dbbeans.ResumeBean"/>
<jsp:useBean id="resumeReview" class="dbbeans.ResumeReviewBean"/>
<jsp:useBean id="resumeReviewRequest" class="dbbeans.ResumeReviewRequestBean"/>
<html>
<head>
    <title>View Resume</title>
</head>
<body>
<jsp:include page="studentHeader.jsp"/>
<c:set var="userId" value="${sessionScope.userId}"/>
<c:set var="userName" value="${sessionScope.userName}"/>
<c:set var="version" value="${requestScope}"/>
<c:set var="maxVersion" value="${sessionScope.maxVersion}"/>
<c:if test="${version le maxVersion}">
    <p>This version of resume does not exist.</p>
    <h1>
        Resume of
        <c:out value="${userName}, version ${version}"/>
    </h1>
    <c:out value="${resume.retrieveResumeContent(userId, version)}"/>
    <br>
    <h2>Comment</h2>
    <p>
        <c:set var="comment" value="${resumeReview.retrieveResumeReviewComment(userId, version)}"/>
        <c:if test="comment == null || comment.equals(\"\")">
            <p>This resume received no comment.</p>
            <c:choose>
                <c:when test="${resumeReviewRequest.hasResumeReviewRequest(userId, version)}">
                    <p>You have requested a review.</p>
                    <a href="viewResume.jsp?version=${version}>"
                       onclick="<%resumeReviewRequest.revokeResumeReviewRequest((Integer) session.getAttribute("userId"), Integer.parseInt(request.getParameter("version")));%>">
                        Revoke
                    </a>
                </c:when>
                <c:otherwise>
                    <a href="viewResume.jsp?version=${version}>"
                       onclick="<%resumeReviewRequest.insertResumeReviewRequest((Integer) session.getAttribute("userId"), Integer.parseInt(request.getParameter("version")));%>">
                        Send a new review request
                    </a>
                </c:otherwise>
            </c:choose>
        </c:if>
        <c:out value="${comment}"/>
    </p>
</c:if>

</body>
</html>
