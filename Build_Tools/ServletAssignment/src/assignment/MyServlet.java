package assignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String s = (String) session.getAttribute("user_name");
		String add = (String) session.getAttribute("user_address");
		String phone = (String) session.getAttribute("user_phone");
		String mail = (String) session.getAttribute("user_mail");
		String language = (String) session.getAttribute("user_language");
		String link = (String) session.getAttribute("user_link");
		out.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <title>Bootstrap Assignment</title>\r\n" + 
				"    <link rel=\"icon\" href=\"Victory.png\">\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n" + 
				"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
				"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n" + 
				"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\"></script>\r\n" + 
				"    <script src=\"https://kit.fontawesome.com/a7c3ea5062.js\" crossorigin=\"anonymous\"></script>\r\n" + 
				"    <script src=\"bstrap.js\"></script>\r\n" + 
				"</head>\r\n" + 
				"    <body class=\"bg-secondary text-secondary\">\r\n" + 
				"         <div class=\"container-fluid bg-dark\">\r\n" + 
				"         <div class=\"flex\">\r\n" + 
				"            <button class=\"btn text-white\">WebSiteName</button>\r\n" + 
				"            <button class=\"btn text-white active\">Home</button>\r\n" + 
				"            <button class=\"btn text-white\">Page 1</button>\r\n" + 
				"            <button class=\"btn text-white\">Page2</button>\r\n" + 
				"            <button class=\"btn text-white float-right\" onclick=\"signout()\"><i class=\"fas fa-user\"></i> Sign Out</button>\r\n" + 
				"            <button class=\"btn text-white float-right\" onclick=\"cart()\"><i class=\"fas fa-shopping-cart\"></i> Cart</button>\r\n" +
				"         </div>\r\n" + 
				"         </div>\r\n" + 
				"        <div class=\"row\">\r\n" + 
				"        <div class=\"col-sm-4\">\r\n" + 
				"        <div class=\"border bg-white ml-2 mt-2 pl-3 pt-3\">               \r\n" + 
				"            <div class=\"border w-25 h-25 text-center mx-auto rounded-circle bg-secondary\">\r\n" + 
				"                <i class=\"fas fa-user-alt fa-5x pt-4 text-white\"></i>\r\n" + 
				"            </div>\r\n" + 
				"            <h4 class=\"text-center pt-5 mb-0\" id=\"result\"><b>\r\n"+s+"</b></h4>\r\n" + 
				"            <p class=\"text-center\"><small>Programmer</small></p><hr>\r\n" + 
				"            <p><i class=\"fas fa-map-marker-alt pr-3\"></i>\r\n"+add+"</p>\r\n" + 
				"            <p><i class=\"fas fa-phone-alt pr-3\"></i>\r\n" +"+91 " +phone+"</p>\r\n" + 
				"            <p><i class=\"fas fa-envelope pr-3\"></i>\r\n" +mail+"</p>\r\n" + 
				"            <p><i class=\"fas fa-link pr-3\"></i> <a href=\"#\">\r\n"+link+"</a></p>\r\n" + 
				"            <p><i class=\"fas fa-language pr-3\"></i>\r\n"+language+"</p><hr>\r\n" + 
				"            <p class=\"text-center\">\r\n" + 
				"                <i class=\"fab fa-twitter fa-2x text-primary mr-2\"></i>\r\n" + 
				"                <i class=\"fab fa-soundcloud fa-2x text-danger\"></i>\r\n" + 
				"            </p></div></div>\r\n" + 
				"        <div class=\"col-sm-8\">\r\n" + 
				"            <div class=\"border bg-white mt-2 pl-3 pt-3 mr-2\">\r\n" + 
				"            <h5>BACKGROUND</h5><hr>\r\n" + 
				"            <h5><i class=\"fas fa-address-card pr-3\"></i>ABOUT</h5><hr>\r\n" + 
				"            <P>Lorem ipsum dolor sit amet,consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </P>\r\n" + 
				"            <h5><i class=\"fas fa-city pr-3\"></i>WORK EXPERIENCE</h5><hr>\r\n" + 
				"            <p class=\"mb-0\"><b class=\"text-dark\">Project 1, </b><a href=\"#java\" class=\"text-primary\">Java, </a><a href=\"#angular\" class=\"text-primary\">Angular</a></p>\r\n" + 
				"                <p><small>Jun,2020 - jun,2021 <i class=\"far fa-clock\"></i> 1 year</small></p>\r\n" + 
				"            <P>Lorem ipsum dolor sit amet,consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </P>\r\n" + 
				"            <ul>\r\n" + 
				"            <li>Random point 1</li>\r\n" + 
				"            <li>Random point 2</li>\r\n" + 
				"            <li>Random point 3</li></ul>\r\n" + 
				"            <h5><i class=\"fas fa-tools pr-3\"></i>SKILLS</h5><hr>\r\n" + 
				"            <div class=\"border-10\"><b class=\"text-dark ml-3\">Web Development</b>\r\n" + 
				"            <p class=\"d-inflex\">\r\n" + 
				"                <button class=\"btn bg-primary text-white ml-3\">HTML</button>\r\n" + 
				"                <button class=\"btn bg-primary text-white\">CSS</button>\r\n" + 
				"                <button class=\"btn bg-primary text-white\">Javascript</button>\r\n" + 
				"                </p></div><hr>\r\n" + 
				"            <div class=\"border-10\"><b class=\"text-dark ml-3\">Compression</b>\r\n" + 
				"            <p class=\"d-inflex\">\r\n" + 
				"                <button class=\"btn bg-primary text-white ml-3\">Mpeg</button>\r\n" + 
				"                <button class=\"btn bg-primary text-white\">MP4</button>\r\n" + 
				"                <button class=\"btn bg-primary text-white\">GIF</button>\r\n" + 
				"                </p></div>\r\n" + 
				"            <h5><i class=\"fas fa-graduation-cap pr-3\"></i>EDUCATION<hr></h5>\r\n" + 
				"            <p class=\"mb-0\"><b class=\"text-dark\">Bachelor Of Technology, </b>IIT BHU Varanasi</p>\r\n" + 
				"                <p><small>Jul,2016 - May,2020</small></p>\r\n" + 
				"                <p class=\"text-dark\"><i>CGPA: 8.26</i></p>\r\n" + 
				"            <P class=\"d-inflex\">\r\n" + 
				"                <button class=\"btn bg-primary text-white\">DB1101-BasicSQL</button>\r\n" + 
				"                <button class=\"btn bg-primary text-white\">CS2011-Java Introduction</button>\r\n" + 
				"            </P><hr>\r\n" + 
				"            <h5><i class=\"fas fa-heart pr-3\"></i>INTERESTS</h5><hr>\r\n" + 
				"                <p class=\"text-dark\"><b>Wildlife</b></p>\r\n" + 
				"            <p class=\"d-inflex\">\r\n" + 
				"                 <button class=\"btn bg-primary text-white\">Ferrets</button>\r\n" + 
				"                 <button class=\"btn bg-primary text-white\">Unicorns</button>\r\n" + 
				"            </p>\r\n" + 
				"            </div></div></div>\r\n" + 
				"    </body>\r\n" +
				"</html>");
	}
}
