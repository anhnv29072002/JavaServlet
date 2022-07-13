<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${ !empty sessionScope.message }">
	<div class="alert alert-success">${ sessionScope.message }</div>
	<c:remove var="message" scope="session" />
</c:if>

<c:if test="${ !empty sessionScope.error }">
	<div class="alert alert-danger">${ sessionScope.error }</div>
	<c:remove var="error" scope="session" />
</c:if>

<div class="card">
	<div class="card-header text-center" style="font-size: larger;">
		Quản lý Oder</div>
	<div class="card-body">
		<c:if test="${ empty lstOB }">
			<div class="alert alert-warning">Không có đơn hàng</div>
		</c:if>
		<c:if test="${ !empty lstOB }">
			<div class="row">
				<table class="table table-bordered table-hover table-striped col-12">
					<thead>
						<tr>
							<th>Tên khách hàng</th>
							<th>Địa chỉ</th>
							<th>SĐT</th>
							<th>Ảnh sản phẩm</th>
							<th>Sản phẩm</th>
							<th>Ngày đặt hàng</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
							<th>Tổng tiền</th>
							<th colspan="2">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lstOB }" var="ds">
							<tr>
								<td>${ ds.user.hoTen }</td>
								<td>${ ds.user.diaChi }</td>
								<td>${ ds.user.sdt }</td>
								<td>
									<img src="/Assigment_SOF3011/image/${ ds.product.img }" width="150px" height="100px">
								</td>
								<td>${ ds.product.ten }</td>
								<td>
									<fmt:formatDate value="${ ds.ngayDat }" pattern="dd/MM/yyyy" />
								</td>
								<td>${ ds.soLuong }</td>
								<td>${ ds.donGia }</td>
								<td>${ ds.donGia * ds.soLuong }</td>
								<td><a class="btn btn-success"
									href="/Assigment_SOF3011/QLOder/confirm?id=${ ds.id }">Xác
										nhận</a></td>
								<td><button class="btn btn-danger"
										onclick="huyDonHang(${ ds.id })">Hủy</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</div>