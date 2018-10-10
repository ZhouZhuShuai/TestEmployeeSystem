package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CategoryDao;
import Dao.PhotoDao;
import Entity.Category;
import Entity.Photo;
import service.CategoryService;
import service.PhotoService;
@Service
public class PhotoServiceImpl implements PhotoService{
	@Autowired
	PhotoDao photoDao;

	@Override
	public List<Photo> searchByProductId(Integer id) {
		List<Photo> list = photoDao.searchByProductId(id);
		
		return list;
	}

	

}
