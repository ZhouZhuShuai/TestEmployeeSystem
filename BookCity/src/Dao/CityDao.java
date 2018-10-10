package Dao;

import java.util.List;

import Entity.City;

public interface CityDao {
	public List<City> searchAll(Integer father);

}
