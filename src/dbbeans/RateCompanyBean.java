package dbbeans;

import java.sql.*;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class RateCompanyBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public void insertRateCompany(int userID,String companyName, int mark )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Rate_Company "
                    + " VALUES ("+userID+",'"+ companyName+"',"+mark + ")");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Rate_Company");
            e.printStackTrace();
        }
    }

}