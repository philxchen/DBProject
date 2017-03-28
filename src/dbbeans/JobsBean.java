package dbbeans;

import java.sql.*;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class JobsBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private ArrayList<String> jobListBasedOnLocation = new ArrayList<>();
    private String allInformation = "";
    private String jobsInCompany="";

    public void insertJobs(String companyName, String title, String description, int studentLevel, int numOfPos, int salary, Date start_date, Date end_date) {
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

    public ArrayList<String> getJobListBasedOnLocation(String location) {
        String jobName = "";
        int jobid = 0;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT j.Title, j.job_ID FROM jobs j,company c where j.Company_Name=c.Company_Name AND c.location='" + location + "'");
            while (rs.next()) {
                jobName = rs.getString("Title");
                jobid = rs.getInt("Job_ID");

                jobListBasedOnLocation.add(jobName + " " + jobid);
            }
        } catch (Exception e) {
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return jobListBasedOnLocation;
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
            rs = st.executeQuery("SELECT * FROM jobs");
            while (rs.next()) {
                jobId = rs.getInt("Job_ID");
                title = rs.getString("Title");
                companyName = rs.getString("Company_Name");
                student_Level = rs.getInt("student_Level");
                numOfPos = rs.getInt("Number_Of_Positions");
                salary = rs.getInt("Salary");
                startDate = rs.getDate("Start_date");
                endDate = rs.getDate("End_date");
                allInformation += "<tr><tr><td><a href=\"viewJob.jsp?jobId="
                        + jobId
                        + "\">"
                        + jobId
                        + "</a></td><td>"
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
                        "</td></tr>";
            }
        } catch (Exception e) {
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return allInformation;
    }
    public String getJobsInCompany(String company_Name){
        int jobId = 0;

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
            rs = st.executeQuery("SELECT * FROM jobs WHERE company_Name='"+company_Name+"'");
            while (rs.next()) {
                jobId = rs.getInt("Job_ID");
                title = rs.getString("Title");
                student_Level = rs.getInt("student_Level");
                numOfPos = rs.getInt("Number_Of_Positions");
                salary = rs.getInt("Salary");
                startDate = rs.getDate("Start_date");
                endDate = rs.getDate("End_date");
                jobsInCompany += "<tr><tr><td> " +
                        + jobId
                        + "</td><td>"
                        + title
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
                        "</td></tr>";
            }
        } catch (Exception e) {
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return jobsInCompany;
    }

//    public static void main(String[] args) {
//        System.out.println((new JobsBean()).getAllInformation());
//    }

}