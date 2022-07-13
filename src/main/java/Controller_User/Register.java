package Controller_User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import Dao.UserDao;
import Entities.User;
import Utils.EncryptUtils;
import Utils.JpaUtils;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDao userDao;
	
    public Register() {
        super();
        this.userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User u = new User();
		try {
			BeanUtils.populate(u, request.getParameterMap());
			String ecrypted = EncryptUtils.encrypt(request.getParameter("password"));
			u.setPassword(ecrypted);
			u.setVaiTro(0);
			this.userDao.insert(u);
			response.sendRedirect(request.getContextPath() + "/HomeUser?dkSuccess=1");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/HomeUser?dkError=1");
		}
	}

}
