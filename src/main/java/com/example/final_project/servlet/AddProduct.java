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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("header.html").include(request,response);
        request.getRequestDispatcher("addProduct.jsp").include(request,response);
        request.getRequestDispatcher("footer.html").include(request,response);

        String mode = request.getParameter("mode");
        if (mode!=null){
            int Price= Integer.parseInt(request.getParameter("Price"));
            int Quantity= Integer.parseInt(request.getParameter("Quantity"));
            int id=Integer.parseInt(request.getParameter("id"));

            try {
                int value =SiteDAO.instanceData.editProduct(Price,Quantity,id);
                if (value==1){
                    System.out.println("success edited");
                }else {
                    System.out.println("failed edited");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
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
