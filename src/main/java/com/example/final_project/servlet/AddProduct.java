package com.example.final_project.servlet;

import com.example.final_project.modules.SiteDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    Connection con;
    @Override
    public void init() throws ServletException {
        String DB_NAME = (String) getServletContext().getInitParameter("DB_NAME");
        String USER = (String) getServletContext().getInitParameter("USER_NAME");
        String PASS = (String) getServletContext().getInitParameter("USER_PASSWORD");
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + DB_NAME, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("header.html").include(request,response);
        request.getRequestDispatcher("addProduct.html").include(request,response);
        request.getRequestDispatcher("footer.html").include(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("Title");
        int Price= Integer.parseInt(request.getParameter("Price"));
        int Quantity= Integer.parseInt(request.getParameter("Quantity"));
        String photoUrl=request.getParameter("photoUrl");
        String details=request.getParameter("details");
        String category=request.getParameter("category");

        try {
            int value =SiteDAO.instanceData.AddProduct(title,Price,Quantity,photoUrl,details,category);
            if (value==1){

            }else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
