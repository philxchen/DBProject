package dbbeans;

import java.sql.*;

/**
 * Created by philxchen on 3/25/17.
 */

public class UsersBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String getUserList = "";
    private int userID;
    private String email;

    public int getUserID(){
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            rs=st.executeQuery("SELECT user_ID FROM Users WHERE email='"+email + "'");
            if(rs.next()){
                userID=rs.getInt("user_ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userID;
    }
    public void insertUser( String email, String fname, String lname, String password) {
        connection = DataAccess.getConnection();
        this.email=email;
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO users "
                    + " VALUES (DEFAULT" + ", '" + email + "', '" + fname + "', '" + lname + "', '" + password + "')");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getUserList() {
        connection = DataAccess.getConnection();
        String fname;
        String lname;

        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM users GROUP BY user_ID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                fname = rs.getString("Fname");
                lname = rs.getString("Lname");
                getUserList += "<tr><tr><td>"
                        + fname
                        + "</td><td>"
                        + lname
                        + "</td></tr>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getUserList;
    }

    public String getUserName(int userId) {
        connection = DataAccess.getConnection();
        String fName = "", lName = "";
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT fname, lname FROM users WHERE user_id = " + userId);

            if (rs.next()) {
                fName = rs.getString("fname");
                lName = rs.getString("lname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fName + " " + lName;
    }

}