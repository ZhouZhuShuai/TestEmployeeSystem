package service;

import java.util.List;

import Entity.Product;


public interface ProductService {

	public int searchCount(Product product);
//	 public int searchCount(Department dep);
//
//		public List<Department> searchAll();
//
//		public List<Department> search(Department dep, int begin, int size);
//
//		public boolean add(String name);
//
//		public boolean delete(String ids);

	public List<Product> search(Product product, int begin, int empNumInPage);

	public Product searchById(Integer id);
}
