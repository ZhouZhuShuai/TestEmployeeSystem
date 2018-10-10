package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Department;
import Entity.Employee;
import Entity.Project;
import Entity.Score;

public class ScoreDao {

	public int searchCount(Score sco) {
		int count = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			Statement stat = conn.createStatement();
			String where = " where 1=1 ";
			if (sco.getEmp().getName() != null && sco.getEmp().getName().length() != 0) {
				where += " and e.name='" + sco.getEmp().getName() + "'";
			}

			if (sco.getValue() != -1) {
				where += " and s.value=" + sco.getValue();
			}
			if (sco.getDep().getId() != -1) {
				where += " and d.id=" + sco.getDep().getId();
			}
			if (sco.getGrade() != null && sco.getGrade().length() != 0) {
				where += " and s.grade='" + sco.getGrade() + "'";
			}
			if (sco.getPro().getId() != -1) {
				where += " and p.id=" + sco.getPro().getId();
			}
			String sql = "select count(*) \r\n" + "from employee as e \r\n"
					+ "left join department as d on d.id = e.d_id \r\n"
					+ "left join r_dep_pro as r on d.id = r.d_id \r\n" + "left join project as p on p.id = r.p_id \r\n"
					+ "left join score as s on e.id = s.e_id and p.id = s.p_id " + where;

			ResultSet rs = stat.executeQuery(sql);

			if (rs.next()) {

				count = rs.getInt(1);

			}
			System.out.println(count);

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return count;
	}

