package dbbeans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class ResumeReviewBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public void insertResumeReview(int moderatorId, int userId, int versionNum, String text) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO ResumeReview "
                    + " VALUES (" + moderatorId + "," + userId + "," + versionNum + ",'" + text + "')");
            st.close();
        } catch (Exception e) {
            System.out.println("Cant insert into ResumeReview");
            e.printStackTrace();
        }
    }

    public String retrieveResumeReviewComment(int userId, int version) {
        String comment = "";
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT comment " +
                    "FROM resumereview " +
                    "WHERE user_id = " + userId + " AND version_number = " + version);
            if (rs.next()) {
                comment = rs.getString(1);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

}