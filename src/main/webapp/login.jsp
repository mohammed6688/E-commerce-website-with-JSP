<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include  file="/header.html" %>

<%
	boolean loginFlag=false;

	HttpSession httpSession =request.getSession(false);
	if (httpSession!=null){
		String loginStatus = (String) httpSession.getAttribute("logged in");
		if (loginStatus!=null && loginStatus.equals("true")){
			response.sendRedirect("index.jsp");
		}
	}

	if (request.getParameter("login_error")!=null){
		System.out.println("auth failed");
		loginFlag=true;
	}
%>

	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<form action="validation.jsp?mode=signin">
							<input type="hidden" name="mode" value="signin"/>
							<input type="email" name="email" placeholder="Email Address"/>
							<input type="password" name="pass" placeholder="Password"/>
							<%
								if (loginFlag){
									//logic for viewing error here
									System.out.println("phone error");
							%>
							<h5 style="color: red;">Authentication failed*</h5>
							<%
								}
							%>
<%--							<span>--%>
<%--								<input type="checkbox" class="checkbox"> --%>
<%--								Keep me signed in--%>
<%--							</span>--%>
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
						<form action="validation.jsp?mode=signup">
							<input type="hidden" name="mode" value="signup">
							<input type="text" name="username" placeholder="Name"/>
							<input type="email" name="email" placeholder="Email Address"/>
							<input type="password" name="pass" placeholder="Password"/>
							<input type="number" placeholder="Phone Number"  name="phone"/>
							<input type="date" placeholder="Birth Day" name="BirthDay"/>
							<input type="text" placeholder="Job" name="job"/>
							<input type="number" placeholder="Credit limi" name="creditLimit"/>
							<input type="text" placeholder="Address" name="address"/>
							<input type="text" placeholder="Interests" name="interests"/>

							<button type="submit" class="btn btn-default">Signup</button>
						</form>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->

<%@include  file="/footer.html"%>
