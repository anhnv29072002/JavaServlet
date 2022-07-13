package Controller_Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProductDao;
import Entities.Product;

/**
 * Servlet implementation class HomeStaff
 */
@WebServlet("/HomeStaff")
public class HomeStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDao daoP;
    
    public HomeStaff() {
        super();
        this.daoP = new ProductDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> lstP = this.daoP.getAll();
		request.setAttribute("lstP", lstP);
		request.setAttribute("load", "/Views/Staff/loadAll.jsp");
		request.getRequestDispatcher("/Views/Staff/homeStaff.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
