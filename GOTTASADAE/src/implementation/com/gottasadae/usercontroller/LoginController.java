package implementation.com.gottasadae.usercontroller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementation.com.gottasadae.member.MemberLoginDTO;
import implementation.com.gottasadae.userdao.MemberDAO;



@WebServlet("/login")
public class LoginController extends HttpServlet {


	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession(true);
		
		PrintWriter out = resp.getWriter();
		
		MemberLoginDTO MLDTO = new MemberLoginDTO();
		MemberDAO dao = MemberDAO.getInstance(); 
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MLDTO.setId(id);
		MLDTO.setPwd(pw);
		
		
		int cnt = dao.login(MLDTO);
	
		if(cnt == 1) {
			out.println("<script>");
			out.println("alert('로그인 성공');");
			out.println("location.href = 'Main.jsp';");
			out.println("</script>");
			session.setAttribute("sessionID", id);
			session.setMaxInactiveInterval(60*60*2);
		} else {
			out.println("<script>");
			out.println("alert('아이디 / 비밀번호가 일치하지 않습니다!');");
			out.println("location.href = 'login_main.jsp';");
			out.println("</script>");
		}
	}
	

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
