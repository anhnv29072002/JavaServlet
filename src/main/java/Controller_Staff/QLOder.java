package Controller_Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OderBillDao;
import Dao.ProductDao;
import Dao.UserDao;
import Entities.OderBill;
import Entities.Product;
import Entities.User;

/**
 * Servlet implementation class QLOder
 */
@WebServlet({ "/QLOder/home", "/QLOder/confirm", "/QLOder/cancel" })
public class QLOder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderBillDao daoOB;
	private UserDao daoUser;
	private ProductDao daoP;

	public QLOder() {
		super();
		this.daoOB = new OderBillDao();
		this.daoUser = new UserDao();
		this.daoP = new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("home")) {
			this.home(request, response);
		} else if (uri.contains("confirm")) {
			this.confirm(request, response);
		} else if (uri.contains("cancel")) {
			this.cancel(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OderBill> lstOB = this.daoOB.getByStatus("Waiting");
		request.setAttribute("lstOB", lstOB);
		request.setAttribute("view", "/Views/Staff/QLOder/qloder.jsp");
		request.setAttribute("view", "/Views/Staff/QLOder/qloder.jsp");
		request.getRequestDispatcher("/Views/Staff/homeStaff.jsp").forward(request, response);
	}

	private void confirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		OderBill ob = this.daoOB.findById(id);
		User u = this.daoUser.findById(ob.getUser().getId());
		Product p = this.daoP.findById(ob.getProduct().getId());
		int soLuong = ob.getSoLuong();
		double donGia = ob.getDonGia();
		ob.setUser(u);
		ob.setProduct(p);
		ob.setSoLuong(soLuong);
		ob.setDonGia(donGia);
		ob.setStatus("Confirm");
		try {
			session.setAttribute("message", "Xác nhận thành công");
			this.daoOB.update(ob);
			response.sendRedirect(request.getContextPath() + "/QLOder/home");
		} catch (Exception e) {
			session.setAttribute("error", "Xác nhận thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLOder/home");
		}
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		OderBill ob = this.daoOB.findById(id);
		User u = this.daoUser.findById(ob.getUser().getId());
		Product p = this.daoP.findById(ob.getProduct().getId());
		int soLuong = ob.getSoLuong();
		double donGia = ob.getDonGia();
		ob.setUser(u);
		ob.setProduct(p);
		ob.setSoLuong(soLuong);
		ob.setDonGia(donGia);
		ob.setStatus("Cancel");
		try {
			session.setAttribute("message", "Hủy thành công");
			this.daoOB.update(ob);
			response.sendRedirect(request.getContextPath() + "/QLOder/home");
		} catch (Exception e) {
			session.setAttribute("error", "Hủy thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLOder/home");
		}
	}
}
