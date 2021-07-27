package implementation.com.gottasadae.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boarddto.EvalBoardDTO;
import implementation.com.gottasadae.boardservice.EvalBoardService;

@WebServlet("/BoardEvalContents")
public class BoardEvalContents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardEvalContents() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		int eval_num = Integer.parseInt(req.getParameter("eval_num"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		System.out.println("넘겨받은 게시글 번호 : " + eval_num);
		
		EvalBoardService service = new EvalBoardService();
		
		int hitResult = service.evalBoardHit(eval_num);
		
		if(hitResult > 0) {
			EvalBoardDTO evalBoardList = service.boardEvalContents(eval_num);
			req.setAttribute("boardList", evalBoardList);
			req.setAttribute("page", page);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("board_eval_contents.jsp");
			dispatcher.forward(req, resp);
		} else {
			System.out.println("조회수가 오르지 않았습니다.");
		}
	}
}
