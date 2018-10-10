package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.ProductDao;
import Entity.Product;
import service.ProductService;
@Service
public class ProductServiceImpl implements 	ProductService {
	@Autowired
	ProductDao productDao;
	
	@Override
	public int searchCount(Product product) {
		int count = productDao.searchCount(product);
		return count;
	}

	@Override
	public List<Product> search(Product product, int begin, int size) {
			List<Product> list = productDao.search(product, begin, size);
		return list;
	}

	@Override
	public Product searchById(Integer id) {
		Product product = productDao.searchById(id);
		return product;
	}
	
//	@Autowired
//	DepartmentDao depDao;
//	@Autowired
//	EmployeeDao empDao;
//	@Override
//	public int searchCount(Department dep) {
//	
//		int count = depDao.searchCount(dep);
//		
//		return count;
//	}
//
//	@Override
//	public List<Department> searchAll() {
//		
//		List<Department> list = depDao.searchAll();
//		
//		return list;
//	}
//
//	@Override
//	public List<Department> search(Department dep, int begin, int size) {
//		
//		List<Department> list = depDao.search(dep, begin, size);
//		
//		return list;
//	}
//
//	@Override
//	public boolean add(String name) {
//		
//		int rs = depDao.add(name);
//	
//		return rs > 0;
//	}
//
//	@Override
//	public boolean delete(String ids) {
//		int rs = 0;
//		
//
//	
//			
//	
//		
//
//		 rs = depDao.delete(ids);
//		rs = empDao.deleteDepId(ids);
//
//		
//		
//		return rs > 0;
//		
//	}

}
