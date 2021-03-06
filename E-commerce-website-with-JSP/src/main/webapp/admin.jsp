<%@ page import="com.example.final_project.modules.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.final_project.modules.SiteParser" %><%--
  Created by IntelliJ IDEA.
  User: moham
  Date: 3/25/2022
  Time: 7:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>
<%@include file="/adminheader.html" %>

<%!
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
%>
<div class="container">
    <div class="breadcrumbs">
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li class="active">Shopping Cart</li>
        </ol>
    </div>
    <div class="table-responsive cart_info">
        <table class="table table-condensed">
            <thead>
            <tr class="cart_menu">
                <td class="image">Item</td>
                <td class="description"></td>
                <td class="price">Price</td>
                <td class="quantity">Quantity</td>
                <td class="total">Edit</td>
                <td class="total">Delete</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <%
                List<Product> product;
                if (request.getParameter("mode")!=null && request.getParameter("mode").equals("search")){
                    String keyword = request.getParameter("search");
                    if (isNumeric(keyword)){
                        product = SiteParser.instanceData.getProduct(Integer.parseInt(keyword));
                    }else {
                        product = SiteParser.instanceData.getProduct(keyword);
                    }
                }else {
                    product = SiteParser.instanceData.getProducts();
                }
                for (Product i : product) {

        %>
        <tr>
            <td class="cart_product">
                <a href=""><img width="60" height="60" src="<%=i.getPhotoUrl()%>" alt=""></a>
            </td>
            <td class="cart_description">
                <h4><a href=""><%=i.getTitle()%>
                </a></h4>
                <p>Web ID:<%=i.getId()%>
                </p>
            </td>
            <td class="cart_price">
                <p><%=i.getPrice()%>
                </p>
            </td>
            <td class="cart_quantity">
                <div class="cart_quantity_button">
                    <p><%=i.getQuantity()%>
                    </p>
                </div>
            </td>
            <td class="cart_edit">
                <a class="cart_quantity_edit" href="addProduct.jsp?mode=edit&id=<%=i.getId()%>"><i
                        class="fa fa-times"></i></a>
            </td>
            <td class="cart_delete">
                <a class="cart_quantity_delete" href="admin.jsp?mode=delete&id=<%=i.getId()%>"><i
                        class="fa fa-times"></i></a>
            </td>
        </tr>

        <%
                }
            %>


            </tbody>
        </table>
    </div>
</div>
<%@include file="/footer.html" %>
</body>
</html>
