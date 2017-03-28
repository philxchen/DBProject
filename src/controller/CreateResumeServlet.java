package controller;

import dbbeans.DataAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by philxchen on 3/26/17.
 */

@WebServlet(name = "CreateResumeServlet")

public class CreateResumeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String education = request.getParameter("education");
        String skill = request.getParameter("skill");
        String workExp = request.getParameter("workExp");

        HttpSession session = request.getSession();
        Connection connection = DataAccess.getConnection();
        try {
            Statement st = connection.createStatement();
            int newMaxVersion = ((Integer) session.getAttribute("maxVersion") + 1);
            st.executeUpdate("INSERT INTO resume VALUES ("
                    + session.getAttribute("userId")
                    + ", " + newMaxVersion
                    + ", '" + education
                    + "', '" + skill
                    + "', '" + workExp
                    + "')");
            st.close();

            response.sendRedirect("resume.jsp");
            session.setAttribute("maxVersion", newMaxVersion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
