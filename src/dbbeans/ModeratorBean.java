package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class ModeratorBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;
    private String getStudentList="";



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertModerator(int userID, DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Moderator "
                    + " VALUES ("+userID+",Default )");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Users");
        }
    }




}



