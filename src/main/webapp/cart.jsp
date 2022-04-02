<%@ page import="com.example.final_project.modules.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.final_project.modules.SiteDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.final_project.modules.Cart" %>
<%@ page import="com.example.final_project.modules.UserProduct" %>
<!DOCTYPE html>
<%@include file="/header.html" %>


<%
    HttpSession httpSession = request.getSession(false);
    int userid=0;
    if (httpSession != null) {
        String loginStatus = (String) httpSession.getAttribute("logged in");
        userid= (Integer) httpSession.getAttribute("userid");
        System.out.println("in cart "+userid);

        if (loginStatus == null || !loginStatus.equals("true")) {
            response.sendRedirect("login.jsp");
        }
    }
    String delete =request.getParameter("delete");
    if (delete!=null){
        try {
            SiteDAO.instanceData.deleteFromCart(Integer.parseInt(delete),userid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    String id =request.getParameter("id");
    String quantity =request.getParameter("quantity");
    if (id!=null) {
        try {
            Cart cart = new Cart(Integer.parseInt(id),userid,Integer.parseInt(quantity));
            SiteDAO.instanceData.addToCart(cart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

%>

<section id="cart_items">
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
                    <td class="total">Total</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <%
                    int totalPrice = 0;

                    try {
                        List<Cart> cartList = SiteDAO.instanceData.getCart();
                        List<Product> productList = SiteDAO.instanceData.getProducts();
                        for (Cart cart : cartList) {
                            for (Product product : productList) {
                                if (userid == cart.getUserId() && cart.getProductId() == product.getId()) { //check for the ownership of the cart for that user
                %>
                <tr>
                    <td class="cart_product">
                        <a href=""><img width="60" height="60" src="<%=product.getPhotoUrl()%>" alt=""></a>
                    </td>
                    <td class="cart_description">
                        <h4><a href=""><%=product.getTitle()%></a></h4>
                        <p>Web ID: <%=product.getId()%></p>
                    </td>
                    <td class="cart_price">
                        <p>$<%=product.getPrice()%></p>
                    </td>
                    <td class="cart_quantity">
                        <div class="cart_quantity_button">
                            <a class="cart_quantity_up" href="#"> + </a>
                            <input class="cart_quantity_input" type="text" name="quantity" value="<%=cart.getQuantity()%>" autocomplete="off"
                                   size="2">
                            <a class="cart_quantity_down" href="#"> - </a>
                        </div>
                    </td>
                    <td class="cart_total">
                        <p class="cart_total_price">$<%=product.getPrice()*cart.getQuantity()%></p>
                    </td>
                    <td class="cart_delete">
                        <a class="cart_quantity_delete" href="cart.jsp?delete=<%=product.getId()%>"><i class="fa fa-times"></i></a>
                    </td>
                </tr>
                <%
                                    totalPrice += product.getPrice()*cart.getQuantity();

                                }
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</section>
<!--/#cart_items-->

<section id="do_action">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="total_area">
                    <ul>
                        <li>Cart Sub Total <span>$<%=totalPrice%></span></li>
                        <li>Shipping Cost <span>Free</span></li>
                        <li>Total <span>$<%=totalPrice%></span></li>
                    </ul>
                    <a class="btn btn-default check_out" href="checkout.jsp">Check Out</a>
                </div>
            </div>
        </div>
    </div>
</section><!--/#do_action-->


<%@include file="/footer.html" %>
