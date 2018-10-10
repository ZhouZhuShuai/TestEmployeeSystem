package service;

import java.util.List;

import Entity.Photo;

public interface PhotoService {
	

	public List<Photo> searchByProductId(Integer id);

}
