package implementation.com.gottasadae.usercontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import implementation.com.gottasadae.member.MemberDTO;
import implementation.com.gottasadae.userdao.MemberDAO;



@WebServlet("/join")
public class InsertMemberController extends HttpServlet {

	// 회원 가입 서블릿

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		MemberDAO MD = MemberDAO.getInstance();
		MemberDTO member = new MemberDTO();
		
		member.setId(req.getParameter("id"));
		member.setPassword(req.getParameter("pw"));
		member.setName(req.getParameter("name"));
		member.setGender(req.getParameter("gender"));
		member.setBirthyy(req.getParameter("birthyy"));
		member.setBirthmm(req.getParameter("birthmm"));
		member.setBirthdd(req.getParameter("birthdd"));
		member.setMail(req.getParameter("email"));
		member.setPhone(req.getParameter("phone"));
		member.setAddress(req.getParameter("address"));
		member.setMajor(req.getParameter("major"));
		
		
		PrintWriter out = resp.getWriter();
		int cnt = MD.insertMember(member);
		
		if (cnt > 0) {
			out.println("<script>");
			out.println("alert('환영합니다');");
			out.println("location.href = 'login_main.jsp';");
			out.println("</script>");
			
		} else {
			out.println("<script>");
			out.println("alert('회원가입실패');");
			out.println("location.href = 'Join_form.jsp';");
			out.println("</script>");
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
