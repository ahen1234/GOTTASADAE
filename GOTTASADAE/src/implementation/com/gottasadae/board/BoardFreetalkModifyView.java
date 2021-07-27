package implementation.com.gottasadae.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.com.gottasadae.boarddto.FreeBoardDTO;
import implementation.com.gottasadae.boardservice.FreeBoardService;

@WebServlet("/BoardFreetalkModifyView")
public class BoardFreetalkModifyView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFreetalkModifyView() {
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
		FreeBoardService service = new FreeBoardService();
		HttpSession session = req.getSession();
		String free_num = req.getParameter("free_num");
		System.out.println(free_num);
		
		FreeBoardDTO freeBoardList = service.BoardFreetalkModifyView(free_num);
		
		req.setAttribute("boardList", freeBoardList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("board_freetalk_modify.jsp");
		dispatcher.forward(req, resp);
	}
}
