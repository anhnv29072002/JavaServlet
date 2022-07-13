<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				
				<c:if test="${ empty lstC }">
					<p class="alert alert-warning">Không có dữ liệu</p>
				</c:if>

				<c:if test="${ !empty lstC }">
				
					<table class="table table-border table-hover table-tripper">
						<thead>
							<tr>
								<th>Tên thể loại</th>
								<th>Tên người tạo</th>
								<th colspan="2">Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ lstC }" var="lstC">
								<tr>
									<td>${ lstC.ten }</td>
									<td>${ lstC.user.hoTen }</td>
									<td><a class="btn btn-primary" href="/Assigment_SOF3011/QLCategory/edit?id=${ lstC.id }">Cập nhật</a></td>
									<td><button class="btn btn-danger" onclick="deleteCate(${ lstC.id })">Xóa</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>