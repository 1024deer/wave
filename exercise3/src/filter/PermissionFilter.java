package filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;

import tools.JDBCUtil;
import vo.User;
import dao.UserDao;

public class PermissionFilter implements Filter {
	private String notCheckPath;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request =(HttpServletRequest)req;
		String path =request.getServletPath();
		String passwd=null;
		String username=null;
		if((username==null||"".equals(username))||(passwd==null||"".equals(passwd))){
		Cookie[] cookies=request.getCookies();
        //过滤出用户名和密码
        if(cookies!=null&&cookies.length>0){
           for(int i=0;i<cookies.length;i++){
                //取出用户名
                if("cookiename".equals(cookies[i].getName())){
                    username=URLDecoder.decode(cookies[i].getValue(),"utf-8");
                }
                //取出密码
                if("cookiepwd".equals(cookies[i].getName())){
                   passwd=URLDecoder.decode(cookies[i].getValue(),"utf-8");
               }
           }
        }
        User user=null;
        if(username!=null){
//	        JDBCUtil db = new JDBCUtil();
//			user =db.getUser("SELECT * FROM t_user where username=?", username);
        	UserDao dao = new UserDao();
			user =dao.getUser("SELECT * FROM t_user where username=?", username);
	        System.out.println("LoginCookie.service()name:"+username+"---pwd"+passwd);
			if(user.getUserName().equals(username) && user.getPassword().equals(passwd) ){
				HttpSession session = request.getSession();
				session.setAttribute("currentuser", username);
				session.setAttribute("user", user);
				session.setAttribute("username",user.getUserName());
				session.setAttribute("chrName",user.getChrName());
			}
        }
	}
        
		if(notCheckPath.indexOf(path) == -1){
			HttpSession session = request.getSession();
			if(session.getAttribute("currentuser") == null){
				request.setAttribute("error_1", "抱歉，你没有权限访问");
				request.getRequestDispatcher("/error.jsp").forward(request, resp);
			
			}else{
				chain.doFilter(req, resp);
			}
		}else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
			notCheckPath = config.getInitParameter("notCheckUri");
	}

}
