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
    private ArrayList<String> companyListBasedOnLocation=new ArrayList<>();
    private String allCompanyList="";



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

    public String getAllCompanyList(){
        String companyName="";
        connection=DataAccess.getConnection();
        try{st=connection.createStatement();
            rs=st.executeQuery("SELECT Company_Name FROM company ");
            while (rs.next()){
                companyName=rs.getString("Company_Name");
                allCompanyList+="<tr><td><a href=\"ratePage.jsp?companyName="
                        +companyName
                        +"\">"
                        +companyName
                        +"</a></td></tr>";

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return allCompanyList;
    }

}



