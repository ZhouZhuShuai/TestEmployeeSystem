package Dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import Entity.Order1;
import util.GenerateOrderNo;

public interface OrderDao {
	public int add(@Param("order1")Order1 order1); 
	public List<Order1> searchByUserId(@Param("user_id")int user_id);
}
