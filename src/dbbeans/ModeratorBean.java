package dbbeans;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by philxchen on 3/25/17.
 */

public class ModeratorBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private ArrayList<String> moderatorList = new ArrayList<>();

    public void insertModerator(int userID)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Moderator "
                    + " VALUES ("+userID+",Default )");

            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Moderator");
            e.printStackTrace();
        }
    }

    public ArrayList getModeratorList()
    {
        connection = DataAccess.getConnection();
        String fname;
        String lname;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT u.fname,u.lname FROM users u, moderator mo WHERE u.user_ID = mo.user_ID GROUP BY user_ID");
        } catch(Exception e){
            System.out.println("Cant read table");
            e.printStackTrace();
        }
        try{
            while (rs.next()) {
                fname=rs.getString("fname");
                lname=rs.getString("lname");
                moderatorList.add(fname + " " + lname);
            }
        }catch(Exception e){
            System.out.println("Error creating table "+e);
            e.printStackTrace();
        }
        return moderatorList;
    }

}