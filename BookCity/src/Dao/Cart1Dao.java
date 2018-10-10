package Dao;

import org.apache.ibatis.annotations.Param;

import Entity.Cart1;

public interface Cart1Dao {
	public Cart1 searchByUserId(int user_id);
	public int updateZongji(@Param("zongji")int zongji,@Param("cart1_id") int cart1_id);
}
