<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include  file="/loginheader.html" %>

<%
    boolean phoneFlag=false, codeFlag=false;
    HttpSession httpSession =request.getSession(false);
    if (httpSession!=null){
        String loginStatus = (String) httpSession.getAttribute("logged in");
        if (loginStatus!=null && loginStatus.equals("true")){
            response.sendRedirect("index.jsp");
        }
    }
    if (request.getParameter("phone_error")!=null){
        System.out.println("user name required");
        phoneFlag=true;
    }else if (request.getParameter("code_error")!=null){
        codeFlag=true;
    }
%>

<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form"><!--login form-->
                    <h2>Verify Phone Number</h2>
                    <form action="validation.jsp">
                        <input type="hidden" name="mode" value="code">
                        <input type="number" name="code" placeholder="SMS code" />
                        <%
                            if (phoneFlag){
                                //logic for viewing error here
                                System.out.println("phone error");
                        %>
                        <%--your phone error label html here--%>
                        <h5 style="color: red;">you entered wrong phone number*</h5>
                        <%
                            }else if (codeFlag){
                                System.out.println("code error");
                        %>
                        <%--your code error label html here--%>
                        <h5 style="color: red;">you entered wrong code*</h5>
                        <%
                            }
                        %>
                        <button type="submit" class="btn btn-default">Verify</button>
                    </form>
                </div><!--/login form-->
            </div>
        </div>
    </div>
</section><!--/form-->

<%@include  file="/footer.html"%>
