package controller.Logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import tools.JDBCUtil;
import vo.User;
import dao.DownloadDao;
import dao.UserDao;

public class AjaxLoginCheck extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
//		session.setAttribute("chrName", null);
		String username = request.getParameter("userName");
		String passwd =request.getParameter("password");
		String vcode =request.getParameter("vcode");
		String autologin =request.getParameter("autoLogin");
		String saveVcode=(String)request.getSession().getAttribute("verityCode");
//		String forwardPath ="";
		
		System.out.println("vcode"+vcode+"passwd"+passwd);
		Map<String,Object> map =new HashMap<String, Object>();
		if(!vcode.equalsIgnoreCase(saveVcode)){
			map.put("code", 1);
			map.put("info", "验证码不正确！");
		}else{
//			JDBCUtil db = new JDBCUtil();
//			User user=null;
//			user =db.getUser("SELECT * FROM t_user where username=?", username);
			UserDao dao = new UserDao();
			User user=null;
			user =dao.getUser("SELECT * FROM t_user where username=?", username);
			if(user == null){
				map.put("code", 2);
				map.put("info", "用户名不存在");
			}else{
				if(!user.getPassword().equals(passwd)){
					map.put("code", 3);
					map.put("info", "密码错误");
				}else{
					session.setAttribute("currentuser", username);
					session.setAttribute("chrName",user.getChrName());
					session.setAttribute("user", user);
					if(autologin !=null){
						 Cookie cookiename=new Cookie("cookiename",username);
						 Cookie cookiepwd=new Cookie("cookiepwd",passwd);
						 cookiepwd.setMaxAge(7*24*3600);
						 cookiename.setMaxAge(7*24*3600);
						 cookiepwd.setPath("/");
						 cookiename.setPath("/");
						 response.addCookie(cookiepwd);
						 response.addCookie(cookiename);
					}
					map.put("code",0);
					map.put("info", "登陆成功");
				}
			}
		}
		
		String jsonStr =new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
