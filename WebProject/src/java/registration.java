/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayman
 */
public class registration extends HttpServlet {

    static final String DB_url = "jdbc:postgresql://localhost/servletdatabase";

    //database credintial
    static final String user = "postgres";
    static final String pass = "postgres";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String fname = null;
        String lname = null;
        String uname = null;
        String phone = null;
        String job = null;
        String address = null;
        String interests = null;
        String birth = null;

        Connection conn = null;
        Statement stmt = null;

        try {

            fname = req.getParameter("FName");
            lname = req.getParameter("LName");
            phone = req.getParameter("phone");
            job = req.getParameter("job");
            birth = req.getParameter("BirthDay");
            address = req.getParameter("address");
            interests = req.getParameter("interests");
            uname = req.getParameter("UName");



 

            // reqister JDBC driver 
            Class.forName("org.postgresql.Driver");

            // open connection
            conn = DriverManager.getConnection(DB_url, user, pass);

            //excute query 
            stmt = conn.createStatement();
            
            String sql = "INSERT INTO registration VALUES('" + fname + "','" + lname + "','" + phone + "','" + job + "','" + address + "','" + birth + "','" + interests + "','" + uname + "')";



            if (fname != null) {
//                out.println(fname);
                stmt.executeUpdate(sql);
//                out.println(fname);
                out.println("The records affected by this SQL statement are:" + stmt.getUpdateCount());
            } else {
                resp.sendRedirect("login.html");
                //out.println("please enter valid value ");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
        }

    }

}
