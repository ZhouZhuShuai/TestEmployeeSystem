package ServLet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao.DepartmentDao;
import Dao.EmployeeDao;
import Entity.Department;
import Entity.Employee;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Constant;
import util.Pagination;

public class EmployeeServLet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");

			String type = request.getParameter("type");
			if (type == null) {
				search(request, response);
			} else if ("zengjia".equals(type)) {
				zengjia(request, response);
			} else if ("zengjia2".equals(type)) {
				zengjia2(request, response);
			} else if ("add".equals(type)) {
				add(request, response);
			}else if ("add2".equals(type)) {
				add2(request, response);
			} 
			else if ("upload".equals(type)) {
				upload(request, response);
			} else if ("showModify".equals(type)) {
				showModify(request, response);
			} else if ("modify".equals(type)) {
				modify(request, response);
			} else if ("delete".equals(type)) {
				delete(request, response);
			} else if ("deleteBatch".equals(type)) {
				deleteBatch(request, response);
			} else if ("showModifyBatch1".equals(type)) {
				showModifyBatch1(request, response);
			} else if ("modifyBatch1".equals(type)) {
				modifyBatch1(request, response);
			} else if ("showModifyBatch2".equals(type)) {
				showModifyBatch2(request, response);
			} else if ("modifyBatch2".equals(type)) {
				modifyBatch2(request, response);
			} else if ("modifyBatch3".equals(type)) {
				modifyBatch3(request, response);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void show(HttpServletRequest request, HttpServletResponse response) {
	//
	// try {
	//
	// EmployeeDao empDao = new EmployeeDao();
	// int ye = 1;
	// if (request.getParameter("ye") != null) {
	// ye = Integer.parseInt(request.getParameter("ye"));
	//
	// }
	//
	// int count = empDao.searchCount();
	// Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE,
	// Constant.EMP_NUM_OF_PAGE);
	//
	// List<Employee> list = empDao.search(p.getBegin(), Constant.EMP_NUM_IN_PAGE);
	// request.setAttribute("list", list);
	// request.setAttribute("p", p);
	//
	// request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);
	// } catch (ServletException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }

	public void search(HttpServletRequest request, HttpServletResponse response) {
		int age = -1;
		int depId = 0;
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		// String depName =request.getParameter("dep");
		Employee emp = new Employee();
		emp.setName(name);
		emp.setSex(sex);

		if (request.getParameter("age") != null && !"".equals(request.getParameter("age"))) {

			age = Integer.parseInt(request.getParameter("age"));

		}
		if (request.getParameter("depId") != null && !"".equals(request.getParameter("depId"))) {

			depId = Integer.parseInt(request.getParameter("depId"));

		}
		emp.setAge(age);
		Department dep = new Department();
		dep.setId(depId);
		emp.setDep(dep);

		EmployeeDao empDao = new EmployeeDao();
		int ye = 1;
		if (request.getParameter("ye") != null) {
			ye = Integer.parseInt(request.getParameter("ye"));

		}
		int count = empDao.searchCount(emp);

		Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE, Constant.EMP_NUM_OF_PAGE);

		List<Employee> list = empDao.search06(emp, p.getBegin(), Constant.EMP_NUM_IN_PAGE);
		DepartmentDao depDao = new DepartmentDao();
		List<Department> depList = depDao.searchAll();
		request.setAttribute("p", p);
		request.setAttribute("c", emp);
		request.setAttribute("depList", depList);

		request.setAttribute("list", list);

		try {
			request.getRequestDispatcher("WEB-INF/list.jsp").forward(request, response);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void zengjia(HttpServletRequest request, HttpServletResponse response) {

		try {
			DepartmentDao depDao = new DepartmentDao();
			List<Department> depList = depDao.searchAll();
			request.setAttribute("depList", depList);
			request.getRequestDispatcher("WEB-INF/add.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void zengjia2(HttpServletRequest request, HttpServletResponse response) {

		try {
			DepartmentDao depDao = new DepartmentDao();
			List<Department> depList = depDao.searchAll();
			request.setAttribute("depList", depList);
			request.getRequestDispatcher("WEB-INF/add2.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showModify(HttpServletRequest request, HttpServletResponse response) {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDao empDao = new EmployeeDao();
			Employee emp = empDao.searchById(id);
			DepartmentDao depDao = new DepartmentDao();
			List<Department> depList = depDao.searchAll();
			request.setAttribute("emp", emp);
			request.setAttribute("depList", depList);
			request.getRequestDispatcher("WEB-INF/modify.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showModifyBatch1(HttpServletRequest request, HttpServletResponse response) {

		try {
			String ids = request.getParameter("ids");
			EmployeeDao empDao = new EmployeeDao();
			List<Employee> list = empDao.searchByIds(ids);
			request.setAttribute("emp", list.get(0));
			request.setAttribute("ids", ids);
			request.getRequestDispatcher("WEB-INF/ModifyBatch1.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showModifyBatch2(HttpServletRequest request, HttpServletResponse response) {

		try {
			String ids = request.getParameter("ids");
			EmployeeDao empDao = new EmployeeDao();
			List<Employee> list = empDao.searchByIds(ids);
			request.setAttribute("list", list);
			request.setAttribute("ids", ids);
			request.getRequestDispatcher("WEB-INF/ModifyBatch2.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 public void add2(HttpServletRequest request, HttpServletResponse response) {
	// int depId = -1;
	// if(request.getParameter("depId")!=null&&!"".equals(request.getParameter("depId")))
	 
	//
	// depId=Integer.parseInt(request.getParameter("depId"));
	//
	// }
	 Integer depId = null;
	 if(!"".equals(request.getParameter("depId"))) {
	 depId = Integer.parseInt(request.getParameter("depId"));
	
	 }
	 Employee emp = new Employee();
	 Department dep = new Department();
	 dep.setId(depId);
	 emp.setDep(dep);
	 String name = request.getParameter("name");
	 String photo = request.getParameter("picture");
	 String sex = request.getParameter("sex");
	 emp.setName(name);
	 emp.setSex(sex);
	 emp.setPhoto(photo);
	 emp.setAge(Integer.parseInt(request.getParameter("age")));
	 EmployeeDao empDao = new EmployeeDao();
	 boolean flag = empDao.add(emp);
	 if (flag) {
	
	 try {
	
	 // List<Employee> list = empDao.search();
	 // request.setAttribute("list", list);
	 response.sendRedirect("emp");
	
	 } catch (IOException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	
	 }
	
	 }
	public void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = "";
			String sex = "";
			String age = "";
			String depId = "";
			String path = "D:/tt";
			FileItemFactory factory = new DiskFileItemFactory();// 为该请求创建一个DiskFileItemFactory对象，通过它来解析请求。执行解析后，所有的表单项目都保存在一个List中。
			ServletFileUpload upload = new ServletFileUpload(factory);

			List<FileItem> items;

			items = upload.parseRequest(request);

			String photoName = "";
			for (int i = 0; i < items.size(); i++) {

				FileItem item = items.get(i);
				if (item.getFieldName().equals("photo")) {
					if (!"".equals(item.getName())) {
						UUID uuid = UUID.randomUUID();
						String houzhui = item.getName().substring(item.getName().lastIndexOf("."));
						photoName = uuid.toString() + houzhui;
						File savedFile = new File(path, photoName);
						item.write(savedFile);
					}

				} else if (item.getFieldName().equals("name")) {
					name = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
				} else if (item.getFieldName().equals("sex")) {
					sex = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
				} else if (item.getFieldName().equals("age")) {
					age = new String(item.getString());
				} else if (item.getFieldName().equals("depId")) {
					depId = new String(item.getString());
				}

			}
			Department dep = new Department();
			// Integer depId = null;
			if (!"".equals(depId)) {
				dep.setId(Integer.parseInt(depId));

			}
			Employee emp = new Employee();

			emp.setDep(dep);
			// String name = request.getParameter("name");
			// String sex = request.getParameter("sex");
			emp.setName(name);
			emp.setSex(sex);
			// emp.setAge(Integer.parseInt(request.getParameter("age")));
			emp.setAge(Integer.parseInt(age));
			emp.setPhoto(photoName);
			EmployeeDao empDao = new EmployeeDao();
			boolean flag = empDao.add(emp);
			if (flag) {

				try {

					// List<Employee> list = empDao.search();
					// request.setAttribute("list", list);
					response.sendRedirect("emp");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void upload(HttpServletRequest request, HttpServletResponse response) {
		try {

			String path = "D:/tt";
			FileItemFactory factory = new DiskFileItemFactory();// 为该请求创建一个DiskFileItemFactory对象，通过它来解析请求。执行解析后，所有的表单项目都保存在一个List中。
			ServletFileUpload upload = new ServletFileUpload(factory);

			List<FileItem> items;

			items = upload.parseRequest(request);

			String photoName = "";
			for (int i = 0; i < items.size(); i++) {

				FileItem item = items.get(i);
//			 if (item.getFieldName().equals("photo")) {
				if (!"".equals(item.getName())) {
					UUID uuid = UUID.randomUUID();
					String houzhui = item.getName().substring(item.getName().lastIndexOf("."));
					photoName = uuid.toString() + houzhui;
					File savedFile = new File(path, photoName);
					item.write(savedFile);
				}

				// }
			}
			PrintWriter out = response.getWriter();
			out.print(photoName);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modify(HttpServletRequest request, HttpServletResponse response) {

		Employee emp = new Employee();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		emp.setId(id);
		emp.setName(name);
		emp.setSex(sex);
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		Integer depId = null;
		if (!"".equals(request.getParameter("depId"))) {
			depId = Integer.parseInt(request.getParameter("depId"));
		}
		Department dep = new Department();
		dep.setId(depId);
		emp.setDep(dep);
		EmployeeDao empDao = new EmployeeDao();
		boolean flag = empDao.modify(emp);
		if (flag) {

			try {

				// List<Employee> list = empDao.search();
				// request.setAttribute("list", list);
				response.sendRedirect("emp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void modifyBatch1(HttpServletRequest request, HttpServletResponse response) {

		Employee emp = new Employee();
		String ids = request.getParameter("ids");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");

		emp.setName(name);
		emp.setSex(sex);
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		EmployeeDao empDao = new EmployeeDao();
		boolean flag = empDao.modifyBatch1(ids, emp);
		if (flag) {

			try {

				// List<Employee> list = empDao.search();
				// request.setAttribute("list", list);
				response.sendRedirect("emp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void modifyBatch2(HttpServletRequest request, HttpServletResponse response) {

		String emps = request.getParameter("emps");
		String[] array = emps.split(";");
		List<Employee> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			String[] temp = array[i].split(",");
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(temp[0]));
			emp.setName(temp[1]);
			emp.setSex(temp[2]);
			emp.setAge(Integer.parseInt(temp[3]));
			list.add(emp);
		}

		EmployeeDao empDao = new EmployeeDao();
		boolean flag = empDao.modifyBatch2(list);
		if (flag) {

			try {

				// List<Employee> list = empDao.search();
				// request.setAttribute("list", list);
				response.sendRedirect("emp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void modifyBatch3(HttpServletRequest request, HttpServletResponse response) {

		String emps = request.getParameter("emps");
		JSONArray jsonArray = JSONArray.fromObject(emps);
		List<Employee> list = (List<Employee>) JSONArray.toCollection(jsonArray, Employee.class);

		EmployeeDao empDao = new EmployeeDao();
		boolean flag = empDao.modifyBatch2(list);
		if (flag) {

			try {

				// List<Employee> list = empDao.search();
				// request.setAttribute("list", list);
				response.sendRedirect("emp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDao empDao = new EmployeeDao();
		boolean flag = empDao.delete(id);
		if (flag) {

			try {

				response.sendRedirect("emp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void deleteBatch(HttpServletRequest request, HttpServletResponse response) {

		String ids = request.getParameter("ids");

		EmployeeDao empDao = new EmployeeDao();
		boolean flag = empDao.deleteBatch(ids);
		if (flag) {

			try {

				response.sendRedirect("emp");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
