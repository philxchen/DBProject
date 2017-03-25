package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class JobForProgramBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;




    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertJobForProgram(String programName,int jobID, DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Job_for_program "
                    + " VALUES ("+programName+","+ jobID+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Job_for_program");
        }
    }




}



