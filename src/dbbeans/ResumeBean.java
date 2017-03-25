package dbbeans;

import java.sql.*;

/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ResumeBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;


    public void setDataAccess(DataAccess db) {
        dataaccess = db;
    }


    public void insertResume(int userID, int versionNum, String education, String skill, String workExp, DataAccess db) {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Resume "
                    + " VALUES (" + userID + "," + versionNum + "," + education + "," + skill + ", " + workExp + ")");
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Cant insert into Resume");
        }
    }

}


