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
import Entity.Employee;

public class EmployeeDao {
	List<Employee> list = new ArrayList<>();

	public List<Employee> search() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "123");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from employee  ");
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				list.add(emp);
			}
			

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		

	} 
	public int searchCount() {
		int count=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "123");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select count(*) from employee  ");
			
		if (rs.next()) {
				
				count=rs.getInt(1);
				
			}
			

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		

	}
	
	public int searchCount(Employee emp) {
		int count=0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			String where=" where 1=1 ";
			if (emp.getName()!=null&&emp.getName().length() != 0) {
				where += " and name='" + emp.getName() + "'";
			}
			if (emp.getSex()!=null&&emp.getSex().length() != 0) {
				where += " and sex='" + emp.getSex() + "'";
			}
			if (emp.getAge() != -1) {
				where += " and age=" + emp.getAge();
			}
			if (emp.getDep().getId() != 0) {
				where += " and d_id=" + emp.getDep().getId();
			}
			
			String sql = "select count(*) from employee "+where;
			
			ResultSet rs = stat.executeQuery(sql);
			
		   if (rs.next()) {
				
				count=rs.getInt(1);
				
			}
		  System.out.println(count);
		  System.out.println(sql);

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		

	}
	
	public List<Employee> search(int begin,int size) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "123");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from employee limit "+begin+","+size+" ");
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSex(rs.getString("sex"));
				list.add(emp);
			}
			

			rs.close();
			stat.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		

	}
	
	
	public boolean add(Employee emp) {
       boolean flag = false;
       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			int rs=0;
			if(emp.getDep().getId()==null) {
				 rs = stat.executeUpdate("insert into employee(name,sex,age,photo) values ('"+emp.getName()+"','"+emp.getSex()+"','"+emp.getAge()+"','"+emp.getPhoto()+"')");

			}else {
				 rs = stat.executeUpdate("insert into employee(name,sex,age,d_id,photo) values ('"+emp.getName()+"','"+emp.getSex()+"','"+emp.getAge()+"','"+emp.getDep().getId()+"','"+emp.getPhoto()+"')");

			}
			
			if(rs>0) {
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
	
	
	public boolean modify(Employee emp) {
	       boolean flag = false;
	       
			try {
				
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
				Statement stat = conn.createStatement();
				int rs = 0;
				PreparedStatement psata = null;
				String sql = "update employee set name=?,sex=?,age=?,d_id=? where id=?";
				psata =  conn.prepareStatement(sql);
				psata.setString(1, emp.getName());
				psata.setString(2, emp.getSex());
				psata.setInt(3, emp.getAge());
				psata.setObject(4, emp.getDep().getId());
				psata.setInt(5, emp.getId());
				rs = psata.executeUpdate();
				
				
				if(rs>0) {
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
	
	public Employee searchById(int id) {
	    Employee emp = new Employee();
	    
			try {
				
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery("select e.*,d.name as dName from employee as e left join department as d on e.d_id=d.id where e.id='"+id+"'");
				
				while(rs.next()) {
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setSex(rs.getString("sex"));
					emp.setAge(rs.getInt("age"));
					Department dep = new Department();
					dep.setId(rs.getInt("d_id"));
					dep.setName(rs.getString("dName"));
					emp.setDep(dep);
					
				}
			
				
				

				
				stat.close();
				conn.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return emp;

		}  
	
	
	public boolean delete(int id) {
	       boolean flag = false;
	       
			try {
				
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
				Statement stat = conn.createStatement();
				int rs = stat.executeUpdate("delete  from employee where id='"+id+"' ");
				
				if(rs>0) {
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
	public boolean deleteBatch(String ids) {
		boolean flag = false;
	       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			int rs = stat.executeUpdate("delete  from employee where id in ("+ids+")");
			
			if(rs>0) {
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
	public List<Employee> searchByIds(String ids) {
		 List<Employee> list = new ArrayList<>();
		    
			try {
				
				Class.forName("com.mysql.jdbc.Driver");

				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery("select * from employee where id in("+ids+")");
				
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt("id"));
					emp.setName(rs.getString("name"));
					emp.setSex(rs.getString("sex"));
					emp.setAge(rs.getInt("age"));
					list.add(emp);
				}
			
				
				

				
				stat.close();
				conn.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return list;
	}
	public boolean modifyBatch1( String ids,Employee emp) {
		boolean flag = false;
	       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			int rs = stat.executeUpdate("update employee set name='"+emp.getName()+"',sex='"+emp.getSex()+"', age='"+emp.getAge()+"' where id in("+ids+")");
			
			if(rs>0) {
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
	public boolean modifyBatch2(List<Employee> list2) {
		boolean flag = false;
	       
		try {
			
			Class.forName("com.mysql.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			Statement stat = conn.createStatement();
			for(int i = 0;i<list2.size();i++) {
				int rs = stat.executeUpdate("update employee set name='"+list2.get(i).getName()+"',sex='"+list2.get(i).getSex()+"', age='"+list2.get(i).getAge()+"' where id ="+list2.get(i).getId()+"");
			
			
			
			if(rs>0) {
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
	public String sqlConcat(Employee emp ,int begin,int size) {

		
		String where = " where 1=1 ";
		if (emp.getName()!=null&&emp.getName().length() != 0) {
			where += " and e.name='" + emp.getName() + "'";
		}
		if (emp.getSex()!=null&&emp.getSex().length() != 0) {
			where += " and sex='" + emp.getSex() + "'";
		}
		if (emp.getAge() != -1) {
			where += " and age=" + emp.getAge();
		}
		if (emp.getDep().getId() != 0) {
			where += " and d_id=" + emp.getDep().getId();
		}
		
		String sql = "select e.*,d.name as dName,emp_count from employee as e left join department as d on e.d_id=d.id "+where +" limit "+begin+","+size;

		System.out.println(sql);
		return sql;
	}
	
	
	public List<Employee> search06(Employee emp,int begin,int size) {
		List<Employee> list = new ArrayList<>();
		
			// 2利用反射,加载数据库驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			// 3建立连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8", "root", "123");
			// 4建立statement sql语句执行器
			Statement stat = conn.createStatement();
			// 5执行sql语句 并得到结果、
			ResultSet rs = stat.executeQuery(sqlConcat(emp,begin,size));
			// 6对结果集进行处理
			while (rs.next()) {
				Employee emp2 = new Employee();
				emp2.setId(rs.getInt("id"));
				emp2.setName(rs.getString("name"));
				emp2.setSex(rs.getString("sex"));
				emp2.setAge(rs.getInt("age"));
				emp2.setPhoto(rs.getString("photo"));
				Department dep = new Department();
				dep.setId(rs.getInt("d_id"));
				dep.setName(rs.getString("dName"));
				dep.setEmpCount(rs.getInt("emp_count"));
				emp2.setDep(dep);
				
				list.add(emp2);
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
