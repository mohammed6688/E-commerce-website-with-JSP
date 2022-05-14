<%@ page import="com.twilio.Twilio" %>
<%@ page import="com.twilio.rest.api.v2010.account.Message" %>
<%@ page import="com.twilio.type.PhoneNumber" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.example.final_project.modules.User" %>
<%@ page import="com.example.final_project.modules.SiteParser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation</title>
</head>
<body>
<%!
    public static final String ACCOUNT_SID = "ACceb4ceec732d6b9e1719d2906fc117ae";
    public static final String AUTH_TOKEN = "c43464447ec4552875a574cdf6c870e8";
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

%>
<%
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
            user = SiteParser.instanceData.checkSignIn(email,password);

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

            String res = SiteParser.instanceData.checkSignUp(false,name,Date.valueOf(birthdate),pass,Integer.parseInt(phone),job,mail,Integer.parseInt(creditlimit),address,interests);
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

%>

</body>
</html>