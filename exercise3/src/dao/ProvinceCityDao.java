package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import tools.JDBCUtil;
import vo.City;
import vo.Province;

public class ProvinceCityDao {
	public ArrayList<City> querycity(String sql,String param){
		JDBCUtil jb	=new JDBCUtil();
		ArrayList<City> list =new ArrayList<City>();
       try {
        	jb.conn = jb.getConnection();
			jb.pst = jb.conn.prepareStatement(sql);
			jb.pst.setString(1, param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       try {
		jb.rst = jb.pst.executeQuery();
		 while(jb.rst.next()) { 
	    	   City city =new City(jb.rst.getString("cityName"), jb.rst.getInt("cityId"),jb.rst.getInt("provinceId"));
	           list.add(city);    
	       }
		 jb.closeAll();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
      return list;
	}


	
	public ArrayList<Province> queryProvince(String sql){
		JDBCUtil jb	=new JDBCUtil();
		ArrayList<Province> list =new ArrayList<Province>();
       try {
        	jb.conn = jb.getConnection();
			jb.pst = jb.conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       try {
		jb.rst = jb.pst.executeQuery();
		 while(jb.rst.next()) { 
	    	   Province pro =new Province(jb.rst.getString("provinceName"), jb.rst.getInt("provinceId"));
	           list.add(pro);    
	       }
		 jb.closeAll();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
      return list;
	}
}
