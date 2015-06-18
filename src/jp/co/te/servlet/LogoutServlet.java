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

@WebServlet(name = "LogoutServlet", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String sessionId = session.getId();
		System.out.println(sessionId + " : logout");
		
		session.invalidate();
		
		response.setContentType(Constant.CONTENT_TYPE_TEXT_HTML);
		PrintWriter writer = response.getWriter();
		writer.append("logout");
		writer.append(Constant.BACK_ANCHOR);
		
		writer.flush();
	}
}
