package dao;

import java.util.ArrayList;

import vo.Download;
import vo.User;

public class DownloadDao {
	public static ArrayList<Download> dlist =new ArrayList<Download>();
	public static void addToDownloadArrayList(Download d){
		dlist.add(d);
	}
	public static String getNamebyId(int x){
		return dlist.get(x).getName();
	}
	public static String getpathbyId(int x){
		return dlist.get(x).getPath();
	}
	public static String getDescriptionbyId(int x){
		return dlist.get(x).getDescription();
	}
	public static int getstarbyId(int x){
		return dlist.get(x).getStar();
	}
	public static double getSizebyId(int x){
		return dlist.get(x).getSize();
	}
	public static String getImagebyId(int x){
		return dlist.get(x).getImage();
	}
	
}
