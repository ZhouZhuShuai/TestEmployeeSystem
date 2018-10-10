package ServLet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DepartmentDao;
import Dao.ProjectDao;
import Dao.ScoreDao;
import Entity.Department;
import Entity.Employee;
import Entity.Project;
import Entity.Score;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Constant;
import util.Pagination;

public class ScoreServLet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String type = request.getParameter("type");
			if (type == null) {
				showScore(request, response);
			}
			else if ("baocun".equals(type)) {
				baocun(request, response);
			}
			else if ("manage".equals(type)) {
				manage(request, response);
			}
			else if ("input".equals(type)) {
				input(request, response);
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void input(HttpServletRequest request, HttpServletResponse response) {
		try {
		PrintWriter out = response.getWriter();
		
		boolean flag = false;
		int scoreId = Integer.parseInt(request.getParameter("scoreId"));
		if(scoreId==0) {
			int empId = Integer.parseInt(request.getParameter("empId"));
			int proId = Integer.parseInt(request.getParameter("proId"));
			int value = Integer.parseInt(request.getParameter("value"));
			ScoreDao scoDao = new ScoreDao();
			scoreId= scoDao.add(empId,proId,value);
			if(scoreId>0) {
				flag=true;
			}
			
		}else {
			int value = Integer.parseInt(request.getParameter("value"));
			ScoreDao scoDao = new ScoreDao();
			flag =  scoDao.update(scoreId,value);
		}
		Score sco = new Score();
		ScoreDao scoDao = new ScoreDao();
		sco = scoDao.search(scoreId);
		
		if(flag) {
			JSON json  = JSONObject.fromObject(sco);
			out.print(json);
			
		}else {
			out.print(false);
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private void baocun(HttpServletRequest request, HttpServletResponse response) {
		String score_values = request.getParameter("score_value");
		JSONArray jsonArray = JSONArray.fromObject(score_values);
		List<Score> list = (List<Score>) JSONArray.toCollection(jsonArray, Score.class);
		ScoreDao scoDao = new ScoreDao();
		boolean flag = scoDao.update(list);
		if(flag) {
			try {
				response.sendRedirect("score");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	private void showScore(HttpServletRequest request, HttpServletResponse response) {
		try {

			int value = -1;
			if (request.getParameter("value") != null && !"".equals(request.getParameter("value"))) {

				value = Integer.parseInt(request.getParameter("value"));

			}
			int depId = -1;
			if (request.getParameter("depId") != null && !"".equals(request.getParameter("depId"))) {

				depId = Integer.parseInt(request.getParameter("depId"));
			}
			int proId = -1;
			if (request.getParameter("proId") != null && !"".equals(request.getParameter("proId"))) {

				proId = Integer.parseInt(request.getParameter("proId"));
			}

			String empname = request.getParameter("name");

			String grade = request.getParameter("grade");
			
			int ye = 1;
			Score sco = new Score();
			Department dep = new Department();
			dep.setId(depId);
			Employee emp = new Employee();
			emp.setName(empname);
			Project pro = new Project();
			pro.setId(proId);
			sco.setDep(dep);
			sco.setEmp(emp);
			sco.setPro(pro);
			sco.setValue(value);
			sco.setGrade(grade);
			ScoreDao scoDao = new ScoreDao();
			if (request.getParameter("ye") != null) {
				ye = Integer.parseInt(request.getParameter("ye"));

			}
			int count = scoDao.searchCount(sco);
			Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE, Constant.EMP_NUM_OF_PAGE);
			List<Score> list = scoDao.search(sco, p.getBegin(), Constant.EMP_NUM_IN_PAGE);
			request.setAttribute("p", p);
			request.setAttribute("list", list);
			request.setAttribute("c", sco);
			DepartmentDao depDao = new DepartmentDao();
			List<Department> depList = depDao.searchAll();
			request.setAttribute("depList", depList);
			ProjectDao proDao = new ProjectDao();
			List<Project> proList = proDao.searchAll();
			request.setAttribute("proList", proList);

			request.getRequestDispatcher("WEB-INF/Score/ScoreList.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void manage(HttpServletRequest request, HttpServletResponse response) {
		try {

			int value = -1;
			if (request.getParameter("value") != null && !"".equals(request.getParameter("value"))) {

				value = Integer.parseInt(request.getParameter("value"));

			}
			int depId = -1;
			if (request.getParameter("depId") != null && !"".equals(request.getParameter("depId"))) {

				depId = Integer.parseInt(request.getParameter("depId"));
			}
			int proId = -1;
			if (request.getParameter("proId") != null && !"".equals(request.getParameter("proId"))) {

				proId = Integer.parseInt(request.getParameter("proId"));
			}

			String empname = request.getParameter("name");

			String grade = request.getParameter("grade");
			
			int ye = 1;
			Score sco = new Score();
			Department dep = new Department();
			dep.setId(depId);
			Employee emp = new Employee();
			emp.setName(empname);
			Project pro = new Project();
			pro.setId(proId);
			sco.setDep(dep);
			sco.setEmp(emp);
			sco.setPro(pro);
			sco.setValue(value);
			sco.setGrade(grade);
			ScoreDao scoDao = new ScoreDao();
			if (request.getParameter("ye") != null) {
				ye = Integer.parseInt(request.getParameter("ye"));

			}
			int count = scoDao.searchCount(sco);
			Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE, Constant.EMP_NUM_OF_PAGE);
			List<Score> list = scoDao.search(sco, p.getBegin(), Constant.EMP_NUM_IN_PAGE);
			request.setAttribute("p", p);
			request.setAttribute("list", list);
			request.setAttribute("c", sco);
			DepartmentDao depDao = new DepartmentDao();
			List<Department> depList = depDao.searchAll();
			request.setAttribute("depList", depList);
			ProjectDao proDao = new ProjectDao();
			List<Project> proList = proDao.searchAll();
			request.setAttribute("proList", proList);

			request.getRequestDispatcher("WEB-INF/Score/ScoreList2.jsp").forward(request, response);
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
