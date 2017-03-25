package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class RateCompanyBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertRateCompany(int userID,String companyName, int mark , DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Rate_Company "
                    + " VALUES ("+userID+","+ companyName+","+mark + ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Rate_Company");
        }
    }

}


