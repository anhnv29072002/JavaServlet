package Controller_User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Dao.ProductDao;
import Entities.Oder;
import Entities.Product;
import Entities.Cart;

/**
 * Servlet implementation class Cart
 */
@WebServlet({ "/Cart/home", "/Cart/add", "/Cart/update", "/Cart/delete" })
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao daoP;
	private CartDao daoCart;

	public CartServlet() {
		super();
		this.daoP = new ProductDao();
		this.daoCart = new CartDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("home")) {
			this.home(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}else if (uri.contains("add")) {
			this.add(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("update")) {
			this.update(request, response);
		} 
	}

	private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Oder oder = (Oder) session.getAttribute("oder");
		session.setAttribute("oder", oder);
		request.setAttribute("link", "/Views/Users/Cart/giohang.jsp");
		request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id;
		int soLuong = 1;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
			Product p = this.daoP.findById(id);
			if (p != null) {
				if (request.getParameter("soLuong") != null) {
					soLuong = Integer.parseInt(request.getParameter("soLuong"));
				}
				if (session.getAttribute("oder") == null) {
					Oder oder = new Oder();
					Cart c = new Cart();
					c.setSoLuong(soLuong);
					c.setProduct(p);
					this.daoCart.insert(c);
					oder.setCart(this.daoCart.getAll());
					session.setAttribute("oder", oder);
				} else {
					Oder oder = (Oder) session.getAttribute("oder");
					this.daoCart.setLstCart(oder.getCart());
					boolean check = false;
					for (Cart cart : this.daoCart.getAll()) {
						if (cart.getProduct().getId() == p.getId()) {
							cart.setSoLuong(cart.getSoLuong() + soLuong);
							check = true;
						}
					}
					if (check == false) {
						Cart c1 = new Cart();
						c1.setSoLuong(soLuong);
						c1.setProduct(p);
						this.daoCart.insert(c1);
					}
					session.setAttribute("oder", oder);
				}
			}
			response.sendRedirect(request.getContextPath() + "/HomeUser");
		} else {
			response.sendRedirect(request.getContextPath() + "/HomeUser");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = this.daoP.findById(id);
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		Cart cart = this.daoCart.findById(p);
		cart.setSoLuong(soLuong);
		this.daoCart.update(cart);
		response.sendRedirect(request.getContextPath() + "/Cart/home");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = this.daoP.findById(id);
		Cart cart = this.daoCart.findById(p);
		this.daoCart.delete(p);
		response.sendRedirect(request.getContextPath() + "/Cart/home");
	}

}
