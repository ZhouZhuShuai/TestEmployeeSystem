package Dao;

import java.util.List;

import Entity.Area;

public interface AreaDao {
	public List<Area> searchAll(Integer father) ;
}
