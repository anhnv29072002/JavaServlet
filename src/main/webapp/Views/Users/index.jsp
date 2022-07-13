<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				
				<c:if test="${ empty lstKH }">
					<p class="alert alert-warning">Không có dữ liệu</p>
				</c:if>

				<c:if test="${ !empty lstKH }">
				
					<table class="table table-border table-hover table-tripper">
						<thead>
							<tr>
								<th>Họ tên</th>
								<th>Địa chỉ</th>
								<th>Email</th>
								<th>SĐT</th>
								<th>Vai trò</th>
								<th>Avatar</th>
								<th colspan="2">Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ lstKH }" var="lstKH">
								<tr>
									<td>${ lstKH.hoTen }</td>
									<td>${ lstKH.diaChi }</td>
									<td>${ lstKH.email }</td>
									<td>${ lstKH.sdt }</td>
									<td>
										${ lstKH.vaiTro == 1 ? "Quản lý" : "" }
										${ lstKH.vaiTro == 0 ? "Khách hàng" : "" }
									</td>
									<td>${ lstKH.avatar }</td>
									<td><a class="btn btn-primary" href="/Assigment_SOF3011/QLUser/edit?id=${ lstKH.id }">Cập nhật</a></td>
									<td><button class="btn btn-danger" onclick="deleteUser(${ lstKH.id })">Xóa</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>