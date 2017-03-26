package dbbeans;
import java.sql.*;
/**
 * Created by michaelhuang on 2017-03-25.
 */
public class ProgramBean {
    private Connection connection;
    private Statement st;
    private ResultSet rs;
    private String getStudentListInProgram;





    public void insertProgram(String programName,String field )
    {
        connection = DataAccess.getConnection();
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO program "
                    + " VALUES ("+ programName+","+ field+ ")");
            rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("Cant insert into program");
        }
    }

    public String getListOfStudentInProgram (String programName){

            connection = DataAccess.getConnection();
            String fname;
            String lname;

            try {
                st = connection.createStatement();
                rs = st.executeQuery("SELECT s.fname,s.lname " +
                        "FROM program p, student s " +
                        "WHERE p.programName = s.program AND p.programName=" + programName);
            } catch(Exception e){
                System.out.println("Cant read program table");
            }
            try{
                while (rs.next())
                {
                    fname=rs.getString("fame");
                    lname=rs.getString("lname");
                    getStudentListInProgram+="<tr><tr><td>"
                            + fname
                            + "</td><td>"
                            + lname
                            +"</td></tr>";
                }
            }catch(Exception e){
                System.out.println("Error creating table "+e);
            }
            return getStudentListInProgram;

    }


}


