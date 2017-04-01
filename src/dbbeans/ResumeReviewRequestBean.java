package dbbeans;

import java.sql.*;

/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ResumeReviewRequestBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public void insertResumeReviewRequest(int userId, int versionNum) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO ResumeReviewRequest "
                    + " VALUES (" + userId + "," + versionNum + ")");

            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean hasResumeReviewRequest(int userId, int version) {
        boolean result = false;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * " +
                    "FROM resumereviewrequest " +
                    "WHERE user_id = " + userId + " AND version_number = " + version);
            result = rs.next();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean revokeResumeReviewRequest(int userId, int version) {
        boolean result = false;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("DELETE " +
                    "FROM resumereviewrequest " +
                    "WHERE user_id = " + userId + " AND version_number = " + version);
            result = true;
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String retrieveResumeReviewRequests() {
        StringBuilder result = new StringBuilder();
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT user_id, version_number " +
                    "FROM resumereviewrequest");
            while (rs.next()) {
                result.append("<tr><td>");
                result.append(rs.getInt(1));
                result.append("</td><td>");
                result.append(rs.getInt(2));
                result.append("</td><td>");
                result.append("<a href=\"reviewResume.jsp?userId=");
                result.append(rs.getInt(1));
                result.append("&version=");
                result.append(rs.getInt(2));
                result.append("\">Review</a></td></tr>");
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

}