package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CityDao;
import Entity.City;
import service.CityService;
@Service
public class CityServiceImpl implements CityService{
	@Autowired
	CityDao cityDao;

	@Override
	public List<City> searchAll(Integer father) {
		List<City> list = cityDao.searchAll(father);
		return list;
	}
	
	
	
	

	

	
	

	
	

}
