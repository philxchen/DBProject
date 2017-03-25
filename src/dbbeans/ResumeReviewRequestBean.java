package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ResumeReviewRequestBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertResumeReviewRequest(int userID,int versionNum , DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO ResumeReviewRequest "
                    + " VALUES ("+userID+","+ versionNum + ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into ResumeReviewRequest");
        }
    }

}


