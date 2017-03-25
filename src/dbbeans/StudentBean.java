package dbbeans;

import java.sql.*;

/**
 * Created by philxchen on 3/25/17.
 */
public class StudentBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;
    private String getStudentList="";



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }


    public void insertStudent(int userID, String program, int student_level, DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO student "
                    + " VALUES ("+userID+"," + program + ","+student_level+")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Users");
        }
    }


    public String getStudentList()
    {
        connection = dataaccess.getConnection();
        String fname;
        String lname;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT u.fname,u.lname FROM users u, student s WHERE u.user_ID = s.user_ID GROUP BY user_ID");
        } catch(Exception e){
            System.out.println("Cant read likeartist table");
        }
        try{
            while (rs.next())
            {
                fname=rs.getString("fame");
                lname=rs.getString("lname");
                getStudentList+="<tr><tr><td>"
                        + fname
                        + "</td><td>"
                        + lname
                        +"</td></tr>";
            }
        }catch(Exception e){
            System.out.println("Error creating table "+e);
        }
        return getStudentList;
    }

}

