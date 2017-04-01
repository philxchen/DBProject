package controller;

import dbbeans.ResumeReviewBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by philxchen on 4/1/17.
 */
@WebServlet(name = "CreateResumeReviewServlet")
public class CreateResumeReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        (new ResumeReviewBean()).insertResumeReview(
                (Integer) session.getAttribute("moderatorId"),
                Integer.parseInt(request.getParameter("userId")),
                Integer.parseInt(request.getParameter("version")),
                request.getParameter("comment"));
        response.sendRedirect("resumeReviewRequests.jsp");
    }
}
