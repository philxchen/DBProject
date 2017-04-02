package dbbeans;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by michaelhuang on 2017-03-25.
 */

public class JobsBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private ArrayList<String> jobListBasedOnLocation = new ArrayList<>();
    private ArrayList<String> jobForStudentLevel = new ArrayList<>();
    private ArrayList<String> jobListBySudentLevel = new ArrayList<>();
    private String allInformation = "";
    private String jobsInCompany = "";

    public void insertJobs(int jobId, String companyName, String title, String description, int studentLevel, int numOfPos, int salary, Date start_date, Date end_date) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Jobs "
                    + " VALUES (" + jobId + ",'" + companyName + "','" + title + "','" + description + "'," + studentLevel + "," + numOfPos + "," + salary + ",'" + start_date + "','" + end_date + "')");

            st.close();
        } catch (Exception e) {
            System.out.println("Cant insert into Job");
            e.printStackTrace();
        }
    }

    public ArrayList<String> getJobListBasedOnLocation(String location) {
        String jobName = "";
        int jobid = 0;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT j.Title, j.job_ID FROM jobs j,company c WHERE j.Company_Name=c.Company_Name AND c.location='" + location + "'");
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

    public ArrayList<String> getJobListByStudentLevel(Integer studentLevel) {
        String jobName = "";
        int jobid = 0;
        int sLevel = 0;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT title, job_ID, studentLevel FROM jobs ORDER BY studentLevel");
            while (rs.next()) {
                jobName = rs.getString("Title");
                jobid = rs.getInt("Job_ID");
                sLevel = rs.getInt("studentLevel");

                jobListBySudentLevel.add(jobName + " " + jobid + " " + sLevel);
            }
        } catch (Exception e) {
            System.out.println("Cant get list based on location");
            e.printStackTrace();

        }
        return jobListBySudentLevel;
    }

    public ArrayList<String> getJobForStudentLevel(Integer studentLevel) {
        String jobName = "";
        int jobid = 0;
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT j.title, j.job_ID FROM jobs j WHERE j.studentLevel='" + studentLevel + "'");
            while (rs.next()) {
                jobName = rs.getString("Title");
                jobid = rs.getInt("Job_ID");

                jobForStudentLevel.add(jobName + " " + jobid);
            }
        } catch (Exception e) {
            System.out.println("Cant get list based on location");
            e.printStackTrace();

        }
        return jobForStudentLevel;
    }

    public String getAllInformation(int userId, String orderByColumn) {
        int studentLevel = (new StudentBean()).getStudentLevel(userId);
        int jobId = 0;
        String companyName = "";
        String description = "";
        int student_Level;
        int numOfPos = 0;
        int salary = 0;
        String title = "";
        Date startDate;
        Date endDate;
        connection = DataAccess.getConnection();


        try {
            Statement st = connection.createStatement();
//          ORDER results if orderByColumn param is valid
            if (orderByColumn == null
                    || (!orderByColumn.equals("student_Level")
                    && !orderByColumn.equals("Number_Of_Positions")
                    && !orderByColumn.equals("Salary"))) {
                rs = st.executeQuery("SELECT * FROM jobs " +
                        "WHERE student_level <= " + studentLevel);
            } else {
                rs = st.executeQuery("SELECT * FROM jobs " +
                        "WHERE student_level <= " + studentLevel +
                        " ORDER BY " + orderByColumn + " DESC");
            }
            while (rs.next()) {
                jobId = rs.getInt("Job_ID");
                title = rs.getString("Title");
                companyName = rs.getString("Company_Name");
                student_Level = rs.getInt("student_Level");
                numOfPos = rs.getInt("Number_Of_Positions");
                salary = rs.getInt("Salary");
                startDate = rs.getDate("Start_date");
                endDate = rs.getDate("End_date");
                allInformation += "<tr><td><a href=\"viewJob.jsp?jobId="
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
            e.printStackTrace();

        }
        return allInformation;
    }

    public String getJobsInCompany(String company_Name) {
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
            rs = st.executeQuery("SELECT * FROM jobs WHERE company_Name='" + company_Name + "'");
            while (rs.next()) {
                jobId = rs.getInt("Job_ID");
                title = rs.getString("Title");
                student_Level = rs.getInt("student_Level");
                numOfPos = rs.getInt("Number_Of_Positions");
                salary = rs.getInt("Salary");
                startDate = rs.getDate("Start_date");
                endDate = rs.getDate("End_date");
                jobsInCompany += "<tr><tr><td> " +
                        +jobId
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

    public String getCompanyName(int jobId) {
        String companyName = "";
        try {
            Connection connection = DataAccess.getConnection();
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT company_name " +
                    "FROM jobs " +
                    "WHERE job_id = " + jobId);
            if (rs.next()) {
                companyName = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companyName;
    }

}