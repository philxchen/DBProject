package dbbeans;
import java.sql.*;
/**
 * Created by philxchen on 3/25/17.
 */
public class ApplyBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;

    public boolean existsApply(int userId, int jobId) {
        boolean exists = false;
        connection = DataAccess.getConnection();

        try{
            st = connection.createStatement();
            rs  = st.executeQuery("SELECT * FROM Apply WHERE User_ID='"+userId +"' AND Job_ID="+jobId+"'");
            if (rs.next())
            {
                exists=true;
            }
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant read likeartist table");
        }
        return(exists);
    }

    public void insertApply(int userID,int jobID)
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO apply "
                    + " VALUES ("+userID+","+ jobID+ ")");
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into Apply");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApplyBean applyBean=new ApplyBean();
    }

}
