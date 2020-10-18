package filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tools.JDBCUtil;
import vo.User;

public class ResourceFilter implements Filter {

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
		System.out.println("请求地址："+path);
		HttpSession session = request.getSession();
		int flag =0;
		User user=(User) session.getAttribute("user");
		String username=user.getUserName();
		JDBCUtil db = new JDBCUtil();
		String sql2="SELECT `url` FROM t_resource WHERE resourceId IN (SELECT resourceId FROM t_role_resource WHERE roleId IN (SELECT roleId FROM t_user_role WHERE userName = ?))";
		Object[] obj={username};
		ArrayList list1 =(ArrayList) db.excuteQuery(sql2, obj);
		for(int i=0;i<list1.size();i++){
			String str =list1.get(i).toString();
			if( str.indexOf(path) != -1){
				flag=1;
				break;
			}
			
		} 
		if(flag == 0){
			request.setAttribute("error_1", "抱歉，你没有权限访问");
			request.getRequestDispatcher("/error.jsp").forward(request, resp);
		}
		else{
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

