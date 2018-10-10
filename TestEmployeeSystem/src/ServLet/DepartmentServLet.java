package ServLet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DepartmentDao;
import Entity.Department;
import Entity.Project;
import net.sf.json.JSONArray;
import util.Constant;
import util.Pagination;

public class DepartmentServLet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			String type = request.getParameter("type");
			if (type == null) {
				search(request, response);
			} else if ("ShowAdd".equals(type)) {
				ShowAdd(request, response);
			} else if ("Add".equals(type)) {
				Add(request, response);
			} else if ("delete".equals(type)) {
				delete(request, response);
			} else if ("modify".equals(type)) {
				modify(request, response);
			} else if ("project_guanli".equals(type)) {
				
				Show_project_guanli(request, response);
			} else if ("project_guanli2".equals(type)) {
				Show_project_guanli2(request, response);
			} else if ("project_guanli3".equals(type)) {
				Show_project_guanli3(request, response);
			}else if ("add_project".equals(type)) {
				add_project(request, response);
			} else if ("add_project2".equals(type)) {
				add_project2(request, response);
			} else if ("add_project3".equals(type)) {
				add_project3(request, response);
			}else if ("delete_project".equals(type)) {
				delete_project(request, response);
			} else if ("delete_project2".equals(type)) {
				delete_project2(request, response);
			} else if ("delete_project3".equals(type)) {
				delete_project3(request, response);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delete_project(HttpServletRequest request, HttpServletResponse response) {
		int proId = Integer.parseInt(request.getParameter("proId"));
		int id = Integer.parseInt(request.getParameter("id"));
		DepartmentDao depDao = new DepartmentDao();

		boolean flag = depDao.delete_project(id, proId);
		if (flag) {

			try {
				response.sendRedirect("dep?type=project_guanli&id=" + id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void delete_project2(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();

			int proId = Integer.parseInt(request.getParameter("proId"));
			int id = Integer.parseInt(request.getParameter("id"));
			DepartmentDao depDao = new DepartmentDao();

			boolean flag = depDao.delete_project(id, proId);
			out.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void delete_project3(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter out = response.getWriter();

			String proIds = request.getParameter("proIds");
			int id = Integer.parseInt(request.getParameter("id"));
			
			DepartmentDao depDao = new DepartmentDao();

			boolean flag = depDao.delete_projects(id, proIds);
			out.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void add_project(HttpServletRequest request, HttpServletResponse response) {

		int proId = Integer.parseInt(request.getParameter("proId"));
		int id = Integer.parseInt(request.getParameter("id"));
		DepartmentDao depDao = new DepartmentDao();

		boolean flag = depDao.add_project(id, proId);
		if (flag) {

			try {
				response.sendRedirect("dep?type=project_guanli&id=" + id);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void add_project2(HttpServletRequest request, HttpServletResponse response) {

		try {
			PrintWriter out = response.getWriter();
			int proId = Integer.parseInt(request.getParameter("proId"));
			int id = Integer.parseInt(request.getParameter("id"));
			DepartmentDao depDao = new DepartmentDao();

			boolean flag = depDao.add_project(id, proId);

			out.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void add_project3(HttpServletRequest request, HttpServletResponse response) {

		try {
			PrintWriter out = response.getWriter();
			String proIds = request.getParameter("proIds");
			int id = Integer.parseInt(request.getParameter("id"));
			String[] temp = proIds.split(",");
			DepartmentDao depDao = new DepartmentDao();

			boolean flag = depDao.add_projects(id, temp);

			out.print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void Show_project_guanli(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// String ids = request.getParameter("ids");

			DepartmentDao depDao = new DepartmentDao();
			Department dep = new Department();
			dep = depDao.searchById(id);
			List<Project> list = new ArrayList<>();
			list = depDao.searchProject(id);
			request.setAttribute("list", list);
			List<Project> proList = new ArrayList<>();
			proList = depDao.searchNotSelect(id);

			request.setAttribute("proList", proList);
			request.setAttribute("id", id);
			request.setAttribute("dep", dep);

			request.getRequestDispatcher("WEB-INF/Department/Project_guanli.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void Show_project_guanli2(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// String ids = request.getParameter("ids");

			DepartmentDao depDao = new DepartmentDao();
			Department dep = new Department();
			dep = depDao.searchById(id);
			List<Project> list = new ArrayList<>();
			list = depDao.searchProject(id);
			request.setAttribute("list", list);
			List<Project> proList = new ArrayList<>();
			proList = depDao.searchNotSelect(id);

			request.setAttribute("proList", proList);
			request.setAttribute("id", id);
			request.setAttribute("dep", dep);

			request.getRequestDispatcher("WEB-INF/Department/Project_guanli2.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void Show_project_guanli3(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// String ids = request.getParameter("ids");

			DepartmentDao depDao = new DepartmentDao();
			Department dep = new Department();
			dep = depDao.searchById(id);
			List<Project> list = new ArrayList<>();
			list = depDao.searchProject(id);
			request.setAttribute("list", list);
			List<Project> proList = new ArrayList<>();
			proList = depDao.searchNotSelect(id);

			request.setAttribute("proList", proList);
			request.setAttribute("id", id);
			request.setAttribute("dep", dep);

			request.getRequestDispatcher("WEB-INF/Department/Project_guanli3.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		String deps = request.getParameter("deps");
		JSONArray jsonArray = JSONArray.fromObject(deps);
		List<Department> list = (List<Department>) JSONArray.toCollection(jsonArray, Department.class);

		DepartmentDao depDao = new DepartmentDao();
		boolean flag = depDao.modify(list);
		if (flag) {
			try {
				response.sendRedirect("dep");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String ids = request.getParameter("ids");

		DepartmentDao depDao = new DepartmentDao();

		boolean flag = depDao.delete(ids);
		if (flag) {

			try {

				response.sendRedirect("dep");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void Add(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		Department dep = new Department();
		dep.setName(name);
		DepartmentDao depDao = new DepartmentDao();
		boolean flag = depDao.add(dep);
		if (flag) {
			try {
				response.sendRedirect("dep");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void ShowAdd(HttpServletRequest request, HttpServletResponse response) {
		try {

			request.getRequestDispatcher("WEB-INF/Department/ShowAdd.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void search(HttpServletRequest request, HttpServletResponse response) {
		int empCount = -1;
		String name = request.getParameter("name");
		Department dep = new Department();
		dep.setName(name);
		if (request.getParameter("empCount") != null && !"".equals(request.getParameter("empCount"))) {

			empCount = Integer.parseInt(request.getParameter("empCount"));

		}
		dep.setEmpCount(empCount);
		
		
		
		
		

		DepartmentDao depDao = new DepartmentDao();
		int ye = 1;
		if (request.getParameter("ye") != null) {
			ye = Integer.parseInt(request.getParameter("ye"));

		}
		int count = depDao.searchCount(dep);

		Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE, Constant.EMP_NUM_OF_PAGE);

		List<Department> list = depDao.search(dep, p.getBegin(), Constant.EMP_NUM_IN_PAGE);
		request.setAttribute("p", p);
		request.setAttribute("c", dep);

		request.setAttribute("list", list);

		try {
			request.getRequestDispatcher("WEB-INF/Department/DepartmentList.jsp").forward(request, response);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void show(HttpServletRequest request, HttpServletResponse response) {
	// try {
	// Department dep = new Department();
	// List<Department> list = new ArrayList<>();
	// DepartmentDao depDao = new DepartmentDao();
	// list = depDao.search();
	// request.setAttribute("list", list);
	//
	// request.getRequestDispatcher("WEB-INF/Department/DepartmentList.jsp").forward(request,
	// response);
	// } catch (ServletException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// }

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
}
