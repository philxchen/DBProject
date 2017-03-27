package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class ModeratorBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String getStudentList="";





    public void insertModerator(int userID)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Moderator "
                    + " VALUES ("+userID+",Default )");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Moderator");
            e.printStackTrace();
        }
    }

}



