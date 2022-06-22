<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.final_project.modules.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.final_project.modules.SiteParser" %>
<%@include file="/header.html" %>
	
	<section id="advertisement">
		<div class="container">
			<img src="/images/shop/advertisement.jpg" alt="" />
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>Category</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<%
								List<String> cat =new ArrayList<>();
								List<Product> product = SiteParser.instanceData.getProducts();
								List<Product> newFeatureProd=new ArrayList<>();
								for (int i=0;i<=8;i++){
									newFeatureProd.add(product.get(i));
								}
//								product.subList(9,product.size()).clear();
								for (Product i : product) {
									if (!cat.contains(i.getCategory())) {
										cat.add(i.getCategory());
									}
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
						</div><!--/category-productsr-->
						
						<div class="price-range"><!--price-range-->
							<h2>Price Range</h2>
							<div class="well">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b>$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div><!--/price-range-->
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">Features Items</h2>
						<%
							List<Product> prod = SiteParser.instanceData.getProducts();
							for (Product i : prod) {
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
						%>
						<ul class="pagination">
							<li class="active"><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">&raquo;</a></li>
						</ul>
					</div><!--features_items-->
				</div>
			</div>
		</div>
	</section>

<%@include file="/footer.html" %>
