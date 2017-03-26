package controller;

import dbbeans.DataAccess;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String role = request.getParameter("roles");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        if (userId != null && !userId.equals("")) {
            Connection connection = DataAccess.getConnection();
            try {
                Statement st = connection.createStatement();
                ResultSet rs;
//                st.executeUpdate("INSERT INTO users "
//                        + " VALUES (" + userID + "," + email + "," + fname + "," + lname + "," + password + ")");
//                rs.close();
                switch (role) {
                    case "student":
                        rs = st.executeQuery("SELECT * FROM student s, users u " +
                                "WHERE s.user_id = '" + userId + "' " +
                                "AND u.user_id = s.user_id " +
                                "AND u.password = '" + password + "'");
                        if (rs.next()) {
                            session.setAttribute("userId", rs.getInt("User_ID"));
                            session.setAttribute("program", rs.getString("Program"));
                            session.setAttribute("level", rs.getString("Student_Level"));
                            response.sendRedirect("studentMain.jsp");
                        } else {
                            response.sendRedirect("invalidLogin.jsp");
                        }
                        break;
                    case "moderator":
                        rs = st.executeQuery("SELECT * FROM moderator m, users u " +
                                "WHERE m.user_id = '" + userId + "' " +
                                "AND u.user_id = m.user_id " +
                                "AND u.password = '" + password + "'");
                        if (rs.next()) {
                            session.setAttribute("userId", rs.getInt("User_ID"));
                            session.setAttribute("moderatorId", rs.getInt("Moderator_ID"));
                            response.sendRedirect("moderatorMain.jsp");
                        } else {
                            response.sendRedirect("invalidLogin.jsp");
                        }
                        break;
                    case "administrator":
                        rs = st.executeQuery("SELECT * FROM admin a, users u " +
                                "WHERE a.user_id = '" + userId + "' " +
                                "AND u.user_id = a.user_id " +
                                "AND u.password = '" + password + "'");
                        if (rs.next()) {
                            session.setAttribute("userId", rs.getInt("User_ID"));
                            session.setAttribute("adminId", rs.getInt("Admin_ID"));
                            response.sendRedirect("adminMain.jsp");
                        } else {
                            response.sendRedirect("invalidLogin.jsp");
                        }
                        break;
                }
                st.close();
            } catch (Exception e) {
                System.out.println("Cant insert into Users");
            }
        }
    }
}
