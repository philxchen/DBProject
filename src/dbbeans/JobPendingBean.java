package dbbeans;

import java.sql.*;
        import java.util.ArrayList;
        import java.util.StringJoiner;

/**
 * Created by michaelhuang on 2017-03-29.
 */

public class JobPendingBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String allInformation = "";

    public void insertJobPending(String companyName, String title, String description, int studentLevel, int numOfPos, int salary, Date start_date, Date end_date) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Jobs "
                    + " VALUES (default '" + companyName + "','" + title + "','" + description + "'," + studentLevel + "," + numOfPos + "," + salary + ",'" + start_date + "','" + end_date + "')");

            st.close();
        } catch (Exception e) {
            System.out.println("Cant insert into Job_for_program");
            e.printStackTrace();
        }
    }

    public String getAllInformation() {
        int jobId = 0;
        String companyName = "";
        String description = "";
        int student_Level = 1;
        int numOfPos = 0;
        int salary = 0;
        String title = "";
        Date startDate;
        Date endDate;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM jobPending");
            while (rs.next()) {
                jobId = rs.getInt("Job_ID");
                title = rs.getString("Title");
                companyName = rs.getString("Company_Name");
                student_Level = rs.getInt("student_Level");
                numOfPos = rs.getInt("Number_Of_Positions");
                salary = rs.getInt("Salary");
                description=rs.getString("description");
                startDate = rs.getDate("Start_date");
                endDate = rs.getDate("End_date");
                allInformation += "<tr><tr><td>"
                        + jobId
                        + "</td><td>"
                        + title
                        + "</td><td>"
                        + companyName
                        + "</td><td>"
                        + student_Level
                        + "</td><td>"
                        + numOfPos
                        + "</td><td>"
                        + salary
                        + "</td><td>"
                        + startDate
                        + "</td><td>"
                        + endDate +
                        "</td><td>"
                        +description
                        +"</td><td><a href=\"approve.jsp?jobId="
                        +jobId
                        +"\">"
                        +"<button name=\"button\">approve</button>"
                        +"</a></td></tr>";
            }
        } catch (Exception e) {
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return allInformation;
    }

}