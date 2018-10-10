package Dao;

import org.apache.ibatis.annotations.Param;

import Entity.User;

public interface UserDao {
	public int searchByUserNameAndPassword(@Param("username")String username,@Param("password")String password);
	public User searchByusername(String username);
}
