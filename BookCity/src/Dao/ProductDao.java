package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import Entity.Product;



public interface ProductDao {
	public int searchCount(@Param("product")Product product);
	public List<Product> search(@Param("product")Product product, @Param("begin")int begin, @Param("size")int size);
	public Product searchById(Integer id);
}
