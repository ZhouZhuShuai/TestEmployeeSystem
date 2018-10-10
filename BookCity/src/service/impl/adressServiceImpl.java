package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.AdressDao;
import Entity.Adress;
import service.AdressService;
@Service
public class adressServiceImpl implements AdressService{
	@Autowired
	AdressDao adressDao;

	@Override
	public List<Adress> searchByUserId(int user_id) {
		List<Adress> list = adressDao.searchByUserId(user_id);
		return list;
	}

	@Override
	public boolean add(Adress adress) {
		int rs=adressDao.add(adress);
		return rs>0;
	}

	@Override
	public boolean deleteById(int id) {
		int rs = adressDao.deleteById(id);
		return rs>0;
	}

	
	

	
	

}
