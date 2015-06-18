package jp.co.te.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.te.common.Constant;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute(Constant.SESSION_USER_NAME, "TestUser");
	
		String sessionId = session.getId();
		System.out.println(sessionId + " : login");
		
		response.setContentType(Constant.CONTENT_TYPE_TEXT_HTML);
		PrintWriter writer = response.getWriter();
		writer.append("login");
		writer.append(Constant.BACK_ANCHOR);
		
		writer.flush();
	}
}
