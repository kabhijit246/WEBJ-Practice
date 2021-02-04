package assignment;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		HttpServletRequest req = (HttpServletRequest) request;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		try 
		{
			String url = "jdbc:mysql://localhost:3307/db_name";
			String user = "root";
			String pass = "1208";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pass);

			String sql = "SELECT USERNAME, PASSWORD FROM users_details;";
			PreparedStatement create = connection.prepareStatement(sql);
			ResultSet result = create.executeQuery();
			boolean correct = false;
			while(result.next()) {
				if(username.equals(result.getString("USERNAME")) && password.equals(result.getString("PASSWORD"))) {
					correct = true;
				}
			}

			if(correct) {
				String newsql = "SELECT * FROM users_details WHERE USERNAME=?;";
				PreparedStatement ps = connection.prepareStatement(newsql);
				ps.setString(1, username);
				ResultSet r = ps.executeQuery();

				while(r.next()) {
					HttpSession session = req.getSession();
					session.setAttribute("user_name", r.getString("USERNAME"));
					session.setAttribute("user_address", r.getString("ADDRESS"));
					session.setAttribute("user_phone", r.getString("PHONE"));
					session.setAttribute("user_mail", r.getString("EMAIL"));
					session.setAttribute("user_language", r.getString("LANGUAGE"));
					session.setAttribute("user_link", r.getString("LINK"));
					chain.doFilter(request, response);
				}
			}

			else {
				out.println("<p>wrong username or password</p>");
				RequestDispatcher rs = request.getRequestDispatcher("JavaScript.html");
				rs.include(request, response);
			}

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	public void destroy() {}
}
