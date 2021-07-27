package implementation.com.gottasadae.board;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boardservice.FreeBoardService;
import implementation.com.gottasadae.member.MemberDTO2;

@WebServlet("/BoardFreetalkUserDetail")
public class BoardFreetalkUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public BoardFreetalkUserDetail() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("free_id");
		FreeBoardService service = new FreeBoardService();
		
		MemberDTO2 memberList = service.BoardFreetalkUserDetail(id);
		
		resp.setContentType("text/html; charset=UTF-8;");
		
		
		req.setAttribute("memberList", memberList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user_detail.jsp");
		dispatcher.forward(req, resp);
	}
}
