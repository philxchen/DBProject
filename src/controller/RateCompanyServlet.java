package controller;

import dbbeans.RateCompanyBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by michaelhuang on 2017-04-01.
 */
@WebServlet(name = "RateCompanyServlet")
public class RateCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyName = request.getParameter("companyName");
        int mark = Integer.parseInt(request.getParameter("rateCompany"));
        companyName = companyName.replace('+', ' ');
        HttpSession session = request.getSession();
        try {
            int userId = (Integer) session.getAttribute("userId");
            (new RateCompanyBean()).insertRateCompany(userId, companyName, mark);
            response.sendRedirect("rateCompany.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
