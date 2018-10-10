package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.Cart2Dao;
import Entity.Cart2;
import service.Cart2Service;

@Service
public class Cart2ServiceImpl implements Cart2Service {
	@Autowired
	Cart2Dao cart2Dao; 

	@Override
	public boolean add(int product_id, int count, int cart1_id,double xiaoji) {
		int rs = cart2Dao.add(product_id, count, cart1_id,xiaoji);
		return rs > 0;
	}

	@Override
	public List<Cart2> searchBycart1Id(int cart1_id) {
		List<Cart2> list = cart2Dao.searchBycart1Id(cart1_id);
		return list;
	}

	@Override
	public int searchByCart1_idAndProduct_id(int cart1_id, int product_id) {
		int count2 = cart2Dao.searchByCart1_idAndProduct_id(cart1_id, product_id);
		return count2;
	}

	@Override
	public int searchCount(int product_id, int cart1_id) {
		int count3 = cart2Dao.searchCount(cart1_id, product_id);
		return count3;
	}

	@Override
	public boolean update(int product_id, int count4, int cart1_id,double xiaoji) {
		int rs = cart2Dao.update(product_id, count4, cart1_id,xiaoji);
		return rs>0;
	}

	@Override
	public boolean updateCountAndXiaoji(int count, double xiaoji, int cart2Id) {
		int rs = cart2Dao.updateCountAndXiaoji(count, xiaoji, cart2Id);
		return rs>0;
	}

	@Override
	public List<Cart2> searchByIds(String ids) {
		List<Cart2> list = cart2Dao.searchByIds(ids);
		return list;
	}

	@Override
	public boolean deleteById(int cart2Id) {
		int rs = cart2Dao.deleteById(cart2Id);
		return rs>0;
	}

	@Override
	public boolean deleteByIds(String cart2Ids) {
			int rs = cart2Dao.deleteByIds(cart2Ids);
		return rs>0;
	}

	@Override
	public Cart2 searchById(int id) {
		Cart2 cart2 = cart2Dao.searchById(id);
		return cart2;
	}

}
