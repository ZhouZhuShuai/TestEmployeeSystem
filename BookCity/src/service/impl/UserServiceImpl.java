package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CategoryDao;
import Dao.UserDao;
import Entity.Category;
import Entity.User;
import service.CategoryService;
import service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public boolean searchByUserNameAndPassword(String username, String password) {
		boolean flag = false;
		int count = userDao.searchByUserNameAndPassword(username, password);
		if(count>0) {
			flag = true;
		}
		return flag;
	}

	@Override
	public User searchByusername(String username) {
		User user = userDao.searchByusername(username);
		return user;
	}
	
	
	

}
