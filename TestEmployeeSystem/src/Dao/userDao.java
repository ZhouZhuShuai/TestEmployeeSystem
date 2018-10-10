package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import Entity.User;

public class userDao  {
		public boolean search( User user) {
			boolean flag = false;
			Connection conn = null;
			ResultSet rs = null;
			PreparedStatement pstat = null;
			try {
			Class.forName("com.mysql.jdbc.Driver") ;
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123"); 
			String sql = "select * from user where username=? and password=?";

			 pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			 rs = pstat.executeQuery();
			
			
			if(rs.next()) {
				flag = true;
			}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
					try {
						conn.close();
					
					pstat.close();
					rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
			
			
			
			
			return flag;
		}

		public boolean add(User user) {
			
			Connection conn = null;
			int rs = 0;
			PreparedStatement pstat = null;
			try {
			Class.forName("com.mysql.jdbc.Driver") ;
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?characterEncoding=utf-8","root","123"); 
			String sql = "insert into user(username,password) values(?,?)";

			 pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			 rs = pstat.executeUpdate();
			
			
			

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				
					try {
						conn.close();
					
					pstat.close();
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			}
			
			
			
			
			return rs>0;
		}
}
