package assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<center><font color=\"green\" size=\"16\"><b>Welcome to the World of Java</b></center>");
	}
}
