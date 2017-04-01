package dbbeans;

import java.sql.*;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class ResumeBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public void insertResume(int userID, int versionNum, String education, String skill, String workExp) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Resume VALUES ("
                    + userID + ", "
                    + versionNum + ", '"
                    + education + "', '"
                    + skill + "', '"
                    + workExp + "')");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cant insert into Resume");
        }
    }

    public int retrieveMaxVersionNumber(int userId) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT MAX(version_number) " +
                    "FROM resume " +
                    "WHERE User_ID = " + userId);
            if (rs.next()) {
                return rs.getInt(1);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String retrieveResumeContent(int userId, int version) {
        connection = DataAccess.getConnection();
        String resultHtml = "";
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT education, skill, work_experience " +
                    "FROM resume " +
                    "WHERE user_id = " + userId + " AND version_number = " + version);
            if (rs.next()) {
                resultHtml = "<table><tr><td>Education: </td><td>" +
                        rs.getString("education") +
                        "</td></tr><tr><td>Skills: </td><td>" +
                        rs.getString("skill") +
                        "</td></tr><tr><td>Work experience: </td><td>" +
                        rs.getString("work_experience") +
                        "</td></tr></table>";
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultHtml;
    }
}