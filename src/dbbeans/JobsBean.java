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
    private ArrayList<String> jobListBasedOnLocation=new ArrayList<>();




    public void insertJobs(String companyName,String title,String description, int studentLevel,int numOfPos, int salary, Date start_date,Date end_date )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Jobs "
                    + " VALUES (default '"+ companyName+"','"+ title+"','"+description+"',"+studentLevel+","+numOfPos+","+salary+",'"+start_date+"','"+end_date+ "')");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Job_for_program");
            e.printStackTrace();
        }
    }
    public ArrayList<String> getJobListBasedOnLocation(String location){
        String jobName="";
        int jobid=0;
        connection=DataAccess.getConnection();
        try{
            st=connection.createStatement();
            rs=st.executeQuery("SELECT j.Title, j.job_ID FROM jobs j,company c where j.Company_Name=c.Company_Name AND c.location='"+location+"'");
            while(rs.next()){
                jobName=rs.getString("Title");
                jobid=rs.getInt("Job_ID");

                jobListBasedOnLocation.add(jobName+" "+jobid);
            }
        }
        catch (Exception e){
            System.out.println("cant get list based on location");
            e.printStackTrace();

        }
        return jobListBasedOnLocation;
    }
    }




