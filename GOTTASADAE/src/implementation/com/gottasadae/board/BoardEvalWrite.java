package implementation.com.gottasadae.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import implementation.com.gottasadae.boarddto.EvalBoardDTO;
import implementation.com.gottasadae.boardservice.EvalBoardService;

@WebServlet("/board_eval_write")
public class BoardEvalWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardEvalWrite() {
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
		String realPath = null;
		int size = 10 * 1024 * 1024;
		realPath = "C:/Users/Two/workspace_sts_3.8.4/Gottasadae/web/FreeBoardFile";
		
		MultipartRequest multi = new MultipartRequest(req, realPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		EvalBoardDTO dto = new EvalBoardDTO();
		dto.setEval_id(multi.getParameter("eval_id"));
		dto.setEval_subject(multi.getParameter("eval_subject"));
		dto.setEval_content(multi.getParameter("eval_content"));
		dto.setEval_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		System.out.println(dto.getEval_id() + "" + dto.getEval_file());
		
		boolean writeResult = service.boardEvalWrite(dto);
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		System.out.println(writeResult);
		
		if(writeResult) {
			out.println("<script>");
			out.println("alert('게시글 업로드 성공, 목록으로 이동합니다.')");
			out.println("location.href='BoardEvaluation'</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('게시글 업로드에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
