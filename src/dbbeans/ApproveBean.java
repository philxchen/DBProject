package dbbeans;

import java.sql.*;

/**
 * Created by philxchen on 3/25/17.
 */

public class ApproveBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public void insertApprove(int adminID,int jobID)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO approve "
                    + " VALUES ("+adminID+","+ jobID+ ")");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Approve");
            e.printStackTrace();
        }
    }

}