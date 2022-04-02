<%@ page import="com.example.final_project.modules.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.final_project.modules.SiteDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<%--<jsp:include page="header.html"/>--%>

<%@include file="/header.html" %>

<%
    HttpSession httpSession = request.getSession(false);
    if (httpSession != null) {
        String loginStatus = (String) httpSession.getAttribute("logged in");
        if (loginStatus == null || !loginStatus.equals("true")) {
            response.sendRedirect("login.jsp");
        }
    }
%>

<section id="slider"><!--slider-->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#slider-carousel" data-slide-to="1"></li>
                        <li data-target="#slider-carousel" data-slide-to="2"></li>
                    </ol>

                    <div class="carousel-inner">
                        <%
                            try {
                                List<Product> product = SiteDAO.instanceData.getProducts();
                                int num = 0;
                                for (Product i : product) {
                                    num++;
                                    if (num == 1) {
                        %>
                        <div class="item active">
                            <%
                            } else {
                            %>
                            <div class="item">
                                <%
                                    }
                                %>
                                <div class="col-sm-6">
                                    <h1><span><%=i.getTitle()%></span></h1>
                                    <h2><%=i.getPrice()%>
                                    </h2>
                                    <p><%=i.getDetails()%>
                                    </p>
                                    <button type="button" class="btn btn-default get">Get it now</button>
                                </div>
                                <div class="col-sm-6">
                                    <img src="<%=i.getPhotoUrl()%>" class="girl img-responsive" alt=""/>
                                    <img src="images/home/pricing.png" class="pricing" alt=""/>
                                </div>
                            </div>
                            <%
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            %>

                        </div>

                        <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                            <i class="fa fa-angle-left"></i>
                        </a>
                        <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>

                </div>
            </div>
        </div>
</section>
<!--/slider-->

<section>
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <div class="left-sidebar">
                    <h2>Category</h2>

                    <div class="panel-group category-products" id="accordian"><!--category-productsr-->

                        <%
                            List<String> cat =new ArrayList<>();
                            try {
                                List<Product> product = SiteDAO.instanceData.getProducts();
                                for (Product i : product) {
                                    if (!cat.contains(i.getCategory())) {
                                        cat.add(i.getCategory());
                                    }
                                }
                            } catch (SQLException e) {
                            e.printStackTrace();
                            }
                            for (String st : cat) {
                        %>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a href="#"><%=st%></a></h4>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div><!--/category-products-->

                    <div class="price-range"><!--price-range-->
                        <h2>Price Range</h2>
                        <div class="well text-center">
                            <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600"
                                   data-slider-step="5" data-slider-value="[250,450]" id="sl2"><br/>
                            <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
                        </div>
                    </div><!--/price-range-->


                </div>
            </div>

            <div class="col-sm-9 padding-right">
                <div class="features_items"><!--features_items-->
                    <h2 class="title text-center">Features Items</h2>

                    <%
                        try {
                            List<Product> product = SiteDAO.instanceData.getProducts();
                            for (Product i : product) {
                    %>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="<%=i.getPhotoUrl()%>" alt=""/>
                                    <h2>$<%=i.getPrice()%></h2>
                                    <p><%=i.getTitle()%></p>
                                    <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>View Product</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <h2>$<%=i.getPrice()%></h2>
                                        <p><%=i.getTitle()%></p>
                                        <a href="product-details.jsp?id=<%=i.getId()%>" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>View Product</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    %>

                </div><!--features_items-->

            </div>
        </div>
    </div>
</section>

<%@include file="/footer.html" %>

<%--<jsp:include page="footer.html"/>--%>


