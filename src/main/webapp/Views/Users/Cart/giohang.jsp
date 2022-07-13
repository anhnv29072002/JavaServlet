<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<div class="card">
			<div class="card-header text-center" style="font-size: larger;">
				Giỏ hàng
			</div>
			<div class="card-body">
					<table class="table table-bordered table-striped table-hover">
						<thead>
							<tr>
								<th>Hình ảnh</th>
								<th>Tên sản phẩm</th>
								<th>Đơn giá</th>
								<th>Số lượng</th>
								<th>Thành tiền</th>
								<th colspan="2">Thao Tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ sessionScope.oder.cart }" var="cart">
									<tr>
										<td><img src="/Assigment_SOF3011/image/${ cart.product.img }" width="50px"
												height="50px"></td>
										<td>${ cart.product.ten }</td>
										<td>${ cart.product.donGia }$</td>
										<form action="/Assigment_SOF3011/Cart/update?id=${ cart.product.id }" method="post">
										<td>
											<input type="number" name="soLuong" value="${ cart.soLuong }" id="">
										</td>
										<td>${ cart.product.donGia * cart.soLuong }$</td>
										<td><button class="btn btn-info">Sửa</button></td>
										</form>
										<td><a href="/Assigment_SOF3011/Cart/delete?id=${ cart.product.id }" class="btn btn-danger">Xóa</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
			<div class="card-footer text-center">
				<p style="font-size: large;">Tổng tiền: ${ sessionScope.oder.getSumMoney() }$</p>
				<a class="btn btn-primary" href="/Assigment_SOF3011/OderServlet/home" >Thanh toán</a>
			</div>
		</div>