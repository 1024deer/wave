package dao;

import java.util.ArrayList;

import vo.User;

public class UserDao {
	public static ArrayList<User> list =new ArrayList<User>();
	//���ص�¼��ʾ���
		public static int  loginreq(String s1,String s2){
			if(isInList(s1)){
				if(s2.equals(getUserPassword(s1))){
					return 0;
				}
				else{
					return 2;
				}
			}
			else{
				return 1;
			}
		}
	//�ж��û����Ƿ���list��
	public static Boolean isInList(String username)
	{
		for(int i=0;i<list.size();i++){
			if(username.equals(list.get(i).getUserName())){
				return true;
			}
		}
		return false;
	}
//
	public static void addToArrayList (User user){
		list.add(user);
	}

	//��ȡ�û�����Ӧ������
	public static String getUserPassword(String username){
		for(int i=0;i<list.size();i++){
			if(username.equals(list.get(i).getUserName())){
				return list.get(i).getPassword();
			}
		}
		return "error";
		
	}
	public static String getUserchrName(String username){
		for(int i=0;i<list.size();i++){
			if(username.equals(list.get(i).getUserName())){
				return list.get(i).getChrName();
			}
		}
		return "error";
		
	}
	public static User getUser(String username){
		for(int i=0;i<list.size();i++){
			if(username.equals(list.get(i).getUserName())){
				return list.get(i);
			}
		}
		return null;
	}
	public static String getchrName(String username){
		for(int i=0;i<list.size();i++){
			if(username.equals(list.get(i).getUserName())){
				return list.get(i).getChrName();
			}
		}
		return null;
	}
}
