<%@ page import="com.example.final_project.modules.SiteDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.final_project.modules.Product" %>
<%@include  file="/loginheader.html" %>


<%
    boolean isEditable = false;
    Product product = null;
    String mode = request.getParameter("mode");
    if (mode != null && mode.equals("edit")) {
        String id = request.getParameter("id");
        isEditable = true;
        try {
            product = SiteDAO.instanceData.getProduct(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }else if (mode != null && mode.equals("add")){
        String title=request.getParameter("Title");
        int Price= Integer.parseInt(request.getParameter("Price"));
        int Quantity= Integer.parseInt(request.getParameter("Quantity"));
        String photoUrl=request.getParameter("photoUrl");
        String details=request.getParameter("details");
        String category=request.getParameter("category");
        try {
            int value =SiteDAO.instanceData.AddProduct(title,Price,Quantity,photoUrl,details,category);
            if (value==1){

            }else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

%>
<section id="form"><!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div class="signup-form"><!--sign up form-->
                    <h2>Add New Product</h2>
                    <form action="addProduct.jsp" method="post">
                        <%
                            if(isEditable){
                        %>
                        <input type="hidden" name="mode" value="edit">
                        <label for="Title">Title</label>
                        <input id="Title" type="text" name="Title" placeholder="Title" disabled="disabled"/>
                        <input type="hidden" name="id" placeholder="id" value="<%=product.getId()%>"/>
                        <label for="price">Price</label>
                        <input id="price" type="number" name="Price" placeholder="Price" value="<%=product.getPrice()%>"/>
                        <label for="quantity">Quantity</label>
                        <input id="quantity" type="number" name="Quantity" placeholder="Quantity" value="<%=product.getQuantity()%>"/>
                        <label for="url">Url</label>
                        <input id="url" type="url" name="photoUrl" placeholder="photoUrl" disabled="disabled" value="<%=product.getPhotoUrl()%>"/>
                        <label for="details">Details</label>
                        <input id="details" type="text" name="details" placeholder="details" disabled="disabled" value="<%=product.getDetails()%>"/>
                        <label for="category">Category</label>
                        <input id="category" type="text" name="category" placeholder="category" disabled="disabled" value="<%=product.getCategory()%>"/>
                        <%
                            }else {
                        %>
                        <input type="hidden" name="mode" value="add">
                        <label for="Title">Title</label>
                        <input id="Title" type="text" name="Title" placeholder="Title"/>
                        <label for="price">Price</label>
                        <input id="price" type="number" name="Price" placeholder="Price"/>
                        <label for="quantity">Quantity</label>
                        <input id="quantity" type="number" name="Quantity" placeholder="Quantity"/>
                        <label for="url">Url</label>
                        <input id="url" type="url" name="photoUrl" placeholder="photoUrl"/>
                        <label for="details">Details</label>
                        <input id="details" type="text" name="details" placeholder="details"/>
                        <label for="category">Category</label>
                        <input id="category" type="text" name="category" placeholder="category"/>
                        <%
                            }
                        %>
                        <button type="submit" class="btn btn-default">Add</button>
                    </form>
                </div><!--/sign up form-->
            </div>
        </div>
    </div>
</section>
<!--/form-->

<%@include  file="/footer.html" %>