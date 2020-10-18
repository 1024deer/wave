package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import tools.JDBCUtil;
import vo.User;

public class UserDao {
	public User getUser(String sql, String params) {
		JDBCUtil jb	=new JDBCUtil();
        Object object = null;
        User user = null;
        try {    
            // 获得连接    
            jb.conn = jb.getConnection();    
                
            // 调用SQL    
            jb.pst = jb.conn.prepareStatement(sql);    
                
            // 参数赋值    
            jb.pst.setString(1, params);    
                
            // 执行    
            jb.rst = jb.pst.executeQuery();    
    
            if(jb.rst.next()) {    
            	user =new User(jb.rst.getString("userName"),jb.rst.getString("password"),jb.rst.getString("chrName"));    
            }    
                
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        } finally {    
        	jb.closeAll();    
        }    
    
        
		return user;    
    }
	
	public Boolean checkUsermail(String sql, String params) {
		JDBCUtil jb	=new JDBCUtil();
        String mail=null;
        try {    
            // 获得连接    
            jb.conn = jb.getConnection();    
                
            // 调用SQL    
            jb.pst = jb.conn.prepareStatement(sql);    
                
            // 参数赋值    
            jb.pst.setString(1, params);    
                
            // 执行    
            jb.rst = jb.pst.executeQuery();    
    
            if(jb.rst.next()) {    
            	mail = jb.rst.getString("mail");    
            }    
                
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        } finally {    
        	jb.closeAll();    
        }    
        if(mail!=null){
		return true;
        }
        else{
        	return false;
        }
    }
	
	
	public int insertUser(String sql, String[] params) {
		JDBCUtil jb	=new JDBCUtil();
		int result = 0;
        try {    
            // 获得连接    
            jb.conn = jb.getConnection();       
            // 调用SQL    
            jb.pst = jb.conn.prepareStatement(sql);       
            // 参数赋值   
            for(int i=0;i<params.length;i++){
            	jb.pst.setString(i+1, params[i]);    
            }
            // 执行    
            result = jb.pst.executeUpdate();   
     
               
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        } finally {    
        	jb.closeAll();    
        }
		return result;          
    }
}
