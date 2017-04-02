package dbbeans;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by philxchen on 3/25/17.
 */

public class StudentBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private ArrayList<String> studentList = new ArrayList<>();

    public void insertStudent(int userID, String program, int student_level)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO student "
                    + " VALUES ("+userID+", '" + program + "', "+student_level+")");
            st.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList getStudentList()
    {
        connection = DataAccess.getConnection();
        String fname;
        String lname;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT u.fname,u.lname FROM users u, student s WHERE u.user_ID = s.user_ID GROUP BY user_ID");
        } catch(Exception e){
            System.out.println("Cant read table");
            e.printStackTrace();
        }
        try{
            while (rs.next())
            {
                fname=rs.getString("fname");
                lname=rs.getString("lname");
                studentList.add(fname + " " + lname);
            }
        }catch(Exception e){
            System.out.println("Error creating table "+e);
            e.printStackTrace();
        }
        return studentList;
    }

    public int getStudentLevel(int userId) {
        Connection connection = DataAccess.getConnection();
        int level = 0;
        try {
            Statement st = connection.createStatement();
            rs = st.executeQuery("SELECT student_level " +
                    "FROM student " +
                    "WHERE user_id=" + userId);
            if (rs.next()) {
                level = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return level;
    }

}