	// public Department searchById(int id) {
	// Department dep = new Department();
	//
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root",
	// "123");
	// Statement stat = conn.createStatement();
	// ResultSet rs = stat.executeQuery("select * from department where id = '" + id
	// + "' ");
	//
	// while (rs.next()) {
	// dep.setId(rs.getInt("id"));
	// dep.setName(rs.getString("name"));
	//
	// dep.setEmpCount(rs.getInt("emp_count"));
	//
	// }
	//
	// rs.close();
	// stat.close();
	// conn.close();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return dep;
	//
	// }
	//
	// public boolean add(Department dep) {
	// boolean flag = false;
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// Statement stat = conn.createStatement();
	// String sql = "insert into Department(name)values('" + dep.getName() + "')";
	// int rs = stat.executeUpdate(sql);
	//
	// if (rs > 0) {
	// flag = true;
	// }
	//
	// stat.close();
	// conn.close();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return flag;
	// }
	//
	// public boolean delete(String ids) {
	// boolean flag = false;
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// Statement stat = conn.createStatement();
	// conn.setAutoCommit(false);
	// String sql = "delete from department where id in (" + ids + ")";
	// int rs = stat.executeUpdate(sql);
	// sql = "update employee set d_id=null where d_id in (" + ids + ")";
	// rs = stat.executeUpdate(sql);
	// sql = "delete from r_dep_pro where d_id in (" + ids + ")";
	// rs = stat.executeUpdate(sql);
	// conn.commit();
	// if (rs > 0) {
	// flag = true;
	// }
	//
	// stat.close();
	// conn.close();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return flag;
	// }
	//
	// public boolean modify(List<Department> list) {
	// boolean flag = false;
	//
	// try {
	//
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// Statement stat = conn.createStatement();
	// for (int i = 0; i < list.size(); i++) {
	// int rs = stat.executeUpdate("update department set name='" +
	// list.get(i).getName() + "', emp_count='"
	// + list.get(i).getEmpCount() + "' where id =" + list.get(i).getId() + "");
	//
	// if (rs > 0) {
	// flag = true;
	//
	// }
	// }
	// stat.close();
	// conn.close();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return flag;
	// }
	//
	// public int searchCount(Department dep) {
	// int count = 0;
	// try {
	//
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// Statement stat = conn.createStatement();
	// String where = " where 1=1 ";
	// if (dep.getName() != null && dep.getName().length() != 0) {
	// where += " and name='" + dep.getName() + "'";
	// }
	//
	// if (dep.getEmpCount() != -1) {
	// where += " and ifnull(emp_count,0)=" + dep.getEmpCount();
	// }
	// String sql = "select count(*) from department " + where;
	//
	// ResultSet rs = stat.executeQuery(sql);
	//
	// if (rs.next()) {
	//
	// count = rs.getInt(1);
	//
	// }
	// System.out.println(count);
	//
	// rs.close();
	// stat.close();
	// conn.close();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return count;
	// }
	//
	// public String sqlConcat(Department dep, int begin, int size) {
	//
	// String where = "where 1=1 ";
	// if (dep.getName() != null && dep.getName().length() != 0) {
	// where += " and name='" + dep.getName() + "'";
	// }
	//
	// if (dep.getEmpCount() != -1) {
	// where += " and ifnull(emp_count,0)=" + dep.getEmpCount();
	// }
	// String sql = "select * from department " + where + " limit " + begin + "," +
	// size;
	//
	// System.out.println(sql);
	// return sql;
	// }
	//
	// public List<Department> search(Department dep, int begin, int size) {
	// List<Department> list = new ArrayList<>();
	//
	// // 2利用反射,加载数据库驱动
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	// ResultSet rs = stat.executeQuery(sqlConcat(dep, begin, size));
	// // 6对结果集进行处理
	// while (rs.next()) {
	// Department dep2 = new Department();
	// dep2.setId(rs.getInt("id"));
	// dep2.setName(rs.getString("name"));
	//
	// dep2.setEmpCount(rs.getInt("emp_count"));
	// list.add(dep2);
	// }
	//
	// // 7关闭
	// rs.close();
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return list;
	// }
	//
	// public List<Department> searchAll() {
	// List<Department> list = new ArrayList<>();
	//
	// // 2利用反射,加载数据库驱动
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	//
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	// ResultSet rs = stat.executeQuery("select * from department ");
	// // 6对结果集进行处理
	// while (rs.next()) {
	// Department dep2 = new Department();
	// dep2.setId(rs.getInt("id"));
	// dep2.setName(rs.getString("name"));
	//
	// dep2.setEmpCount(rs.getInt("emp_count"));
	// list.add(dep2);
	// }
	//
	// // 7关闭
	// rs.close();
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return list;
	// }
	//
	// public List<Project> searchProject(int id) {
	// List<Project> list = new ArrayList<>();
	// try {
	// // 2利用反射,加载数据库驱动
	// Class.forName("com.mysql.jdbc.Driver");
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	// String sql = "select p.id,p.name from department as d LEFT JOIN r_dep_pro as
	// r on d.id=d_id LEFT JOIN project as p on p.id=p_id where d.id="
	// + id + "";
	//
	// ResultSet rs = stat.executeQuery(sql);
	// // 6对结果集进行处理
	// while (rs.next()) {
	// Project pro = new Project();
	// pro.setId(rs.getInt("id"));
	// pro.setName(rs.getString("name"));
	//
	// list.add(pro);
	// }
	//
	// // 7关闭
	// rs.close();
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return list;
	//
	// }
	//
	// public List<Project> searchNotSelect(int id) {
	// List<Project> list2 = new ArrayList<>();
	// try {
	//
	// // 2利用反射,加载数据库驱动
	// Class.forName("com.mysql.jdbc.Driver");
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	//
	// String sql = "select id,name from project where id not in(select p_id from
	// v_dep_pro where d_id=" + id
	// + ")";
	//
	// ResultSet rs = stat.executeQuery(sql);
	// // 6对结果集进行处理
	// while (rs.next()) {
	// Project pro = new Project();
	// pro.setId(rs.getInt("id"));
	// pro.setName(rs.getString("name"));
	//
	// list2.add(pro);
	// }
	//
	// // 7关闭
	// rs.close();
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return list2;
	//
	// }
	//
	public int add(int empId, int proId, int value) {
		int id = 0;
		int rs = 0;
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
			String sql = "insert into score(e_id,p_id,value)values(" + empId + "," + proId + "," + value + ")";
			rs = stat.executeUpdate(sql);
			String sql2 = "select LAST_INSERT_ID()";
			ResultSet rs2 = stat.executeQuery(sql2);
			while (rs2.next()) {
				id = rs2.getInt(1);

			}

			// 6对结果集进行处理

			// 7关闭

			stat.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	//
	// public boolean add_projects(int id, String[] proIds) {
	// boolean flag = false;
	// try {
	// // 2利用反射,加载数据库驱动
	// Class.forName("com.mysql.jdbc.Driver");
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	// for (int i = 0; i < proIds.length; i++) {
	// String sql = "insert into r_dep_pro(d_id,p_id)values(" + id + "," + proIds[i]
	// + ")";
	// int rs = stat.executeUpdate(sql);
	// System.out.println(sql);
	// // 6对结果集进行处理
	//
	// if (rs > 0) {
	// flag = true;
	//
	// }
	//
	// }
	//
	// // 7关闭
	//
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return flag;
	// }
	//
	// public boolean delete_project(int id, int proId) {
	// boolean flag = false;
	// try {
	// // 2利用反射,加载数据库驱动
	// Class.forName("com.mysql.jdbc.Driver");
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	// String sql = "delete from r_dep_pro where p_id = " + proId + " and d_id=" +
	// id + " ";
	// int rs = stat.executeUpdate(sql);
	// System.out.println(sql);
	// // 6对结果集进行处理
	//
	// if (rs > 0) {
	// flag = true;
	//
	// }
	//
	// // 7关闭
	//
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return flag;
	// }
	//
	// public boolean delete_projects(int id, String proIds) {
	// boolean flag = false;
	// try {
	// // 2利用反射,加载数据库驱动
	// Class.forName("com.mysql.jdbc.Driver");
	// // 3建立连接
	// Connection conn =
	// DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
	// "root", "123");
	// // 4建立statement sql语句执行器
	// Statement stat = conn.createStatement();
	// // 5执行sql语句 并得到结果、
	// String sql = "delete from r_dep_pro where p_id in (" + proIds + ") and d_id="
	// + id + " ";
	// int rs = stat.executeUpdate(sql);
	// System.out.println(sql);
	// // 6对结果集进行处理
	//
	// if (rs > 0) {
	// flag = true;
	//
	// }
	//
	// stat.close();
	// conn.close();
	// } catch (ClassNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return flag;
	// }

	public List<Score> search(Score sco, int begin, int size) {
		List<Score> list = new ArrayList<>();

		// 2利用反射,加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			String where = " where 1=1 ";
			if (sco.getEmp().getName() != null && sco.getEmp().getName().length() != 0) {
				where += " and e.name='" + sco.getEmp().getName() + "'";
			}

			if (sco.getValue() != -1) {
				where += " and s.value=" + sco.getValue();
			}
			if (sco.getDep().getId() != -1) {
				where += " and d.id=" + sco.getDep().getId();
			}
			if (sco.getGrade() != null && sco.getGrade().length() != 0) {
				where += " and s.grade='" + sco.getGrade() + "'";
			}
			if (sco.getPro().getId() != -1) {
				where += " and p.id=" + sco.getPro().getId();
			}
			String sql = "select e.name as empName,s.id as s_Id,e.id as e_Id,p.id as p_Id,d.id as d_id,d.name as depName,p.name as proName,s.value,s.grade \r\n"
					+ "from employee as e \r\n" + "left join department as d on d.id = e.d_id \r\n"
					+ "left join r_dep_pro as r on d.id = r.d_id \r\n" + "left join project as p on p.id = r.p_id \r\n"
					+ "left join score as s on e.id = s.e_id and p.id = s.p_id " + where + " limit " + begin + ","
					+ size;

			ResultSet rs = stat.executeQuery(sql);
			// 5执行sql语句 并得到结果、
			// ResultSet rs = stat.executeQuery(sqlConcat(sco, begin, size));
			// 6对结果集进行处理
			while (rs.next()) {
				Score sco2 = new Score();
				Employee emp = new Employee();
				Project pro = new Project();
				Department dep = new Department();
				dep.setId(rs.getInt("d_Id"));
				dep.setName(rs.getString("depName"));
				emp.setId(rs.getInt("e_Id"));
				emp.setName(rs.getString("empName"));
				pro.setId(rs.getInt("p_Id"));
				pro.setName(rs.getString("proName"));
				sco2.setDep(dep);
				sco2.setEmp(emp);
				sco2.setPro(pro);
				sco2.setGrade(rs.getString("grade"));
				sco2.setValue(rs.getInt("value"));
				sco2.setId(rs.getInt("s_Id"));

				list.add(sco2);
			}

			// 7关闭
			rs.close();
			stat.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean update(List<Score> list) {
		boolean flag = false;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			Statement stat = conn.createStatement();
			for (int i = 0; i < list.size(); i++) {
				int rs = stat.executeUpdate(
						"update score set value=" + list.get(i).getValue() + " where id =" + list.get(i).getId() + "");

				if (rs > 0) {
					flag = true;

				}
			}
			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public boolean update(int scoreId, int value) {
		boolean flag = false;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			Statement stat = conn.createStatement();

			int rs = stat.executeUpdate("update score set value=" + value + " where id =" + scoreId + "");

			if (rs > 0) {
				flag = true;

			}

			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;

	}

	public Score search(int id) {
		Score sco2 = new Score();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();

			String sql = "select e.name as empName,s.id as s_Id,e.id as e_Id,p.id as p_Id,d.id as d_id,d.name as depName,p.name as proName,s.value,s.grade \r\n"
					+ "from employee as e \r\n" + "left join department as d on d.id = e.d_id \r\n"
					+ "left join r_dep_pro as r on d.id = r.d_id \r\n" + "left join project as p on p.id = r.p_id \r\n"
					+ "left join score as s on e.id = s.e_id and p.id = s.p_id where s.id=" + id;

			ResultSet rs = stat.executeQuery(sql);
			// 5执行sql语句 并得到结果、
			// ResultSet rs = stat.executeQuery(sqlConcat(sco, begin, size));
			// 6对结果集进行处理
			while (rs.next()) {

				Employee emp = new Employee();
				Project pro = new Project();
				Department dep = new Department();
				dep.setId(rs.getInt("d_Id"));
				dep.setName(rs.getString("depName"));
				emp.setId(rs.getInt("e_Id"));
				emp.setName(rs.getString("empName"));
				pro.setId(rs.getInt("p_Id"));
				pro.setName(rs.getString("proName"));
				sco2.setDep(dep);
				sco2.setEmp(emp);
				sco2.setPro(pro);
				sco2.setGrade(rs.getString("grade"));
				sco2.setValue(rs.getInt("value"));
				sco2.setId(rs.getInt("s_Id"));

			}

			// 7关闭
			rs.close();
			stat.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sco2;
	}

}
