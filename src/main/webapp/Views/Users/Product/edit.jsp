<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="/Assigment_SOF3011/QLProduct/update?id=${ product.id }" method="post" enctype="multipart/form-data">
	<div class="card">
		<div class="card-header text-center">
			<p style="font-size: x-large;">Quản lý sản phẩm</p>
		</div>
		<div class="card-body">
			<div class="form-group">
				<label for="">Tên sản phẩm</label> <input class="form-control"
					type="text" name="ten" id="" value="${ product.ten }" required>
			</div>
			<div class="form-group">
				<label for="">Tên thể loại</label> <select class="form-control"
					name="category_id">
					<c:forEach items="${ lstC }" var="lstC">
						<option value="${ lstC.id }" ${ lstC.id == product.categoryy.id ? "selected" : "" }>
							${ lstC.ten }
						</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="">Số lượng</label> <input class="form-control"
					type="number" name="soLuong" id="" value="${ product.soLuong }" required>
			</div>
			<div class="form-group">
				<label for="">Đơn giá</label> <input class="form-control"
					type="number" name="donGia" id="" value="${ product.donGia }" required>
			</div>
			<div class="form-group">
				<label for="">Màu sắc</label> 
				<input type="radio" name="mauSac"id="" value="Do" ${ product.mauSac == "Do" ? "checked" : "" }>Đỏ
				<input type="radio" name="mauSac" id="" value="Den" ${ product.mauSac == "Den" ? "checked" : "" }>Đen 
				<input type="radio" name="mauSac" id="" value="Trang" ${ product.mauSac == "Trang" ? "checked" : "" }>Trắng
				<input type="radio" name="mauSac" id="" value="Vang" ${ product.mauSac == "Vang" ? "checked" : "" }>Vàng 
				<input type="radio" name="mauSac" id="" value="Tim" ${ product.mauSac == "Tim" ? "checked" : "" }>Tím 
				<input type="radio" name="mauSac" id="" value="Hong" ${ product.mauSac == "Hong" ? "checked" : "" }>Hồng
			</div>
			<div class="form-group">
				<label for="">Kích thước</label>
				<input type="radio" name="kichThuoc" id="" value="1" ${ product.kichThuoc == 1 ? "checked" : "" }>S
				<input type="radio" name="kichThuoc" id="" value="2" ${ product.kichThuoc == 2 ? "checked" : "" }>M
				<input type="radio" name="kichThuoc" id="" value="3" ${ product.kichThuoc == 3 ? "checked" : "" }>L
				<input type="radio"name="kichThuoc" id="" value="4" ${ product.kichThuoc == 4 ? "checked" : "" }>XL
			</div>
			<div class="form-group">
				<label for="">Hình ảnh</label>
				<input class="form-control" type="file" name="img" id="inputIMG" value="${ product.img }" onchange="return fileValid()" placeholder="Vui lòng chọn hình ảnh">
				<input type="image" src="/Assigment_SOF3011/image/${ product.img }" id="img" width="200px" height="150px">
			</div>
		</div>
		<div class="card-footer text-center">
			<button class="btn btn-info">Sửa</button>
		</div>
	</div>
</form>