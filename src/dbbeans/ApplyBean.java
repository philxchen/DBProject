package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class ApplyBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;




    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertApply(int userID,int jobID, DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO apply "
                    + " VALUES ("+userID+","+ jobID+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Apply");
        }
    }




}



