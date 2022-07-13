package Controller_User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Entities.User;
import Utils.EncryptUtils;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public Login() {
		super();
		this.userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		User u = this.userDao.findByEmail(email);
		HttpSession session = request.getSession();
		boolean checkUser = EncryptUtils.check(pass, u.getPassword());
		if (checkUser == true) {
			if (u.getVaiTro() == 0) {
				session.setAttribute("user", u);
				response.sendRedirect(request.getContextPath() + "/HomeUser?succesLogin=1");
			} else if (u.getVaiTro() == 1) {
				session.setAttribute("staff", u);
				response.sendRedirect(request.getContextPath() + "/HomeStaff?LoginStaffSucess=1");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/HomeUser?errorLogin=1");
			return;
		}
	}

}
