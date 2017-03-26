package controller;

import dbbeans.ProgramBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by philxchen on 3/26/17.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String fname=request.getParameter("fName");
        String lname=request.getParameter("lName");
        String password=request.getParameter("password");
        String confirmPassword=request.getParameter("confirmPassword");
        int studentLevel=Integer.parseInt(request.getParameter("studentLevel"));

        ProgramBean program=new ProgramBean();
        HttpSession session=request.getSession();

        try{
            session.setAttribute("programList",program.getAllProgram());
        if(fname ==null ||fname.equals("") ){
            session.setAttribute("error","1");
            response.sendRedirect("register.jsp");
        }
        else if(lname ==null ||lname.equals("")){

            session.setAttribute("error","2");
            response.sendRedirect("register.jsp");
        }
        else if(password==null ||password.equals("")){

            session.setAttribute("error","3");
            response.sendRedirect("register.jsp");
        }
        else if(!password.equals(confirmPassword)){

            session.setAttribute("error","4");
            response.sendRedirect("register.jsp");
        }else{

            response.sendRedirect("index.jsp");
        }}
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
