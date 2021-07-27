package implementation.com.gottasadae.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class LogoutController extends HttpServlet {


	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		HttpSession session = req.getSession();
		String url = "Main.jsp";
		//로그아웃만 클릭 
		if(action.equals("sessionID")) {
			session.invalidate();
			Cookie[] cookies = req.getCookies();
			if(cookies != null) {
				for(Cookie c : cookies) {
					c.setMaxAge(0);
					resp.addCookie(c);
				}
			}
		}
		req.setAttribute("message", "로그아웃 되었습니다");
		req.getRequestDispatcher(url)
		.forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}
	
}



