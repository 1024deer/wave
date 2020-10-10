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

public class ResourceFilter implements Filter {
	public void main(String[] args){
		String	str="admin";
		StringBuffer s = new StringBuffer("SELECT `url` FROM t_resource WHERE resourceId IN (SELECT resourceId FROM t_role_resource WHERE roleId IN (SELECT roleId FROM t_user_role WHERE userName = ''))");
		
		s.insert(s.length(), str);
		System.out.println(s);
	}
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
		System.out.println("�����ַ��"+path);
		HttpSession session = request.getSession();
		String	username=(String) session.getAttribute("username");
		StringBuffer s = new StringBuffer("SELECT `url` FROM t_resource WHERE resourceId IN (SELECT resourceId FROM t_role_resource WHERE roleId IN (SELECT roleId FROM t_user_role WHERE userName = ''))");
		s.insert(s.length()-3, username);
		System.out.println(s);
		String sql =s.toString();
		int flag =0;
		JDBCUtil dbutil = new JDBCUtil();
		ArrayList list = dbutil.getUserResource(sql);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			if(path.equals(list.get(i))){
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			request.setAttribute("error_1", "��Ǹ����û��Ȩ�޷���");
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

