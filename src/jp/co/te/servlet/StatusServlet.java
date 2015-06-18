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

@WebServlet(name = "StatusServlet", urlPatterns = { "/status" })
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String sessionId = session.getId();
		String userName = (String) session.getAttribute(Constant.SESSION_USER_NAME);
		System.out.println(sessionId + " : " + userName);

		response.setContentType(Constant.CONTENT_TYPE_TEXT_HTML);
		PrintWriter writer = response.getWriter();
		writer.append(userName);
		writer.append(Constant.BACK_ANCHOR);
		
		writer.flush();
	}
}
