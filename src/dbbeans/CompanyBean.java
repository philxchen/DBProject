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

    public double getRating(String companyName){
        double rating=0;

        connection = DataAccess.getConnection();

        try{
            st = connection.createStatement();
            //System.out.println(connection.getSchema());
            rs  = st.executeQuery("SELECT avg(Mark) FROM Rate_Company r, Company c Where r.company_Name=c.company_Name AND c.company_Name='"+
                    companyName + "'"
                    );
            System.out.print(rs);
            if (rs.first()) {
                rating=rs.getDouble(1);
            }

            st.close();
        }catch(Exception e){
            System.out.println("Cant read company table");
        }
        return rating;
    }

    public static void main(String[] args) {
        CompanyBean company=new CompanyBean();
        double rating=0;
        rating=company.getRating("Red 1 Engineering");
        System.out.print(rating);
    }
}



