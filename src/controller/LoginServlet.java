package controller;

import dbbeans.DataAccess;
import dbbeans.UsersBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String role = request.getParameter("roles");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

//      TODO: finish the cookie
//      check cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                switch (cookie.getName()) {
                    case "userId":
                        userId = cookie.getValue();
                        break;
                    case "role":
                        role = cookie.getValue();
                        break;
                }
            }
        }

        Cookie roleCookie = null;

        HttpSession session = request.getSession();
        if (userId != null && !userId.equals("")) {
            Connection connection = DataAccess.getConnection();
            try {
                Statement st = connection.createStatement();
                ResultSet rs;
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
                            roleCookie = new Cookie("role", "student");
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
                            roleCookie = new Cookie("role", "moderator");
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
                            roleCookie = new Cookie("role", "admin");
                            response.sendRedirect("adminMain.jsp");
                        } else {
                            response.sendRedirect("invalidLogin.jsp");
                        }
                        break;
                }
                session.setAttribute("role", role);

//              get user's name
                if (session.getAttribute("userId") != null) {
                    session.setAttribute("userName",
                            (new UsersBean()).getUserName((Integer) session.getAttribute("userId")));
                }

//              send cookie to client if a role cookie was sent
                if (roleCookie != null) {
                    Cookie userIdCookie = new Cookie("userId", String.valueOf(userId));
                    userIdCookie.setMaxAge(900); //900s
                    response.addCookie(roleCookie);
                    response.addCookie(userIdCookie);
                }

                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
