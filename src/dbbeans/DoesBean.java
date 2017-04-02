package dbbeans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by philxchen on 3/25/17.
 */
public class DoesBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String doesJobList;


    public void insertDoes(int userID, int jobID) {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO Does "
                    + " VALUES (" + userID + "," + jobID + ")");
            st.close();
        } catch (Exception e) {
            System.out.println("Cant insert into Does");
            e.printStackTrace();
        }
    }

    public String getDoesJobList(int userId) {
        int jobId = 0;
        connection = DataAccess.getConnection();
        JobsBean jobsBean = new JobsBean();
        try {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT Job_ID FROM does WHERE User_ID=" + userId);
            while (rs.next()) {
                jobId = rs.getInt("Job_ID");
                doesJobList += "<tr><td><a href=\"ratePage.jsp?companyName="
                        + jobsBean.getCompanyName(jobId)
                        + "\">"
                        + jobId + "</td><td><a href=\"makeReview.jsp?jobId="
                        + jobId
                        + "\">"
                        + "<button name=\"button\">Create Review</button>"
                        + "</a></td></tr>";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doesJobList;
    }
}



