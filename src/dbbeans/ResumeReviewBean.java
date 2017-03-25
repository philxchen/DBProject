package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ResumeReviewBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertJobs(int moderatorId,int userID,int versionNum, String text , DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO ResumeReview "
                    + " VALUES ("+ moderatorId+","+userID+","+ versionNum+","+text + ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into ResumeReview");
        }
    }

}


