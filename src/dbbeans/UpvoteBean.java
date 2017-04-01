package dbbeans;

import java.sql.*;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class UpvoteBean {
    private Connection connection;
    private Statement st;

    public void insertUpvote(int userID,int reviewId )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Upvote "
                    + " VALUES ("+userID+","+ reviewId+ ")");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Upvote");
            e.printStackTrace();
        }
    }


}