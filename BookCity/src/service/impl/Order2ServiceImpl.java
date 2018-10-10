package service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.Order2Dao;
import Dao.OrderDao;
import Entity.Order1;
import Entity.Order2;
import service.Order2Service;
import service.OrderService;

@Service
public class Order2ServiceImpl implements Order2Service {
	@Autowired
	Order2Dao order2Dao;

	

	@Override
	public boolean add(Order2 order2) {
		int rs = order2Dao.add(order2);
		
		return rs>0;
	}

	

}
