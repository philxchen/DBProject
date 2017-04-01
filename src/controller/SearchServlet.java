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
import java.util.ArrayList;

@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = DataAccess.getConnection();
        HttpSession session = request.getSession();
        String keywords = request.getParameter("keywords");
        ArrayList<String[]> results = new ArrayList<>();
        String[] result = new String[6];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT S.User_ID, Program, Student_Level, Email, Fname, Lname " +
                    "FROM Student S, Users U " +
                    "WHERE S.User_ID = U.User_ID AND " +
                    "(S.User_ID :: TEXT LIKE '%" + keywords + "%' OR " +
                    "Program LIKE '%" + keywords + "%' OR " +
                    "Student_Level :: TEXT LIKE '%" + keywords + "%' OR " +
                    "Email LIKE '%" + keywords + "%' OR " +
                    "concat(Fname, ' ', Lname) LIKE '%" + keywords + "%');");

            while (rs.next()) {
                for (int i = 0; i < 6; i++) {
                    result[i] = rs.getString(i + 1);
                }
                results.add(result);
            }
            session.setAttribute("results", results);
            response.sendRedirect("searchResults.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
