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

import implementation.com.gottasadae.boarddto.FreeBoardDTO;
import implementation.com.gottasadae.boardservice.FreeBoardService;

@WebServlet("/board_freetalk_write")
public class BoardFreetalkWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardFreetalkWrite() {
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
		String realPath = null;
		int size = 10 * 1024 * 1024;
		realPath = "C:/Users/Two/workspace_sts_3.8.4/Gottasadae/web/FreeBoardFile";
		
		MultipartRequest multi = new MultipartRequest(req, realPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		FreeBoardDTO dto = new FreeBoardDTO();
		dto.setFree_id(multi.getParameter("free_id"));
		dto.setFree_subject(multi.getParameter("free_subject"));
		dto.setFree_content(multi.getParameter("free_content"));
		dto.setFree_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		System.out.println(dto.getFree_id() + "" + dto.getFree_file());
		
		boolean writeResult = service.boardFreeWrite(dto);
		
		resp.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = resp.getWriter();
		System.out.println(writeResult);
		
		if(writeResult) {
			out.println("<script>");
			out.println("alert('게시글 업로드 성공, 목록으로 이동합니다.')");
			out.println("location.href='BoardFreetalk'</script>");
		} else {
			out.println("<script language='javascript'>");
			out.println("alert('게시글 업로드에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
}
