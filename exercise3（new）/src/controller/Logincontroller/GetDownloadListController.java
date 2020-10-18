package controller.Logincontroller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet/download")
public class GetDownloadListController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String  num =request.getParameter("id");
		int a = Integer.parseInt(num)-1;
		String filepath =dao.DownloadDao.dlist.get(a).getPath();
		String path = request.getServletContext().getRealPath((filepath));
		String fileName = path.substring(path.lastIndexOf("\\")+1);
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
		InputStream in =new FileInputStream(path);
		int len = 0;
		byte[] buffer = new byte[1024];
		ServletOutputStream out = response.getOutputStream();
		while((len = in.read(buffer))!= -1){
			out.write(buffer, 0, len);
		}
		in.close();
		out.close();
		
	}

}
