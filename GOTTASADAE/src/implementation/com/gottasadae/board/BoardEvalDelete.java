package implementation.com.gottasadae.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.boardservice.EvalBoardService;

@WebServlet("/BoardEvalDelete")
public class BoardEvalDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardEvalDelete() {
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
		int eval_num = Integer.parseInt(req.getParameter("eval_num"));
		EvalBoardService service = new EvalBoardService();
		
		boolean result = service.BoardEvalDelete(eval_num);
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		
		if(result) {
			out.println("<script language='javascript'>");
			out.println("alert('게시글 삭제 성공! 메인으로 돌아갑니다.')");
			out.println("location.href='BoardEvaluation'");
			out.println("</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('게시글 삭제에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
