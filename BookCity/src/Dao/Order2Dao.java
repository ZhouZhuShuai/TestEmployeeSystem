package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Entity.Order2;

public interface Order2Dao {
	
	public List<Order2> searchByOrder1_id(int order1_id);
	public int add(@Param("order2")Order2 order2);
}
