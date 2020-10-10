package controller.Logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.City;
import vo.Province;
import vo.User;

import com.google.gson.Gson;

import dao.UserDao;

public class CheckExistController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String mail = request.getParameter("mail");
		Map<String,Object> map =new HashMap<String, Object>();
		String jsonStr="";
		if(mail == null){
			UserDao dao = new UserDao();
			User user=null;
			user =dao.getUser("SELECT * FROM t_user where username=?", userName);
			if(user == null){
				map.put("code", 0);
				map.put("info", "没有重复");
				jsonStr =new Gson().toJson(map);
			}
			else{
			map.put("code", 1);
			map.put("info", "输入重复");
			jsonStr =new Gson().toJson(map);
			}
		}else{
			UserDao dao = new UserDao();
			Boolean boo=dao.checkUsermail("SELECT * FROM `t_user` where mail=?", mail);
			if(!boo){
				map.put("code", 0);
				map.put("info", "没有重复");
				jsonStr =new Gson().toJson(map);
			}
			else{
			map.put("code", 1);
			map.put("info", "输入重复");
			jsonStr =new Gson().toJson(map);
			}
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
