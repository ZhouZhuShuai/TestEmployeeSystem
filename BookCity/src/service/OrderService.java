package service;

import java.sql.Timestamp;
import java.util.List;

import Entity.Order1;
import util.GenerateOrderNo;

public interface OrderService {

public	boolean add(Order1 order1);

public List<Order1> searchByUserId(int user_id);
	

}
