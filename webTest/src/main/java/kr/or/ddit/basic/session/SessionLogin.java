package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userID = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		HttpSession session = request.getSession();
		
		if("admin".equals(userID) && "1234".equals(userPass)) {  // 로그인 성공
			session.setAttribute("LOGINID", userID);
		}
		
		// sessionLogin.jsp로 이동하기
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
