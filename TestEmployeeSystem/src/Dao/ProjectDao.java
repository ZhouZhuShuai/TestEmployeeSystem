package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Department;
import Entity.Project;

//对数据库的增删改查存取 要放到Dao类中 这是JAVA的一个标准；
public class ProjectDao {
	public int searchCount(Project pro) {
		int count=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			String where=" where 1=1 ";
			if (pro.getName()!=null&&pro.getName().length() != 0) {
				where += " and name='" + pro.getName() + "'";
			}
			
//			if (dep.getEmpCount() != -1) {
//				where += " and ifnull(emp_count,0)=" + dep.getEmpCount();
//			}
			String sql = "select count(*) from project "+where;
			
			ResultSet rs = stat.executeQuery(sql);
			
		   if (rs.next()) {
				
				count=rs.getInt(1);
				
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
	public List<Project> search(Project pro, int begin, int size) {
		List<Project> list = new ArrayList<>();
		
		// 2利用反射,加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			String where=" where 1=1 ";
			if (pro.getName()!=null&&pro.getName().length() != 0) {
				where += " and name='" + pro.getName() + "'";
			}
			
//			if (dep.getEmpCount() != -1) {
//				where += " and ifnull(emp_count,0)=" + dep.getEmpCount();
//			}
			String sql = "select * from project "+where +" limit "+begin+","+size;
			System.out.println(sql);
			ResultSet rs = stat.executeQuery(sql);
		// 6对结果集进行处理
		while (rs.next()) {
			Project pro2 = new Project();
			pro2.setId(rs.getInt("id"));
			pro2.setName(rs.getString("name"));

			
			list.add(pro2);
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

	public boolean add(Project pro) {
    boolean flag = false;
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123");
			//4建立statement sql语句执行器
			Statement stat= conn.createStatement();
			//5执行sql语句 并得到结果、
		
		int rs = stat.executeUpdate("insert into Project(name)values('"+pro.getName()+"')");
			//6对结果集进行处理
		
			if(rs>0) {
				flag = true;
				
			}
			
			//7关闭
			
			stat.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean add2(Project pro,int id3) {
	    boolean flag = false;
			try {
				// 2利用反射,加载数据库驱动
				Class.forName("com.mysql.jdbc.Driver");
				// 3建立连接
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123");
				//4建立statement sql语句执行器
				Statement stat= conn.createStatement();
				//5执行sql语句 并得到结果、
			String sql = "insert into r_dep_pro(d_id,p_id)values("+pro.getId()+","+id3+")";
			    int rs = stat.executeUpdate(sql);
			    System.out.println(sql);
				//6对结果集进行处理
			
				if(rs>0) {
					flag = true;
					
				}
				
				//7关闭
				
				stat.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
	
	
	
	public boolean delete(String ids) {
		boolean flag = false;
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
		
			conn.setAutoCommit(false);	
			int  rs = stat.executeUpdate("delete  from Project where id in ("+ids+")  ");
			
			rs = stat.executeUpdate("delete from r_dep_pro where p_id in ("+ids+") ");
			conn.commit();
			conn.setAutoCommit(true);
			// 6对结果集进行处理
			if(rs>0) {
				flag = true;
				
			}
			
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
		
		return flag;

	}
	
	public boolean delete2(int id,int id2) {
		boolean flag = false;
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
		
			
			int  rs = stat.executeUpdate("delete  from r_dep_pro where p_id = "+id+" and d_id="+id2+" ");
			
			
			
			// 6对结果集进行处理
			if(rs>0) {
				flag = true;
				
			}
			
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
		
		return flag;

	}
	
	
	public boolean modify(List<Project> list) {
		boolean flag = false;
				try {
					// 2利用反射,加载数据库驱动
					Class.forName("com.mysql.jdbc.Driver");
					// 3建立连接
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123");
					//4建立statement sql语句执行器
					Statement stat= conn.createStatement();
					//5执行sql语句 并得到结果、
					String sql;
					for(int i=0;i<list.size();i++) {
					sql = "update Project set name=? where id=?";
				
					PreparedStatement p =conn.prepareStatement(sql);
					p.setString(1, list.get(i).getName());
					p.setInt(2, list.get(i).getId());
					
				    int rs = p.executeUpdate();
					//6对结果集进行处理
				
					if(rs>0) {
						flag = true;
						
					}
					}
					//7关闭
					
					stat.close();
					conn.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return flag;
			}
	
	
	//搜索的sql 语句
	public String sqlConcat(Project e1) {

		String sql = "select * from Project where 1=1";
		
		if (e1.getName().length() != 0) {
			sql += " and name='" + e1.getName() + "'";
		}
		
		
		System.out.println(sql);
		return sql;
	}
	
	
	public List<Project> rsearch(Project e2) {
		List<Project> list = new ArrayList<>();
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
			ResultSet rs = stat.executeQuery(sqlConcat(e2));
			// 6对结果集进行处理
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				
				
				list.add(pro);
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
	
	
	
	public String sqlConcat2(Project e3) {
		

		String sql = "select p.id,p.name from department as d LEFT JOIN r_dep_pro as r on d.id=d_id LEFT JOIN project as p on p.id=p_id where d.id="+e3.getId()+"";
		
		
		
		
		System.out.println(sql);
		return sql;
	}
	
	
	public List<Project> projectsearch(Project e4) {
		List<Project> list = new ArrayList<>();
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
			ResultSet rs = stat.executeQuery(sqlConcat2(e4));
			// 6对结果集进行处理
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				
				
				list.add(pro);
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
	
	

	public String sqlConcat3(Project e5) {
		

		String sql = "select id,name from project where id not in (select p_id from v_dep_pro where d_id="+e5.getId()+" )";
		
		
		
		
		System.out.println(sql);
		return sql;
	}
	
	
	public List<Project> notprojectsearch(Project e6) {
		List<Project> list = new ArrayList<>();
		try {
			// 2利用反射,加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
			ResultSet rs = stat.executeQuery(sqlConcat3(e6));
			// 6对结果集进行处理
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));
				
				
				list.add(pro);
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
	public List<Project> searchAll() {
		List<Project> list = new ArrayList<>();

		// 2利用反射,加载数据库驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8",
					"root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
			ResultSet rs = stat.executeQuery("select * from project ");
			// 6对结果集进行处理
			while (rs.next()) {
				Project pro = new Project();
				pro.setId(rs.getInt("id"));
				pro.setName(rs.getString("name"));

				
				list.add(pro);
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
	
	
	
	
	
}


