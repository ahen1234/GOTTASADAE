package implementation.com.gottasadae.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boarddto.FreeBoardDTO;
import implementation.com.gottasadae.boardservice.FreeBoardService;

@WebServlet("/BoardFreetalkContents")
public class BoardFreetalkContents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFreetalkContents() {
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
		
		int free_num = Integer.parseInt(req.getParameter("free_num"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		System.out.println("넘겨받은 게시글 번호 : " + free_num);
		
		FreeBoardService service = new FreeBoardService();
		
		int hitResult = service.freeBoardHit(free_num);
		
		if(hitResult > 0) {
			FreeBoardDTO freeBoardList = service.boardFreetalkContents(free_num);
			req.setAttribute("boardList", freeBoardList);
			req.setAttribute("page", page);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("board_freetalk_contents.jsp");
			dispatcher.forward(req, resp);
		} else {
			System.out.println("조회수가 오르지 않았습니다.");
		}
	}
}
