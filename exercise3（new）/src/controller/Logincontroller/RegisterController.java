package controller.Logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDao;

public class RegisterController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String chrName = request.getParameter("chrName");
		String mail = request.getParameter("mail");
		String provinceCode = request.getParameter("provinceCode");
		String cityCode = request.getParameter("cityCode");
		String password = request.getParameter("password");
		String[] str={userName,password,chrName,mail,provinceCode,cityCode};
		for(int i=0;i<str.length;i++){
			System.out.println(str[i]);
		}
		
		UserDao dao =new UserDao();
		int res =dao.insertUser("INSERT INTO t_user VALUES (?,?,?,?,?,?)", str);
		System.out.println(res);
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("code", 0);
		map.put("info", "×¢²á³É¹¦");
		String jsonStr =new Gson().toJson(map);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
