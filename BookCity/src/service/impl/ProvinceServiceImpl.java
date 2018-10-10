package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ProvinceDao;
import Entity.Province;
import service.ProvinceService;
@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Autowired
	ProvinceDao provinceDao;
	@Override
	public List<Province> searchAll() {
		List<Province> provinceList = provinceDao.searchAll();
		return provinceList;
	}
	
	

	

	
	

	
	

}
