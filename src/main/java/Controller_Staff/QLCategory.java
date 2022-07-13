package Controller_Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CategoryDao;
import Dao.UserDao;
import Entities.Category;
import Entities.User;

/**
 * Servlet implementation class QLCategory
 */
@WebServlet({ "/QLCategory/index", "/QLCategory/store", "/QLCategory/edit", "/QLCategory/update",
		"/QLCategory/delete", })
public class QLCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao cateDao;
	private UserDao userDao;
	
	public QLCategory() {
		super();
		this.cateDao = new CategoryDao();
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("index")) {
			this.index(request, response);
		} else if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("store")) {
			this.store(request, response);
		} else if (uri.contains("update")) {
			this.update(request, response);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> lstC = this.cateDao.getAll();
		List<User> lstKH = this.userDao.getAll();
		request.setAttribute("lstC", lstC);
		request.setAttribute("lstKH", lstKH);
		request.setAttribute("view", "/Views/Users/Category/create.jsp");
		request.setAttribute("table", "/Views/Users/Category/index.jsp");
		request.getRequestDispatcher("/Views/Staff/homeStaff.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> lstC = this.cateDao.getAll();
		List<User> lstKH = this.userDao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		Category c = this.cateDao.findById(id);
		request.setAttribute("cate", c);
		request.setAttribute("lstC", lstC);
		request.setAttribute("lstKH", lstKH);
		request.setAttribute("view", "/Views/Users/Category/edit.jsp");
		request.setAttribute("table", "/Views/Users/Category/index.jsp");
		request.getRequestDispatcher("/Views/Staff/homeStaff.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Category c = this.cateDao.findById(id);
		try {
			session.setAttribute("message", "Xóa thành công");
			this.cateDao.deleteById(c.getId());
			response.sendRedirect(request.getContextPath() + "/QLCategory/index");
		} catch (Exception e) {
			session.setAttribute("error", "Xóa thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLCategory/index");
		}
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String ten = request.getParameter("ten");
		int userId = Integer.parseInt(request.getParameter("user_id"));
		User u = this.userDao.findById(userId);
		Category c = new Category();
		c.setTen(ten);
		c.setUser(u);
		try {
			session.setAttribute("message", "Thêm thành công");
			this.cateDao.insert(c);
			response.sendRedirect(request.getContextPath() + "/QLCategory/index");
		} catch (Exception e) {
			session.setAttribute("error", "Thêm thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLCategory/index");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Category c = this.cateDao.findById(id);
		String ten = request.getParameter("ten");
		int userId = Integer.parseInt(request.getParameter("user_id"));
		User u = this.userDao.findById(userId);
		c.setTen(ten);
		c.setUser(u);
		try {
			session.setAttribute("message", "Sửa thành công");
			this.cateDao.update(c);
			response.sendRedirect(request.getContextPath() + "/QLCategory/index");
		} catch (Exception e) {
			session.setAttribute("error", "Sửa thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLCategory/index");
		}
	}

}
