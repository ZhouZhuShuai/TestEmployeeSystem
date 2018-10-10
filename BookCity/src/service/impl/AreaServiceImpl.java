package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.AreaDao;
import Entity.Area;
import service.AreaService;
@Service
public class AreaServiceImpl implements AreaService{
	@Autowired
	AreaDao areaDao;

	@Override
	public List<Area> searchAll(Integer father) {
		List<Area> list = areaDao.searchAll(father);
		return list;
	}

	
	
	
	
	

	

	
	

	
	

}
