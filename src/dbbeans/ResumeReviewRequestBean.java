package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ResumeReviewRequestBean {
    private Connection connection;
    private Statement st;






    public void insertResumeReviewRequest(int userID,int versionNum)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO ResumeReviewRequest "
                    + " VALUES ("+userID+","+ versionNum + ")");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into ResumeReviewRequest");
            e.printStackTrace();
        }
    }

}


