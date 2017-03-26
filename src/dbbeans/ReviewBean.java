package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ReviewBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;





    public void insertReview(int userID,int reviewId, String companyName,Date date,String title, String body )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Review "
                    + " VALUES ("+userID+","+ reviewId+",'"+companyName+"','"+date +"','"+title+"','"+body+"',"+0+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Review");
            e.printStackTrace();
        }
    }

}


