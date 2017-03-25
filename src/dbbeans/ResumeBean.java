package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ResumeBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertResume(int userID,int version_num, int mark , DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Jobs "
                    + " VALUES ("+userID+","+ companyName+","+mark + ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Jobs");
        }
    }

}


