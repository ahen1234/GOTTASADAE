package implementation.com.gottasadae.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boardservice.FreeBoardService;

@WebServlet("/BoardFreetalkDelete")
public class BoardFreetalkDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public BoardFreetalkDelete() {
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
		int free_num = Integer.parseInt(req.getParameter("free_num"));
		FreeBoardService service = new FreeBoardService();
		
		boolean result = service.BoardFreetalkDelete(free_num);
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		if(result) {
			out.println("<script language='javascript'>");
			out.println("alert('게시글 삭제 성공! 메인으로 돌아갑니다.')");
			out.println("location.href='BoardFreetalk'");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('게시글 삭제에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
