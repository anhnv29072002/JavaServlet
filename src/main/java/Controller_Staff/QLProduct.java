package Controller_Staff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import Dao.CategoryDao;
import Dao.ProductDao;
import Entities.Category;
import Entities.Product;

/**
 * Servlet implementation class QLProduct
 */
@MultipartConfig
@WebServlet({ "/QLProduct/index", "/QLProduct/store", "/QLProduct/edit", "/QLProduct/update", "/QLProduct/delete" })
public class QLProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private CategoryDao cateDao;

	public QLProduct() {
		super();
		this.cateDao = new CategoryDao();
		this.productDao = new ProductDao();
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
		List<Product> lstP = this.productDao.getAll();
		List<Category> lstC = this.cateDao.getAll();
		request.setAttribute("lstP", lstP);
		request.setAttribute("lstC", lstC);
		request.setAttribute("view", "/Views/Users/Product/create.jsp");
		request.setAttribute("table", "/Views/Users/Product/index.jsp");
		request.getRequestDispatcher("/Views/Staff/homeStaff.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> lstP = this.productDao.getAll();
		List<Category> lstC = this.cateDao.getAll();
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = this.productDao.findById(id);
		request.setAttribute("product", p);
		request.setAttribute("lstP", lstP);
		request.setAttribute("lstC", lstC);
		request.setAttribute("view", "/Views/Users/Product/edit.jsp");
		request.setAttribute("table", "/Views/Users/Product/index.jsp");
		request.getRequestDispatcher("/Views/Staff/homeStaff.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Product p = this.productDao.findById(id);
		try {
			session.setAttribute("message", "Xóa thành công");
			this.productDao.deleteById(p.getId());
			response.sendRedirect(request.getContextPath() + "/QLProduct/index");
		} catch (Exception e) {
			session.setAttribute("error", "Xóa thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLProduct/index");
		}
	}

	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		Product p = new Product();
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		Category c = this.cateDao.findById(category_id);
		try {
			BeanUtils.populate(p, request.getParameterMap());
			String realpath = request.getServletContext().getRealPath("/image");
			Path path = Paths.get(realpath);
			if (!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("img");
			String fileUpLoad = part.getSubmittedFileName();
			if (!"".equals(fileUpLoad)) {
				String img = Path.of(fileUpLoad).getFileName().toString();
				part.write(Paths.get(realpath.toString(), img).toString());
				p.setImg(img);
			}
			p.setCategoryy(c);
			session.setAttribute("message", "Thêm thành công");
			this.productDao.insert(p);
			response.sendRedirect(request.getContextPath() + "/QLProduct/index");
		} catch (Exception e) {
			session.setAttribute("error", "Thêm thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLProduct/index");
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		int category_id = Integer.parseInt(request.getParameter("category_id"));
		Product p = this.productDao.findById(id);
		Category c = this.cateDao.findById(category_id);
		try {
			BeanUtils.populate(p, request.getParameterMap());
			String realpath = request.getServletContext().getRealPath("/image");
			Path path = Paths.get(realpath);
			if (!Files.exists(path)) {
				Files.createDirectory(path);
			}
			Part part = request.getPart("img");
			String fileUpLoad = part.getSubmittedFileName();
			if (!"".equals(fileUpLoad)) {
				String img = Path.of(fileUpLoad).getFileName().toString();
				part.write(Paths.get(realpath.toString(), img).toString());
				p.setImg(img);
			}
			p.setCategoryy(c);
			session.setAttribute("message", "Sửa thành công");
			this.productDao.update(p);
			response.sendRedirect(request.getContextPath() + "/QLProduct/index");
		} catch (Exception e) {
			session.setAttribute("error", "Sửa thất bại");
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/QLProduct/index");
		}
	}

}
