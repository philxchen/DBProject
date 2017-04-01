package controller;

import dbbeans.DataAccess;
import dbbeans.ReviewBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;


/**
 * Created by michaelhuang on 2017-04-01.
 */
@WebServlet(name = "CreateReviewServlet")
public class CreateReviewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String description=request.getParameter("description");
        Calendar currenttime = Calendar.getInstance();
        Date currentDate = new Date((currenttime.getTime()).getTime());
        HttpSession session = request.getSession();
        String companyName=request.getParameter("companyName");
        companyName=companyName.replace('+',' ');
        try{
            int userId=(Integer) session.getAttribute("userId");
            (new ReviewBean()).insertReview(userId,companyName,currentDate,title,description);
            response.sendRedirect("review.jsp");


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
