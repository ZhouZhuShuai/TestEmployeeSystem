package Dao;

import java.util.List;

import Entity.Photo;



public interface PhotoDao {
public	List<Photo> searchByProductId(Integer id);  
	
}
