<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${ empty lstP }">
	<div class="alert alert-warning">Không có dữ liệu</div>
</c:if>

<c:if test="${ !empty lstP }">
	<c:forEach items="${ lstP }" var="lstP">
		<!--Grid column-->
		<div class="col-lg-3 col-md-6 mb-4">
			<!--Card-->
			<div class="card">

				<!--Card image-->
				<div class="view overlay">
					<img src="/Assigment_SOF3011/image/${ lstP.img }" class="card-img-top"
						alt=""> <a>
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>
				<!--Card image-->
				<!--Card content-->
				<div class="card-body text-center">
					<!--Category & Title-->
					<p class="grey-text">
						<h5>${ lstP.ten }</h5>
					</p>
					<h4 class="font-weight-bold blue-text">
						<strong>${ lstP.donGia }$</strong>
					</h4>
					<h5>
						<strong> 
							<a href="/Assigment_SOF3011/QLProduct/edit?id=${ lstP.id }" class="btn btn-info">Cập nhật</a>
							<button  class="btn btn-danger" onclick="deleteProduct(${ lstP.id })">Xóa</button>
						</strong>
					</h5>
				</div>
				<!--Card content-->
			</div>
			<!--Card-->
		</div>
		<!--Grid column-->
	</c:forEach>
</c:if>