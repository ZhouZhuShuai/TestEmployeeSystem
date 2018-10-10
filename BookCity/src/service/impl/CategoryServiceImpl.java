package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CategoryDao;
import Entity.Category;
import service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	@Override
	public List<Category> search() {
		List<Category> list = categoryDao.search();
		return list;
	}
	

}
