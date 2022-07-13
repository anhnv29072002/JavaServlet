<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>

	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				
				<c:if test="${ empty lstP }">
					<p class="alert alert-warning">Không có dữ liệu</p>
				</c:if>

				<c:if test="${ !empty lstP }">
				
					<table class="table table-border table-hover table-tripper">
						<thead>
							<tr>
								<th>Tên sản phẩm</th>
								<th>Tên thể loại</th>
								<th>Số lượng</th>
								<th>Đơn giá</th>
								<th>Màu sắc</th>
								<th>Kích thước</th>
								<th>Hình ảnh</th>
								<th colspan="2">Thao tác</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ lstP }" var="lstP">
								<tr>
									<td>${ lstP.ten }</td>
									<td>${ lstP.categoryy.ten }</td>
									<td>${ lstP.soLuong }</td>
									<td>${ lstP.donGia }</td>
									<td>
										${ lstP.mauSac == "Do" ? "Đỏ" : ""}
										${ lstP.mauSac == "Den" ? "Đen" : ""}
										${ lstP.mauSac == "Trang" ? "Trắng" : ""}
										${ lstP.mauSac == "Vang" ? "Vàng" : ""}
										${ lstP.mauSac == "Tim" ? "Tím" : ""}
										${ lstP.mauSac == "Hong" ? "Hồng" : ""}
									</td>
									<td>
										${ lstP.kichThuoc == 1 ? "S" : ""}
										${ lstP.kichThuoc == 2 ? "M" : ""}
										${ lstP.kichThuoc == 3 ? "L" : ""}
										${ lstP.kichThuoc == 4 ? "XL" : ""}
									</td>
									<td>${ lstP.img }</td>
									<td><a class="btn btn-primary" href="/Assigment_SOF3011/QLProduct/edit?id=${ lstP.id }">Cập nhật</a></td>
									<td><button class="btn btn-danger" onclick="deleteProduct(${ lstP.id })">Xóa</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>