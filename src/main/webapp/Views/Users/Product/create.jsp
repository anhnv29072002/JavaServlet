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
		
				<form action="/Assigment_SOF3011/QLProduct/store" method="post" enctype="multipart/form-data" >
					<div class="card">
						<div class="card-header text-center">
							<p style="font-size: x-large;">Quản lý sản phẩm</p>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="">Tên sản phẩm</label> 
								<input class="form-control" type="text" name="ten" id="" required>
							</div>
							<div class="form-group">
								<label for="">Tên thể loại</label> 
								<select class="form-control" name="category_id">
									<c:forEach items="${ lstC }" var="lstC" >
										<option value="${ lstC.id }">${ lstC.ten }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label for="">Số lượng</label> 
								<input class="form-control" type="number" name="soLuong" id="" required>
							</div>
							<div class="form-group">
								<label for="">Đơn giá</label>
								<input class="form-control" type="number" name="donGia" id="" required>
							</div>
							<div class="form-group">
								<label for="">Màu sắc</label> 
								<input type="radio" name="mauSac" id="" value="Do">Đỏ
                        		<input type="radio" name="mauSac" id="" value="Den">Đen
                        		<input type="radio" name="mauSac" id=""value="Trang">Trắng
                        		<input type="radio" name="mauSac" id=""value="Vang">Vàng
                        		<input type="radio" name="mauSac" id=""value="Tim">Tím
                        		<input type="radio" name="mauSac" id=""value="Hong">Hồng
							</div>
							<div class="form-group">
								<label for="">Kích thước</label> 
								<input type="radio" name="kichThuoc" id="" value="1">S
                        		<input type="radio" name="kichThuoc" id="" value="2">M
                        		<input type="radio" name="kichThuoc" id="" value="3">L
                        		<input type="radio" name="kichThuoc" id="" value="4">XL
							</div>
							<div class="form-group">
								<label for="">Hình ảnh</label> 
								<input class="form-control" type="file" name="img" id="inputIMG" placeholder="Vui lòng chọn hình ảnh">
							</div>
						</div>
						<div class="card-footer text-center">
							<button class="btn btn-success">Thêm</button>
						</div>
					</div>
				</form>