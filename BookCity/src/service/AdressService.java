package service;

import java.util.List;

import Entity.Adress;

public interface AdressService {

	public List<Adress> searchByUserId(int user_id);

	public boolean add(Adress adress);

	public boolean deleteById(int id);
	

}
