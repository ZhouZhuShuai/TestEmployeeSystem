package ServLet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ProjectDao;
import Dao.EmployeeDao;
import Entity.Project;
import Entity.Employee;
import net.sf.json.JSONArray;
import util.Constant;
import util.Pagination;

public class IndexServLet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			
		
				
			
			request.setCharacterEncoding("utf-8");
			String type = request.getParameter("type");
			if (type == null) {
				index(request,response);
			}
		
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	private void index(HttpServletRequest request, HttpServletResponse response) {
try {
	request.getRequestDispatcher("WEB-INF/index/index.jsp").forward(request, response);
} catch (ServletException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
