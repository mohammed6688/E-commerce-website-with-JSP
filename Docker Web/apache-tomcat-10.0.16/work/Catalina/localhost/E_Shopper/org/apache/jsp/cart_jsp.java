/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.16
 * Generated at: 2022-04-03 20:17:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.example.final_project.modules.Product;
import java.util.List;
import com.example.final_project.modules.SiteDAO;
import java.sql.SQLException;
import com.example.final_project.modules.Cart;
import com.example.final_project.modules.UserProduct;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/header.html", Long.valueOf(1649013514000L));
    _jspx_dependants.put("/footer.html", Long.valueOf(1647712036000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.example.final_project.modules.SiteDAO");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("com.example.final_project.modules.UserProduct");
    _jspx_imports_classes.add("com.example.final_project.modules.Product");
    _jspx_imports_classes.add("com.example.final_project.modules.Cart");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <title>Home | E-Shopper</title>\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/price-range.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/animate.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"css/responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"js/html5shiv.js\"></script>\r\n");
      out.write("    <script src=\"js/respond.min.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("</head><!--/head-->\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<header id=\"header\"><!--header-->\r\n");
      out.write("    <div class=\"header_top\"><!--header_top-->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-6\">\r\n");
      out.write("                    <div class=\"contactinfo\">\r\n");
      out.write("                        <ul class=\"nav nav-pills\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-phone\"></i> +2 95 01 88 821</a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-envelope\"></i> info@domain.com</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-6\">\r\n");
      out.write("                    <div class=\"social-icons pull-right\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav\">\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-facebook\"></i></a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-twitter\"></i></a></li>\r\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-linkedin\"></i></a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div><!--/header_top-->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"header-middle\"><!--header-middle-->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-4 clearfix\">\r\n");
      out.write("                    <div class=\"logo pull-left\">\r\n");
      out.write("                        <a href=\"index.jsp\"><img src=\"images/home/logo.png\" alt=\"\" /></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-8 clearfix\">\r\n");
      out.write("                    <div class=\"shop-menu clearfix pull-right\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav\">\r\n");
      out.write("                            <!--                            <li><a href=\"\"><i class=\"fa fa-user\"></i> Account</a></li>-->\r\n");
      out.write("                            <!--                            <li><a href=\"checkout.html\"><i class=\"fa fa-crosshairs\"></i> Checkout</a></li>-->\r\n");
      out.write("                            <li><a href=\"cart.jsp\"><i class=\"fa fa-shopping-cart\"></i> Cart</a></li>\r\n");
      out.write("                            <li><a href=\"login.jsp?logout\"><i class=\"fa fa-lock\"></i> Logout</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div><!--/header-middle-->\r\n");
      out.write("\r\n");
      out.write("    <div class=\"header-bottom\"><!--header-bottom-->\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-9\">\r\n");
      out.write("                    <div class=\"navbar-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("                            <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                            <span class=\"icon-bar\"></span>\r\n");
      out.write("                            <span class=\"icon-bar\"></span>\r\n");
      out.write("                            <span class=\"icon-bar\"></span>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"mainmenu pull-left\">\r\n");
      out.write("                        <ul class=\"nav navbar-nav collapse navbar-collapse\">\r\n");
      out.write("                            <li><a href=\"index.jsp\" class=\"active\">Home</a></li>\r\n");
      out.write("                            <li class=\"dropdown\"><a href=\"#\">Shop<i class=\"fa fa-angle-down\"></i></a>\r\n");
      out.write("                                <ul role=\"menu\" class=\"sub-menu\">\r\n");
      out.write("                                    <li><a href=\"shop.jsp\">Products</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("<!--                            <li><a href=\"contact-us.jsp\">Contact</a></li>-->\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-3\">\r\n");
      out.write("                    <div class=\"search_box pull-right\">\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Search\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div><!--/header-bottom-->\r\n");
      out.write("</header><!--/header-->");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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


      out.write("\r\n");
      out.write("\r\n");
      out.write("<section id=\"cart_items\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"breadcrumbs\">\r\n");
      out.write("            <ol class=\"breadcrumb\">\r\n");
      out.write("                <li><a href=\"#\">Home</a></li>\r\n");
      out.write("                <li class=\"active\">Shopping Cart</li>\r\n");
      out.write("            </ol>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"table-responsive cart_info\">\r\n");
      out.write("            <table class=\"table table-condensed\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                <tr class=\"cart_menu\">\r\n");
      out.write("                    <td class=\"image\">Item</td>\r\n");
      out.write("                    <td class=\"description\"></td>\r\n");
      out.write("                    <td class=\"price\">Price</td>\r\n");
      out.write("                    <td class=\"quantity\">Quantity</td>\r\n");
      out.write("                    <td class=\"total\">Total</td>\r\n");
      out.write("                    <td></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                ");

                    int totalPrice = 0;

                    try {
                        List<Cart> cartList = SiteDAO.instanceData.getCart();
                        List<Product> productList = SiteDAO.instanceData.getProducts();
                        for (Cart cart : cartList) {
                            for (Product product : productList) {
                                if (userid == cart.getUserId() && cart.getProductId() == product.getId()) { //check for the ownership of the cart for that user
                
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td class=\"cart_product\">\r\n");
      out.write("                        <a href=\"\"><img width=\"60\" height=\"60\" src=\"");
      out.print(product.getPhotoUrl());
      out.write("\" alt=\"\"></a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"cart_description\">\r\n");
      out.write("                        <h4><a href=\"\">");
      out.print(product.getTitle());
      out.write("</a></h4>\r\n");
      out.write("                        <p>Web ID: ");
      out.print(product.getId());
      out.write("</p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"cart_price\">\r\n");
      out.write("                        <p>$");
      out.print(product.getPrice());
      out.write("</p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"cart_quantity\">\r\n");
      out.write("                        <div class=\"cart_quantity_button\">\r\n");
      out.write("                            <a class=\"cart_quantity_up\" href=\"#\"> + </a>\r\n");
      out.write("                            <input class=\"cart_quantity_input\" type=\"text\" name=\"quantity\" value=\"");
      out.print(cart.getQuantity());
      out.write("\" autocomplete=\"off\"\r\n");
      out.write("                                   size=\"2\">\r\n");
      out.write("                            <a class=\"cart_quantity_down\" href=\"#\"> - </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"cart_total\">\r\n");
      out.write("                        <p class=\"cart_total_price\">$");
      out.print(product.getPrice()*cart.getQuantity());
      out.write("</p>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td class=\"cart_delete\">\r\n");
      out.write("                        <a class=\"cart_quantity_delete\" href=\"cart.jsp?delete=");
      out.print(product.getId());
      out.write("\"><i class=\"fa fa-times\"></i></a>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                ");

                                    totalPrice += product.getPrice()*cart.getQuantity();

                                }
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("<!--/#cart_items-->\r\n");
      out.write("\r\n");
      out.write("<section id=\"do_action\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-sm-6\">\r\n");
      out.write("                <div class=\"total_area\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>Cart Sub Total <span>$");
      out.print(totalPrice);
      out.write("</span></li>\r\n");
      out.write("                        <li>Shipping Cost <span>Free</span></li>\r\n");
      out.write("                        <li>Total <span>$");
      out.print(totalPrice);
      out.write("</span></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <a class=\"btn btn-default check_out\" href=\"checkout.jsp\">Check Out</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section><!--/#do_action-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<footer id=\"footer\">\r\n");
      out.write("  <div class=\"footer-top\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("          <div class=\"companyinfo\">\r\n");
      out.write("            <h2><span>e</span>-shopper</h2>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"footer-widget\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("          <div class=\"single-widget\">\r\n");
      out.write("            <h2>Service</h2>\r\n");
      out.write("            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("              <li><a href=\"#\">Online Help</a></li>\r\n");
      out.write("              <li><a href=\"#\">Contact Us</a></li>\r\n");
      out.write("              <li><a href=\"#\">Order Status</a></li>\r\n");
      out.write("              <li><a href=\"#\">Change Location</a></li>\r\n");
      out.write("              <li><a href=\"#\">FAQâs</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("          <div class=\"single-widget\">\r\n");
      out.write("            <h2>Quock Shop</h2>\r\n");
      out.write("            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("              <li><a href=\"#\">T-Shirt</a></li>\r\n");
      out.write("              <li><a href=\"#\">Mens</a></li>\r\n");
      out.write("              <li><a href=\"#\">Womens</a></li>\r\n");
      out.write("              <li><a href=\"#\">Gift Cards</a></li>\r\n");
      out.write("              <li><a href=\"#\">Shoes</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("          <div class=\"single-widget\">\r\n");
      out.write("            <h2>Policies</h2>\r\n");
      out.write("            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("              <li><a href=\"#\">Terms of Use</a></li>\r\n");
      out.write("              <li><a href=\"#\">Privecy Policy</a></li>\r\n");
      out.write("              <li><a href=\"#\">Refund Policy</a></li>\r\n");
      out.write("              <li><a href=\"#\">Billing System</a></li>\r\n");
      out.write("              <li><a href=\"#\">Ticket System</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("          <div class=\"single-widget\">\r\n");
      out.write("            <h2>About Shopper</h2>\r\n");
      out.write("            <ul class=\"nav nav-pills nav-stacked\">\r\n");
      out.write("              <li><a href=\"#\">Company Information</a></li>\r\n");
      out.write("              <li><a href=\"#\">Careers</a></li>\r\n");
      out.write("              <li><a href=\"#\">Store Location</a></li>\r\n");
      out.write("              <li><a href=\"#\">Affillate Program</a></li>\r\n");
      out.write("              <li><a href=\"#\">Copyright</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-sm-3 col-sm-offset-1\">\r\n");
      out.write("          <div class=\"single-widget\">\r\n");
      out.write("            <h2>About Shopper</h2>\r\n");
      out.write("            <form action=\"#\" class=\"searchform\">\r\n");
      out.write("              <input type=\"text\" placeholder=\"Your email address\" />\r\n");
      out.write("              <button type=\"submit\" class=\"btn btn-default\"><i class=\"fa fa-arrow-circle-o-right\"></i></button>\r\n");
      out.write("              <p>Get the most recent updates from <br />our site and be updated your self...</p>\r\n");
      out.write("            </form>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <div class=\"footer-bottom\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("        <p class=\"pull-left\">Copyright Â© 2022 ITI All rights reserved.</p>\r\n");
      out.write("        <p class=\"pull-right\">Designed by Telecom Application Track</p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("<script src=\"js/jquery.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.scrollUp.min.js\"></script>\r\n");
      out.write("<script src=\"js/price-range.js\"></script>\r\n");
      out.write("<script src=\"js/jquery.prettyPhoto.js\"></script>\r\n");
      out.write("<script src=\"js/main.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}