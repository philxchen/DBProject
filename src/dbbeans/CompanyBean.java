package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class CompanyBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;




    public void insertCompany(String companyName,int numOfEmployee,String location,String website)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO company "
                    + " VALUES ("+companyName +","+ numOfEmployee+","+location+","+website+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Company");
        }
    }

}



