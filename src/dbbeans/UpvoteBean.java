package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class UpvoteBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertUpvote(int userID,int reviewId , DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Upvote "
                    + " VALUES ("+userID+","+ reviewId+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Upvote");
        }
    }

}


