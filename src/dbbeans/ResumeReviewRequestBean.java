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
            System.out.println("Cant insert into ResumeReviewRequest");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}


