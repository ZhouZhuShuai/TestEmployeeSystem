package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.Cart1Dao;
import Dao.CategoryDao;
import Dao.UserDao;
import Entity.Cart1;
import Entity.Category;
import Entity.User;
import service.Cart1Service;
import service.CategoryService;
import service.UserService;
@Service
public class Cart1ServiceImpl implements Cart1Service{
	@Autowired
	Cart1Dao cart1Dao;

	@Override
	public Cart1 searchByUserId(int user_id) {
		Cart1 cart1 = cart1Dao.searchByUserId(user_id);
		return cart1;
	}

	@Override
	public boolean updateZongji(int zongji, int cart1_id) {
		int rs= cart1Dao.updateZongji(zongji, cart1_id);
		return rs>0;
	}
	

	
	

}
