<%@ page import="com.example.final_project.modules.SiteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.final_project.modules.Product" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>

<%@include file="/header.html" %>

<%
    HttpSession httpSession = request.getSession(false);
    if (httpSession != null) {
        String loginStatus = (String) httpSession.getAttribute("logged in");
        if (loginStatus == null || !loginStatus.equals("true")) {
            response.sendRedirect("login.jsp");
        }
    }

    String id =request.getParameter("id");
    try {
        List<Product> products =SiteDAO.instanceData.getProducts();
        for (Product prod:products){
            if (prod.getId()==Integer.parseInt(id)){

%>
<section>
    <div class="container">
        <div class="row">

            <div class="col-sm-9 padding-right">
                <div class="product-details"><!--product-details-->
                    <div class="col-sm-5">
                        <div class="view-product">
                            <img src="<%=prod.getPhotoUrl()%>" alt=""/>
                            <h3>ZOOM</h3>
                        </div>
                    </div>
                    <div class="col-sm-7">
                        <form action="cart.jsp?">
                        <div class="product-information"><!--/product-information-->
                            <img src="../images/product-details/new.jpg" class="newarrival" alt=""/>
                            <h2><%=prod.getTitle()%></h2>
                            <p>Web ID: <%=prod.getId()%></p>
                            <img src="../images/product-details/rating.png" alt=""/>
                            <span>
									<span>US $<%=prod.getPrice()%></span>
									<label>Quantity:</label>
									<input type="text" value="1" name="quantity"/>
									<button type="submit" class="btn btn-fefault cart">
										<i class="fa fa-shopping-cart"></i>
										Add to cart
									</button>
								</span>
                            <%if (prod.getQuantity()>0){%>
                            <p><b>Availability:</b> In Stock</p>
                            <%}%>
                            <p><b>Condition:</b> New</p>
                            <p><b>Category:</b> <%=prod.getCategory()%></p>
                        </div><!--/product-information-->
                        </form>
                    </div>
                </div><!--/product-details-->

                <div class="category-tab shop-details-tab"><!--category-tab-->
                    <div class="col-sm-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#reviews" data-toggle="tab">Reviews</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane fade active in" id="reviews">
                            <div class="col-sm-12">
                                <p><%=prod.getDetails()%></p>
                                <p><b>Write Your Review</b></p>
                                <form action="#">
										<span>
											<input type="text" placeholder="Your Name"/>
											<input type="email" placeholder="Email Address"/>
										</span>
                                    <textarea name=""></textarea>
                                    <b>Rating: </b> <img src="../images/product-details/rating.png" alt=""/>
                                    <button type="button" class="btn btn-default pull-right">
                                        Submit
                                    </button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div><!--/category-tab-->
            </div>
        </div>
    </div>
</section>
<%
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<%@include file="/footer.html" %>
