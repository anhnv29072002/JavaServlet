<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card-header text-center" style="font-size: larger;">
	Xác nhận đơn hàng</div>
<div class="card-body">
	<div class="row">
		<table class="table table-bordered table-hover table-striped col-12">
			<thead>
				<tr>
					<th>Tên khách hàng</th>
					<th>Địa chỉ</th>
					<th>SĐT</th>
					<th>Hình ảnh</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${ sessionScope.user.hoTen }</td>
					<td>${ sessionScope.user.diaChi }</td>
					<td>${ sessionScope.user.sdt }</td>
					<td><img
						src="/Assigment_SOF3011/image/${ sessionScope.user.avatar }"
						width="250px" height="100px"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="row">
		<table class="table table-bordered table-hover table-striped col-12">
			<thead>
				<tr>
					<th>Ảnh sản phẩm</th>
					<th>Tên sản phẩm</th>
					<th>Đơn giá</th>
					<th>Số lượng</th>
					<th>Thành tiền</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ sessionScope.oder.cart }" var="cart">
					<tr>
						<td><img src="/Assigment_SOF3011/image/${ cart.product.img }"
							width="250px" height="100px"></td>
						<td>${ cart.product.ten }</td>
						<td>${ cart.product.donGia }</td>
						<td>${ cart.soLuong }</td>
						<td>${ sessionScope.oder.getSumMoney() }</td>
					</tr>
			</tbody>
			</c:forEach>
		</table>
	</div>
</div>
<div class="card-footer text-right">
	<p>Tổng tiền hàng: ${ sessionScope.oder.getSumMoney() }$</p>
	<a class="btn btn-success"
		href="/Assigment_SOF3011/OderServlet/confirm">Xác nhận thanh toán</a>
</div>