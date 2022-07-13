<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
		<c:if test="${ !empty sessionScope.message }">
			<div class="alert alert-success">${ sessionScope.message }</div>
			<c:remove var="message" scope="session" />
		</c:if>

		<c:if test="${ !empty sessionScope.error }">
			<div class="alert alert-warning">${ sessionScope.error }</div>
			<c:remove var="error" scope="session" />
		</c:if>
		
				<form action="/Assigment_SOF3011/QLCategory/store" method="post">
					<div class="card">
						<div class="card-header text-center">
							<p style="font-size: x-large;">Quản lý Thể Loại</p>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="">Tên thể loại</label> 
								<input class="form-control" type="text" name="ten" id="" required>
							</div>
							<div class="form-group">
								<label for="">Tên người tạo</label>
								<select class="form-control" name="user_id">
								<c:forEach items="${ lstKH }" var="lstKH">
									<c:if test="${ lstKH.vaiTro == 1 }">
										<option value="${ lstKH.id }">
											${ lstKH.hoTen }
										</option>
									</c:if>
								</c:forEach>
								</select>
							</div>
						</div>
						<div class="card-footer text-center">
							<button class="btn btn-success">Thêm</button>
						</div>
					</div>
				</form>