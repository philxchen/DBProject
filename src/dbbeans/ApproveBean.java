package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class ApproveBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;




    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertApprove(int adminID,int jobID, DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO approve "
                    + " VALUES ("+adminID+","+ jobID+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Approve");
        }
    }




}



