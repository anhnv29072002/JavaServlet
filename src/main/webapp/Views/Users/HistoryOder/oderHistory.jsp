<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="card">
	<div class="card-header text-center" style="font-size: larger;">
		Lịch sử đặt hàng
	</div>
	<div class="card-body">
		<c:if test="${ empty lstOB }">
			<div class="alert alert-warning">Bạn chưa đặt đơn nào hãy đặt đi</div>
		</c:if>
		<c:if test="${ !empty lstOB }">
			<div class="row">
				<table class="table table-bordered table-hover table-striped col-12">
					<thead>
						<tr>
							<th>Ảnh sản phẩm</th>
							<th>Sản phẩm</th>
							<th>Ngày đặt hàng</th>
							<th>Số lượng</th>
							<th>Đơn giá</th>
							<th>Tổng tiền</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ lstOB }" var="ds">
							<tr>
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
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</div>