var urlName = location.href;

var loginSucces = urlName.search("succesLogin");
var loginError = urlName.search("errorLogin");
var dkSuccess = urlName.search("dkSuccess");
var dkError = urlName.search("dkError");
var LoginStaffSucess = urlName.search("LoginStaffSucess");
var errorNotLogin = urlName.search("errorNotLogin");
var successOderBill = urlName.search("successOderBill");
var errorOderBill = urlName.search("successOderBill");


if(loginSucces > 0){
	alert("Đăng nhập thành công");
}else if(loginError > 0){
    alert("Đăng nhập thất bại mời xem lại mật khẩu");
}else if(dkSuccess > 0){
	alert("Đăng ký thành công");
}else if(dkError > 0){
	alert("Đăng ký thất bại");
}else if(LoginStaffSucess > 0){
	alert("Đăng nhập thành công");
}else if(errorNotLogin > 0){
	alert("Chưa đăng nhập hoặc bạn không phải là quản lý");
}else if(successOderBill > 1){
	alert("Xác nhận thành công và chờ quản lý duyệt đơn hàng của bạn");
}else if(errorOderBill > 1){
	alert("Mua hàng thất bại");
}