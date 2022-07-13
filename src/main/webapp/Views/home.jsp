<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="utf-8">
		<title>Assigment</title>
		<link rel="stylesheet" href="/Assigment_SOF3011/css/bootstrap.min.css">
		<link rel="stylesheet" href="/Assigment_SOF3011/Views/css/home.css">
	</head>

	<body>
		<!-- Navbar -->
		<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark scrolling-navbar">
			<div class="container">
				<!-- Brand -->
				<a class="navbar-brand waves-effect" href="/Assigment_SOF3011/HomeUser">
					<strong class="blue-text">Trang chủ</strong>
				</a>
				<!-- Collapse -->
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- Links -->
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<!-- Left -->
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link waves-effect" href="/Assigment/HomeUser">Giới thiệu</a></li>
						<li class="nav-item active"><a class="nav-link waves-effect" href="/Assigment/HomeUser">Liên hệ</a>
						</li>
						<li class="nav-item active"><a class="nav-link waves-effect" href="/Assigment/HomeUser">Hỏi đáp</a>
						</li>
					</ul>
					<!-- Right -->
					<ul class="navbar-nav nav-flex-icons">
						<c:if test="${ empty sessionScope.user }">
						<button type="button" class="btn btn-info" data-toggle="modal" data-target="#resgister">
							Đăng ký
						</button>
						<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
							Đăng nhập
						</button>
						</c:if>
						<c:if test="${ !empty sessionScope.user }">
								<a class="btn btn-info" href="/Assigment_SOF3011/Cart/home">
									Giỏ hàng
								</a>
								
								<li class="nav-item dropdown">
									<a class="nav-link dropdown-toggle" href="#" id="navba rDropdown" role="button"
										data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										${ user.hoTen }
									</a>
									<div class="dropdown-menu" aria-labelledby="navbarDropdown">
										<a class="dropdown-item" href="#">Đổi mật khẩu</a>
										<a class="dropdown-item" href="#">Cập nhật tài khoản</a>
										<a class="dropdown-item" href="/Assigment_SOF3011/OrderHistory">Lịch sử đặt hàng</a>
										<a type="button" class="dropdown-item" href="/Assigment_SOF3011/Logout">Đăng xuất</a>
										</div>
									</div>
								</li>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
		<!-- Navbar -->

		<!--Carousel Wrapper-->
		<div id="carousel-example-1z" class="carousel slide carousel-fade pt-4" data-ride="carousel">
			<!--Indicators-->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-1z" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-1z" data-slide-to="1"></li>
				<li data-target="#carousel-example-1z" data-slide-to="2"></li>
			</ol>
			<!--/.Indicators-->
			<!--Slides-->
			<div class="carousel-inner" role="listbox">
				<!--First slide-->
				<div class="carousel-item active">
					<div class="view"
						style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%282%29.jpg'); background-repeat: no-repeat; background-size: cover;">

						<!-- Mask & flexbox options-->
						<div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

							<!-- Content -->
							<div class="text-center white-text mx-5 wow fadeIn">
								<h1 class="mb-4">
									<strong>Ken88 SPORT</strong>
								</h1>

								<h1>
									<strong>Ken88 SPORT</strong>
								</h1>

								<p class="mb-4 d-none d-md-block">
									<strong>Chuyên giày thể thao, quần áo thể thao giá rẻ bất ngờ mua ngay kẻo hết.
										Nhiều khuyến mại và ưu đãi bất ngờ cho mọi người</strong>
								</p>
							</div>
							<!-- Content -->

						</div>
						<!-- Mask & flexbox options-->

					</div>
				</div>
				<!--/First slide-->

				<!--Second slide-->
				<div class="carousel-item">
					<div class="view"
						style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%283%29.jpg'); background-repeat: no-repeat; background-size: cover;">

						<!-- Mask & flexbox options-->
						<div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

							<!-- Content -->
							<div class="text-center white-text mx-5 wow fadeIn">
								<h1 class="mb-4">
									<strong>Ken88 SPORT</strong>
								</h1>

								<h1>
									<strong>Ken88 SPORT</strong>
								</h1>

								<p class="mb-4 d-none d-md-block">
									<strong>Chuyên giày thể thao, quần áo thể thao giá rẻ bất ngờ mua ngay kẻo hết.
										Nhiều khuyến mại và ưu đãi bất ngờ cho mọi người</strong>
								</p>
							</div>
							<!-- Content -->

						</div>
						<!-- Mask & flexbox options-->

					</div>
				</div>
				<!--/Second slide-->

				<!--Third slide-->
				<div class="carousel-item">
					<div class="view"
						style="background-image: url('https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/8-col/img%285%29.jpg'); background-repeat: no-repeat; background-size: cover;">

						<!-- Mask & flexbox options-->
						<div class="mask rgba-black-strong d-flex justify-content-center align-items-center">

							<!-- Content -->
							<div class="text-center white-text mx-5 wow fadeIn">
								<h1 class="mb-4">
									<strong>Ken88 SPORT</strong>
								</h1>

								<h1>
									<strong>Ken88 SPORT</strong>
								</h1>

								<p class="mb-4 d-none d-md-block">
									<strong>Chuyên giày thể thao, quần áo thể thao giá rẻ bất ngờ mua ngay kẻo hết.
										Nhiều khuyến mại và ưu đãi bất ngờ cho mọi người</strong>
								</p>
							</div>
							<!-- Content -->

						</div>
						<!-- Mask & flexbox options-->

					</div>
				</div>
				<!--/Third slide-->

			</div>
			<!--/.Slides-->

			<!--Controls-->
			<a class="carousel-control-prev" href="#carousel-example-1z" role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carousel-example-1z" role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
			<!--/.Controls-->

		</div>
		<!--/.Carousel Wrapper-->

		<!--Main layout-->
		<main>
			<div class="container">
				<!--Navbar-->
				<nav class="navbar navbar-expand-lg navbar-dark bg-dark mdb-color lighten-3 mt-3 mb-5">

					<!-- Navbar brand -->
					<span class="navbar-brand">Thể Loại:</span>

					<!-- Collapse button -->
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
						aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<!-- Collapsible content -->
					<div class="collapse navbar-collapse" id="basicExampleNav">
						<!-- Links -->
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Tất cả</a></li>
							<li class="nav-item active"><a class="nav-link" href="#">Áo</a></li>
							<li class="nav-item active"><a class="nav-link" href="#">Quần</a></li>
							<li class="nav-item active"><a class="nav-link" href="#">Giày</a></li>
						</ul>
						<!-- Links -->
					</div>
					<!-- Collapsible content -->

				</nav>
				<!--/.Navbar-->
				
				<section class="col-12">
					<jsp:include page="${ link }"></jsp:include>
				</section>
				<!--Section: Products v.3-->
				<section class="text-center mb-4">
					<!--Grid row-->
					<div class="row wow fadeIn">
							<jsp:include page="${ view }"></jsp:include>
					</div>
					<!--Grid row-->
				</section>
				<!--Section: Products v.3-->

				<!--Pagination-->
				<nav class="d-flex justify-content-center wow fadeIn">
					<ul class="pagination pg-blue">
						<!--Arrow left-->
						<li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
							</a></li>

						<li class="page-item active"><a class="page-link" href="#">1
								<span class="sr-only">(current)</span>
							</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>

						<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span
									aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
							</a></li>
					</ul>
				</nav>
				<!--Pagination-->

			</div>
		</main>
		<!--Main layout-->

		<!--Modal Login-->
		<jsp:include page="login.jsp"></jsp:include>
		<!--Modal Register-->
		<jsp:include page="register.jsp"></jsp:include>

		<!--Footer-->
		<footer class="page-footer text-center font-small mt-4 wow fadeIn">
			<!--Copyright-->
			<div class="footer-copyright py-3 text-center">
				© Nguyễn Việt Anh ©
			</div>
			<!--/.Copyright-->
		</footer>
		<!--/.Footer-->

		<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="./Views/js/checkLoginError.js"></script>
	</body>

	</html>