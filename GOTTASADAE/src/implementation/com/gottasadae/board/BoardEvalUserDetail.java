package implementation.com.gottasadae.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boardservice.EvalBoardService;
import implementation.com.gottasadae.member.MemberDTO2;

@WebServlet("/BoardEvalUserDetail")
public class BoardEvalUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardEvalUserDetail() {
		
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
		String id = req.getParameter("eval_id");
		EvalBoardService service = new EvalBoardService();
		
		MemberDTO2 memberList = service.BoardEvalUserDetail(id);
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		req.setAttribute("memberList", memberList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("user_detail.jsp");
		dispatcher.forward(req, resp);
	}
}
