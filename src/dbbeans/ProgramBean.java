package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ProgramBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;





    public void insertProgram(String programName,String field )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO program "
                    + " VALUES ("+ programName+","+ field+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into program");
        }
    }




}


