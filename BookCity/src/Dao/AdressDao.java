package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Entity.Adress;
import Entity.Cart1;

public interface AdressDao {
	public List<Adress> searchByUserId(int user_id);
	public int add(@Param("adress")Adress adress);
	public int deleteById(int id);
}
