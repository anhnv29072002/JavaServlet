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

				<form action="/Assigment_SOF3011/QLUser/store" method="post" enctype="multipart/form-data">
					<div class="card">
						<div class="card-header text-center">
							<p style="font-size: x-large;">Quản lý User</p>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="">Họ Tên</label> 
								<input class="form-control" type="text" name="hoTen" id="" required>
							</div>
							<div class="form-group">
								<label for="">Địa chỉ</label> 
								<input class="form-control" type="text" name="diaChi"  required>
							</div>
							<div class="form-group">
								<label for="">Email</label> 
								<input class="form-control" type="email" name="email" id="" required>
							</div>
							<div class="form-group">
								<label for="">Mật khẩu</label> 
								<input class="form-control" type="password" name="password" id="" required>
							</div>
							<div class="form-group">
								<label for="">SĐT</label>
								<input class="form-control" type="number" name="sdt" id="" required>
							</div>
							<div class="form-group">
								<label for="">Vai Trò: </label>
								<input type="radio" name="vaiTro" id="" value="1">Quản lý
								<input type="radio" name="vaiTro" id="" value="0">Khách hàng
							</div>
							<div class="form-group">
								<label for="">Avatar</label> <input class="form-control" type="file" name="avatar" id=""
									placeholder="Vui lòng chọn Avatar">
							</div>
						</div>
						<div class="card-footer text-center">
							<button class="btn btn-success">Thêm</button>
						</div>
					</div>
				</form>