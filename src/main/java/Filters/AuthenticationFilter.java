package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entities.User;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter(
		urlPatterns = {
				"/QLUser/*",
				"/QLCategory/*",
				"/QLProduct/*",
				"/HomeStaff",
				"/Cart/*",
				"/OderServlet/*",
				"/OrderHistory",
				"/QLOder/*"
		}
)
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session =  httpRequest.getSession();
		User u = (User) session.getAttribute("user");
		User staff = (User) session.getAttribute("staff");
		if(u == null && staff == null) {
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/HomeUser?errorNotLogin=1");
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
