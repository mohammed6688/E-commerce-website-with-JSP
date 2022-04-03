<%@ page import="com.example.final_project.modules.SiteDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.final_project.modules.Product" %>
<%@ page import="com.example.final_project.modules.Cart" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.final_project.modules.User" %>
<%@ page import="com.twilio.rest.api.v2010.account.Message" %>
<%@ page import="static com.example.final_project.HelloServlet.AUTH_TOKEN" %>
<%@ page import="static com.example.final_project.HelloServlet.ACCOUNT_SID" %>
<%@ page import="com.twilio.type.PhoneNumber" %>
<%@ page import="com.twilio.Twilio" %>
<%
    HttpSession httpSession = request.getSession(false);
    int userid=0,creditlimit=0,phone=0;
    String name="",mail="",pass="",address="",job="",birthdate="",interests="";
    if (httpSession != null) {
        String loginStatus = (String) httpSession.getAttribute("logged in");

        userid= (Integer) httpSession.getAttribute("userid");
        creditlimit= (Integer) httpSession.getAttribute("creditlimit");
        name = (String) httpSession.getAttribute("name");
        mail= (String) httpSession.getAttribute("mail");
        phone= (Integer) httpSession.getAttribute("phone");
        pass= (String) httpSession.getAttribute("pass");
        address= (String) httpSession.getAttribute("address");
        job = (String) httpSession.getAttribute("job");
        birthdate= (String) httpSession.getAttribute("birthdate");
        interests= (String) httpSession.getAttribute("interests");

        System.out.println("in cart "+userid);

        if (loginStatus == null || !loginStatus.equals("true")) {
            response.sendRedirect("login.jsp");
        }
    }
    try {
        List<Product> products =SiteDAO.instanceData.getProducts();
        List<Cart> cart =SiteDAO.instanceData.getCart();
        User user=new User(userid,false,name,birthdate,pass,phone,job,mail,creditlimit,address,interests);
        SiteDAO.instanceData.checkout(user,products,cart);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber("+201126498473"),
                new PhoneNumber("+14433314574"),
                "thank you for shopping with us your order placed successfully").create();
        System.out.println(message.getSid());
        response.sendRedirect("index.jsp");
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>