package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class DoesBean {
    private Connection connection;
    private Statement st;






    public void insertDoes(int userID,int jobID )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Does "
                    + " VALUES ("+userID+","+ jobID+ ")");
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Does");
            e.printStackTrace();
        }
    }




}



