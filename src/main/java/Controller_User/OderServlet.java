package Controller_User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OderBillDao;
import Dao.ProductDao;
import Entities.Oder;
import Entities.OderBill;
import Entities.Product;
import Entities.User;

@WebServlet({ "/OderServlet/home", "/OderServlet/confirm" })
public class OderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderBillDao daoOderBill;
	private ProductDao daoP;

	public OderServlet() {
		super();
		this.daoOderBill = new OderBillDao();
		this.daoP = new ProductDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("home")) {
			this.home(request, response);
		} else if (uri.contains("confirm")) {
			this.confirm(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("oder");
		session.getAttribute("user");
		request.setAttribute("link", "/Views/Users/Cart/xacnhandathang.jsp");
		request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
	}

	private void confirm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			Oder oder = (Oder) session.getAttribute("oder");
			User u = (User) session.getAttribute("user");
			Product p = null;
			int soLuong = 0;
			double donGia = 0;
			for (int i = 0; i < oder.getCart().size(); i++) {
				p = (Product) oder.getCart().get(i).getProduct();
				soLuong += oder.getCart().get(i).getSoLuong();
				donGia = oder.getCart().get(i).getProduct().getDonGia();
			}
			Date date = new Date();
			OderBill oder_bill = new OderBill(p, u, "Waiting", soLuong, donGia, date);
			this.daoOderBill.insert(oder_bill);
			oder.setCart(null);
			session.removeAttribute("oder");
			response.sendRedirect(request.getContextPath() + "/HomeUser?successOderBill=1");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/HomeUser?errorOderBill=1");
			return;
		}
	}

}
