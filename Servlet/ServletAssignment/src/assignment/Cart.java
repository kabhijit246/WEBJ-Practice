package assignment;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cart() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("user_name");
		try 
		{
			String url = "jdbc:mysql://localhost:3307/db_name";
			String user = "root";
			String pass = "1208";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, pass);

			String sql = "SELECT Pname FROM products_details INNER JOIN users_details WHERE ID=UID and USERNAME=?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet result = ps.executeQuery();
			out.println("<h1>Item/s in your cart is/are: </h1>");

			while(result.next()) {
				out.println("<h4>"+ result.getString("Pname") +"</h4>");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
