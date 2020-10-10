package controller.Logincontroller;

import java.io.IOException;



import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tools.JDBCUtil;
import dao.DownloadDao;
import dao.UserDao;

public class LoginController extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			session.setAttribute("chrName", null);
			String username = request.getParameter("username");
			String passwd =request.getParameter("passwd");
			String userCode =request.getParameter("userCode");
			String checkbox =request.getParameter("checkbox");
			System.out.println("checkbox value:"+checkbox);
			String userCodeDate=(String)request.getSession().getAttribute("verityCode");
			String forwardPath ="";
			if(UserDao.list.size() == 0){
			JDBCUtil dbutil = new JDBCUtil();
			dbutil.getUserData();
			}
			if(!userCode.equalsIgnoreCase(userCodeDate)){
				request.setAttribute("error_1", "抱歉，您输入的验证码不正确");
				forwardPath ="/error.jsp";
			}
			else{
				int state = UserDao.loginreq(username, passwd);
				if(state == 1){
				request.setAttribute("error_1", "抱歉，您输入的用户名不存在");
				forwardPath ="/error.jsp";
				}
				else if(state == 2){
				request.setAttribute("error_1", "抱歉，您输入的密码不正确");
				forwardPath ="/error.jsp";
				}
				else if(state == 0){
				session.setAttribute("currentuser",UserDao.getUser(username));
				session.setAttribute("username",UserDao.getUser(username).getUserName());
				session.setAttribute("chrName",UserDao.getchrName(username));
				forwardPath ="/main.jsp";
				}
				
			}
			if("yes".equals(checkbox)){
				 if((username!=null&&!"".equals(username))&&(passwd!=null&&!"".equals(passwd))){
					 response.addHeader("Set-Cookie","123456");
					 Cookie cookiename=new Cookie("cookiename",username);
					 Cookie cookiepwd=new Cookie("cookiepwd",passwd);
					 cookiepwd.setMaxAge(7*24*3600);
					 cookiename.setMaxAge(7*24*3600);
					 cookiepwd.setPath("/");
					 cookiename.setPath("/");
					 response.addCookie(cookiepwd);
					 response.addCookie(cookiename);
				 }
			}
			if(DownloadDao.dlist.size()==0){
			JDBCUtil downloaddbutil = new JDBCUtil();
			downloaddbutil.getDownloadList();
		}
			RequestDispatcher rd =request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
	}
}
