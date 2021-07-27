package implementation.com.gottasadae.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.com.gottasadae.boarddto.EvalBoardDTO;
import implementation.com.gottasadae.boardservice.EvalBoardService;

@WebServlet("/BoardEvalModifyView")
public class BoardEvalModifyView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardEvalModifyView() {
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
		EvalBoardService service = new EvalBoardService();
		HttpSession session = req.getSession();
		String eval_num = req.getParameter("eval_num");
		System.out.println(eval_num);
		
		EvalBoardDTO evalBoardList = service.BoardEvalModifyView(eval_num);
		
		req.setAttribute("boardList", evalBoardList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("board_eval_modify.jsp");
		dispatcher.forward(req, resp);
	}
}
