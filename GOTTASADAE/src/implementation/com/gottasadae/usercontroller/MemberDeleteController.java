package implementation.com.gottasadae.usercontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.com.gottasadae.member.MemberDTO2;
import implementation.com.gottasadae.userdao.MemberDAO;
@WebServlet("/delete")
public class MemberDeleteController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String url = "Main.jsp";

		if (session.getAttribute("sessionID") == null) {

			req.setAttribute("message", "세션이 만료되었습니다.");

		} else {
			url = "mapage.jsp";

		}
		req.getRequestDispatcher(url).forward(req, resp);
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDTO2 DTO = new MemberDTO2();
		HttpSession session = req.getSession();

		DTO = (MemberDTO2) session.getAttribute("sessionID");
		MemberDAO sDao = MemberDAO.getInstance();
		sDao.deleteUser(DTO.getId());

		req.setAttribute("message", "회원탈퇴가 되었습니다.");
		session.invalidate();

		req.getRequestDispatcher("Main.jsp").forward(req, resp);
	}
	
}
