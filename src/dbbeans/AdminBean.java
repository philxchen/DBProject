package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class AdminBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;






    public void insertAdmin(int userID)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Admin "
                    + " VALUES ("+userID+", Default )");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Admin");
        }
    }




}



