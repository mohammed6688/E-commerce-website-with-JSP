/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.16
 * Generated at: 2022-04-03 20:17:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Random;
import com.example.final_project.modules.SiteDAO;
import java.sql.Date;
import com.example.final_project.modules.User;

public final class validation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


    public static final String ACCOUNT_SID = "ACceb4ceec732d6b9e1719d2906fc117ae";
    public static final String AUTH_TOKEN = "60a80e1c593fb93ba0b3e28bed0dd294";
    private void signUp(){}


    public String generation() {
        int A = 0, B = 0, C = 0, D = 0;
        int[] code = {A, B, C, D};
        StringBuilder sms = new StringBuilder();
        for (int i : code) {
            // create instance of Random class
            Random rand = new Random();
            // Generate random integers in range 0 to 9
            code[i] = rand.nextInt(10);
            sms.append(Integer.toString(code[i])).append(" ");
        }
        return sms.toString();
    }


    public boolean verification(String userInput, String x){
        String userIn = userInput.replaceAll(" ", "");
        return userIn.equals(x.replaceAll(" ", ""));
    }


  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.example.final_project.modules.SiteDAO");
    _jspx_imports_classes.add("com.example.final_project.modules.User");
    _jspx_imports_classes.add("com.twilio.type.PhoneNumber");
    _jspx_imports_classes.add("java.util.Random");
    _jspx_imports_classes.add("com.twilio.Twilio");
    _jspx_imports_classes.add("com.twilio.rest.api.v2010.account.Message");
    _jspx_imports_classes.add("java.sql.Date");
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Validation</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');

    String error = "";
    String phonePattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    String passPattern= "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()?[{}]:;',?/*~$^+=<>]).{8,20}$";

    boolean nameFlag = false, passFlag=false, emailFlag=false, phoneFlag=false, phoneValFlag=false, codeValFlag=false ,creditLimitFlag=false;


    String mode = request.getParameter("mode");

    System.out.println("mode is "+mode);

    if (mode!=null && mode.equals("signin")){
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        if (password != null && password.length() != 0) {
            passFlag=true;
        }else {
            error="password_error";
            System.out.print("Please enter valid format");
        }

        if (email != null && !email.equals("")) {
            emailFlag=true;
        } else {
            error="email_error";
            System.out.println(" Email is Required");
        }

        if (emailFlag && passFlag) {
            //verifies phone number logic here
            User user;
            user = SiteDAO.instanceData.checkSignIn(email,password);

            if (user!=null) {
                HttpSession httpSession = request.getSession(true);
                System.out.println("in validation "+user.getId());
                httpSession.setAttribute("userid", user.getId());
                httpSession.setAttribute("name", user.getName());
                httpSession.setAttribute("mail", user.getEmail());
                httpSession.setAttribute("phone", user.getPhoneNumber());
                httpSession.setAttribute("pass", user.getPassword());
                httpSession.setAttribute("creditlimit", user.getCreditLimit());
                httpSession.setAttribute("address", user.getAddress());
                httpSession.setAttribute("job", user.getJop());
                httpSession.setAttribute("birthdate", user.getBirthDate());
                httpSession.setAttribute("interests", user.getInterests());

                httpSession.setAttribute("logged in","true");
                response.sendRedirect("index.jsp");
            }else {
                error= "login_error";
                response.sendRedirect("login.jsp?"+error);
            }
        } else {
            System.out.println("error: "+error);
            response.sendRedirect("login.jsp?"+error);
        }

    }else if (mode!=null && mode.equals("signup")){
        String userName = request.getParameter("username");
        String password = request.getParameter("pass");
        String email = request.getParameter("email");
        String PhoneNumber = request.getParameter("phone");

        String getCreditLimit = request.getParameter("creditLimit");
        String getBirthdate = request.getParameter("BirthDay");
        String getJob = request.getParameter("job");
        String getAddress = request.getParameter("address");
        String getInterests = request.getParameter("interests");
        System.out.println("in signup");
        if (userName != null && userName.length() != 0) {
            nameFlag=true;
        }else {
            System.out.println("Username is Required");
            error="name_error";
        }

        if (password != null && password.length() != 0) {
            passFlag=true;
        }else {
            error="password_error";
            System.out.print("Please enter valid format");
        }

        if (email != null && !email.equals("")) {
            emailFlag=true;
        } else {
            error="email_error";
            System.out.println(" Email is Required");
        }

        if (PhoneNumber != null && PhoneNumber.length() != 0 ) {
            phoneFlag=true;
        }else {
            error="phone_error";
            System.out.println("phone number is Required");
        }

        if (getCreditLimit != null && getCreditLimit.length() != 0) {
            creditLimitFlag=true;
        }else {
            System.out.println("Username is Required");
            error="credit_error";
        }

        if (nameFlag && emailFlag && passFlag && phoneFlag && creditLimitFlag) {
            //verifies phone number logic here
            String code = generation();
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(new PhoneNumber("+201126498473"),
                    new PhoneNumber("+14433314574"),
                    "your code is: "+code).create();
            System.out.println(message.getSid());
            response.sendRedirect("phoneValidate.jsp");
            /*
            HttpSession httpSession =request.getSession(true);
            httpSession.setAttribute("sms_code",code);
            httpSession.setAttribute("name",userName);
            httpSession.setAttribute("mail",email);
            httpSession.setAttribute("phone",PhoneNumber);
            httpSession.setAttribute("pass",password);
            httpSession.setAttribute("creditlimit",getCreditLimit);
            httpSession.setAttribute("address",getAddress);
            httpSession.setAttribute("job",getJob);
            httpSession.setAttribute("birthdate",getBirthdate);
            httpSession.setAttribute("interests",getInterests);


            String res = SiteDAO.instanceData.checkSignUp(false,userName,Date.valueOf(getBirthdate),password,Integer.parseInt(PhoneNumber),getJob,email,Integer.parseInt(getCreditLimit),getAddress,getInterests);
            if (res.equals("SignedUp Successfully")){
//                httpSession.setAttribute("logged in","true");
                response.sendRedirect("login.jsp");
            }else {
                System.out.println(res);
                error = "register_error";
                response.sendRedirect("login.jsp?" + error);
            }*/
        } else {
            System.out.println("error: "+error);
            response.sendRedirect("login.jsp?"+error);
        }
    }else if (mode!=null && mode.equals("code")){
        //logic of code validation here
        String userInput = request.getParameter("code");
        if (userInput != null && userInput.length()!=0) {
            phoneValFlag=true;
            HttpSession httpSession = request.getSession(false);
            if (httpSession != null) {
                String smsCode = (String) httpSession.getAttribute("sms_code");
                if (verification(userInput, smsCode)) {
                    codeValFlag=true;
                }else {
                    error= "code_error";
                }
            }
        }else {
            error= "phone_error";
        }

        if (phoneValFlag && codeValFlag) {
            System.out.println("successssss");
            //adding user data to the session here
            HttpSession httpSession =request.getSession(false);

            String name = (String) httpSession.getAttribute("name");
            String mail = (String) httpSession.getAttribute("mail");
            String phone = (String)httpSession.getAttribute("phone");
            String pass = (String)httpSession.getAttribute("pass");

            String birthdate = (String)httpSession.getAttribute("birthdate");
            String job = (String)httpSession.getAttribute("job");
            String creditlimit = (String)httpSession.getAttribute("creditlimit");
            String address = (String)httpSession.getAttribute("address");
            String interests = (String)httpSession.getAttribute("interests");

            String res = SiteDAO.instanceData.checkSignUp(false,name,Date.valueOf(birthdate),pass,Integer.parseInt(phone),job,mail,Integer.parseInt(creditlimit),address,interests);
            if (res.equals("success")){
                httpSession.setAttribute("logged in","true");
                response.sendRedirect("index.jsp");
            }else {
                System.out.println(res);
                error = "register_error";
                response.sendRedirect("login.jsp?" + error);
            }

        }else {
            response.sendRedirect("phoneValidate.jsp?" + error);
        }

    }


      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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