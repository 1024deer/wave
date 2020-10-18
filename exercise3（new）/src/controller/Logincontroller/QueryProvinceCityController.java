package controller.Logincontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.City;
import vo.Province;

import com.google.gson.Gson;

import dao.ProvinceCityDao;

public class QueryProvinceCityController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String provinceCode = request.getParameter("provinceCode");
		String jsonStr ="";
		ProvinceCityDao dao =new ProvinceCityDao();		
		if(provinceCode == null){
			ArrayList<Province> list =new ArrayList<Province>();
			list =dao.queryProvince("SELECT * FROM `t_province`");
			jsonStr =new Gson().toJson(list);
		}else{
			ArrayList<City> citylist =dao.querycity("SELECT * FROM `t_provinceid_city` where provinceId =?",provinceCode);
			System.out.println(citylist.toString());
			jsonStr =new Gson().toJson(citylist);
		}
		response.setContentType("text/html;charset=UTF-8");		
		PrintWriter out =response.getWriter();
		out.print(jsonStr);
		out.flush();
		out.close();
	}

}
