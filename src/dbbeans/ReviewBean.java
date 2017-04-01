package dbbeans;

import java.sql.*;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class ReviewBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String reviewInfoBaseOnCompany;


    public void insertReview(int userID, String companyName,Date date,String title, String body )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Review "
                    + " VALUES ("+userID+",DEFAULT ,'"+companyName+"','"+date +"','"+title+"','"+body+"',"+0+ ")");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Review");
            e.printStackTrace();
        }
    }

    public String getReviewInfoBaseOnCompany(String companyName){

        String description = "";
        int reviewId=0;
        int voteCount=0;
        String title = "";
        String company_Name="";
        Date date;

        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM Review WHERE Company_Name='"+companyName+"'ORDER BY vote_count DESC ");
            while (rs.next()) {
                reviewId = rs.getInt("Review_ID");
                title = rs.getString("Title");
                description=rs.getString("Body");
                voteCount=rs.getInt("vote_count");
                company_Name=rs.getString("Company_Name");
                date = rs.getDate("Date");

               reviewInfoBaseOnCompany += "<tr><tr><td>"
                        + title
                        + "</td><td>"
                        + date
                        + "</td><td>"
                        + description
                        + "</td><td>"
                        + voteCount
                        + "</td><td><a href=\"voteSuccess.jsp?reviewId="
                        + reviewId
                        + "&companyName="
                        + company_Name
                        + "\">"
                        + "<button name=\"button\">upvote</button>"
                        + "</a></td></tr>";
            }
        } catch (Exception e) {
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return reviewInfoBaseOnCompany;
    }

}