package controller;

import dbbeans.DataAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by philxchen on 4/1/17.
 */
@WebServlet(name = "ForgotUserIdServlet")
public class ForgotUserIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "Email not found. <a href=\"register.jsp\">Register</a>";
        Connection connection = DataAccess.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT user_id FROM users WHERE email='" + request.getParameter("email") + "'");
            if (rs.next()) {
                result = "Your User ID is " + rs.getString(1) + ". <a href=\"index.jsp\">Back</a>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("recoverUserId.jsp").forward(request, response);

    }
}
