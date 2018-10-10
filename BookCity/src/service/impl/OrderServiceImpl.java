package service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.OrderDao;
import Entity.Order1;
import service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;

	@Override
	public boolean add(Order1 order1) {
		int rs = orderDao.add(order1);
		int order1_id = order1.getId();
		return rs>0;
	}

	@Override
	public List<Order1> searchByUserId(int user_id) {
		List<Order1> list = orderDao.searchByUserId(user_id);
		return list;
	}

}
