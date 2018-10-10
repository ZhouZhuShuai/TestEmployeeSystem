package service;

import java.util.List;

import Entity.Cart2;

public interface Cart2Service {

	

	public boolean add(int product_id, int count, int cart1_id,double xiaoji);

	public List<Cart2> searchBycart1Id(int cart1_id);

	public int searchByCart1_idAndProduct_id(int cart1_id, int product_id);

	public int searchCount(int product_id, int cart1_id);

	public boolean update(int product_id, int count4, int cart1_id,double xiaoji);

	public boolean updateCountAndXiaoji(int count, double xiaoji, int cart2Id);

	public List<Cart2> searchByIds(String ids);

	public boolean deleteById(int cart2Id);

	public boolean deleteByIds(String cart2Ids);

	public Cart2 searchById(int id);


	



}
