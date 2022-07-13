package Controller_User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.OderBillDao;
import Entities.OderBill;
import Entities.User;

/**
 * Servlet implementation class OrderHistory
 */
@WebServlet("/OrderHistory")
public class OrderHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderBillDao daoOB;
	
    public OrderHistory() {
        super();
        this.daoOB = new OderBillDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		List<OderBill> lstOB = this.daoOB.getByIdAndStatus(u.getId(), "Confirm");
		request.setAttribute("lstOB", lstOB);
		request.setAttribute("link", "/Views/Users/HistoryOder/oderHistory.jsp");
		request.getRequestDispatcher("/Views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
