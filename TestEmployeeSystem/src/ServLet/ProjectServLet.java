package ServLet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ProjectDao;
import Dao.EmployeeDao;
import Entity.Project;
import Entity.Employee;
import net.sf.json.JSONArray;
import util.Constant;
import util.Pagination;

public class ProjectServLet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String type = request.getParameter("type");
			if (type == null) {
				search(request, response);
			}
			else if ("ShowAdd".equals(type)) {
				ShowAdd(request, response);
			}
			else if ("Add".equals(type)) {
				Add(request, response);
			}
			else if ("delete".equals(type)) {
				delete(request, response);
			}
			else if ("modify".equals(type)) {
				modify(request, response);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		String pros = request.getParameter("pros");
		JSONArray jsonArray = JSONArray.fromObject(pros);
		List<Project> list = (List<Project>) JSONArray.toCollection(jsonArray, Project.class);

		ProjectDao proDao = new ProjectDao();
		boolean flag = proDao.modify(list);
		if(flag) {
			try {
				response.sendRedirect("pro");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("ids");

		   
		   ProjectDao proDao = new ProjectDao();

		boolean flag = proDao.delete(ids);
		if (flag) {

			try {

				response.sendRedirect("pro");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
//
	private void Add(HttpServletRequest request, HttpServletResponse response) {
		   String name = request.getParameter("name");
		   Project pro = new Project();
		   pro.setName(name);
		   ProjectDao proDao = new ProjectDao();
		   boolean flag=proDao.add(pro);
		   if(flag) {
			   try {
				response.sendRedirect("pro");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		
	}

	private void ShowAdd(HttpServletRequest request, HttpServletResponse response) {
		try {

			request.getRequestDispatcher("WEB-INF/Project/ShowAdd.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void search(HttpServletRequest request, HttpServletResponse response) {
//		int empCount = -1;
		String name = request.getParameter("name");
		   Project pro = new Project();
		pro.setName(name);
//		if(request.getParameter("empCount")!=null&&!"".equals(request.getParameter("empCount"))) {
//			
//			empCount=Integer.parseInt(request.getParameter("empCount"));
//
//		}
//		pro.setEmpCount(empCount);
		
		   ProjectDao proDao = new ProjectDao();
		int ye = 1;
		if (request.getParameter("ye") != null) {
			ye = Integer.parseInt(request.getParameter("ye"));

		}
		int count = proDao.searchCount(pro);
		
		
		Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE, Constant.EMP_NUM_OF_PAGE);

		List<Project> list =proDao.search(pro,p.getBegin(), Constant.EMP_NUM_IN_PAGE);
		request.setAttribute("p", p);
		request.setAttribute("c", pro);

		request.setAttribute("list", list);

		try {
			request.getRequestDispatcher("WEB-INF/Project/ProjectList.jsp").forward(request, response);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public void show(HttpServletRequest request, HttpServletResponse response) {
//		try {
//			Project pro = new Project();
//			List<Project> list = new ArrayList<>();
//			ProjectDao proDao = new ProjectDao();
//			list = proDao.search();
//			request.setAttribute("list", list);
//		
//				request.getRequestDispatcher("WEB-INF/Project/ProjectList.jsp").forward(request, response);
//			} catch (ServletException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	
	//}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
