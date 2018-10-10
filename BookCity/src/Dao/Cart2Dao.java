package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import Entity.Cart2;

public interface Cart2Dao {
	public int add(@Param("product_id")int product_id, @Param("count")int count, @Param("cart1_id")int cart1_id,@Param("xiaoji") double xiaoji);
	public List<Cart2> searchBycart1Id(int cart1_id);
	public int searchCount(@Param("cart1_id")int cart1_id,@Param("product_id") int product_id);
	public int searchByCart1_idAndProduct_id(@Param("cart1_id")int cart1_id,@Param("product_id") int product_id);
	public int update(@Param("product_id")int product_id, @Param("count4")int count4, @Param("cart1_id")int cart1_id,@Param("xiaoji") double xiaoji);
	public int updateCountAndXiaoji(@Param("count")int count, @Param("xiaoji")double xiaoji, @Param("cart2Id")int cart2Id);
	public List<Cart2> searchByIds(@Param("ids")String ids);
	public int deleteById(int cart2Id);
	public int deleteByIds(@Param("cart2Ids")String cart2Ids);
	public Cart2 searchById(int id);
}
