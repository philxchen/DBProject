package dbbeans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by philxchen on 3/25/17.
 */

public class CompanyBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String getCompanyList = "";
    private ArrayList<String> companyListBasedOnLocation=new ArrayList<>();

    public void insertCompany(String companyName, int numOfEmployee, String location, String website) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO company "
                    + " VALUES ('" + companyName + "'," + numOfEmployee + ",'" + location + "','" + website + "')");
            st.close();
        } catch (Exception e) {
            System.out.println("Cant insert into Company");
            e.printStackTrace();
        }
    }

    public String getCompanyList(){
        connection = DataAccess.getConnection();
        String companyName;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM company GROUP BY companyName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                companyName = rs.getString("companyName");
                getCompanyList += "<tr><tr><td>"
                        + companyName
                        + "</td><td>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCompanyList;
    }

    public double getRating(String companyName) {
        double rating = 0;

        connection = DataAccess.getConnection();

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT avg(Mark) FROM Rate_Company r, Company c WHERE r.company_Name=c.company_Name AND c.company_Name='" +
                    companyName + "'"
            );
            if (rs.next()) {
                rating = rs.getDouble(1);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rating;
    }

    public ArrayList<String> getCompanyListBasedOnLocation(String location){
        String companyName="";
        connection=DataAccess.getConnection();
        try{
            st=connection.createStatement();
            rs=st.executeQuery("SELECT Company_Name FROM company where location='"+location+"'");
            while(rs.next()){
                companyName=rs.getString("Company_Name");
                companyListBasedOnLocation.add(companyName);
            }
        }
        catch (Exception e){
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return companyListBasedOnLocation;
    }

}