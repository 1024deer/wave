package controller.Logincontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookiename=new Cookie("cookiename",null);
		Cookie cookiepwd=new Cookie("cookiepwd",null);
		cookiename.setMaxAge(0);
		cookiepwd.setMaxAge(0);
		cookiepwd.setPath("/");
		cookiename.setPath("/");
		response.addCookie(cookiename);
		response.addCookie(cookiepwd);
		response.setContentType("text/html;charset=UTF-8");
		request.getSession().removeAttribute("currentuser");
		response.sendRedirect("/exercise/login.html");
		
	}

}
