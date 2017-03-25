package dbbeans;

import java.sql.*;

/**
 * Created by philxchen on 3/25/17.
 */
public class UserBean {
    private Connection connection;
    private Statement st;
    private DataAccess dataaccess;
    private ResultSet rs;
    private String getUserList="";



    public void setDataAccess(DataAccess db)
    {
        dataaccess = db;
    }



    public void insertUser(int userID, String email, String fname, String lname, String password, DataAccess db)
    {
        connection = db.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO users "
                    + " VALUES ("+userID+"," + email + ","+fname+","+lname+","+password+")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Users");
        }
    }


    public String getUserList()
    {
        connection = dataaccess.getConnection();
        String fname;
        String lname;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM users GROUP BY user_ID");
        } catch(Exception e){
            System.out.println("Cant read likeartist table");
        }
        try{
            while (rs.next())
            {
                fname=rs.getString("Fname");
                lname=rs.getString("Lname");
                getUserList+="<tr><tr><td>"
                        + fname
                        + "</td><td>"
                        + lname
                        +"</td></tr>";
            }
        }catch(Exception e){
            System.out.println("Error creating table "+e);
        }
        return getUserList;
    }

}

