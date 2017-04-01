package dbbeans;

import java.sql.*;

/**
 * Created by philxchen on 3/25/17.
 */

public class JobForProgramBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public void insertJobForProgram(String programName,int jobID)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Job_for_program "
                    + " VALUES ('"+programName+"',"+ jobID+ ")");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Job_for_program");
            e.printStackTrace();
        }
    }

}