package controller;

import dbbeans.ResumeReviewRequestBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * parameters:
 * actionType:
 * 1 - revoke
 * 2 - insert
 */
@WebServlet(name = "InsertOrRemoveResumeReviewRequestServlet")
public class InsertOrRemoveResumeReviewRequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (Integer) session.getAttribute("userId");
        int version = Integer.parseInt(request.getParameter("version"));
        switch (request.getParameter("actionType")) {
            case "1":
                (new ResumeReviewRequestBean()).revokeResumeReviewRequest(userId, version);
                break;
            case "2":
                (new ResumeReviewRequestBean()).insertResumeReviewRequest(userId, version);
        }
        response.sendRedirect("viewResume.jsp?version=" + version);
    }
}
