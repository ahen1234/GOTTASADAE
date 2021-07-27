package implementation.com.gottasadae.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boarddto.FPagingDTO;
import implementation.com.gottasadae.boarddto.FreeBoardDTO;
import implementation.com.gottasadae.boardservice.FreeBoardService;

@WebServlet("/BoardFreetalk")
public class BoardFreetalk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public BoardFreetalk() {
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
		
		int page = 1;
		int limit = 10;
		
		if(req.getParameter("page") != null) {
			page = Integer.parseInt(req.getParameter("page"));
		}
		
		FreeBoardService service = new FreeBoardService();
		int boardCount = service.boardFreeCount();
		
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		ArrayList<FreeBoardDTO> freeBoardList = service.boardFreetalkList(startRow, endRow);
		
		int maxPage = (int)((double)boardCount / limit + 0.9);
		int startPage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		FPagingDTO paging = new FPagingDTO();
		
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setBoardCount(boardCount);
		
		req.setAttribute("paging", paging);
		req.setAttribute("freeBoardList", freeBoardList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("board_freetalk_main.jsp");
		dispatcher.forward(req, resp);
	}
}
