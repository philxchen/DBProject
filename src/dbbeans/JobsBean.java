package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class JobsBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertJobs(String companyName,String title,String description, int studentLevel,int numOfPos, int salary, Date start_end,Date end_date , DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Jobs "
                    + " VALUES (default "+ companyName+","+ title+","+description+","+studentLevel+","+numOfPos+","+salary+","+start_end+","+end_date+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Job_for_program");
        }
    }




}


