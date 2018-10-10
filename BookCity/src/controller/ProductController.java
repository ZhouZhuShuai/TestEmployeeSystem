package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Entity.Category;
import Entity.Photo;
import Entity.Product;
import service.CategoryService;
import service.PhotoService;
import service.ProductService;
import util.Constant;
import util.Pagination;

@Controller
@RequestMapping(value = "Product")
public class ProductController {
	@Autowired
	ProductService productService ;
	@Autowired
	CategoryService categoryService;
	@Autowired
	PhotoService photoService;
	@RequestMapping(value = "search")

	public ModelAndView test7(Integer ye, Product product) {
		
	
		List<Category> categorylist  = categoryService.search();

		int count = productService.searchCount(product);
		if (ye == null) {
			ye = 1;

		}

		Pagination p = new Pagination(ye, count, Constant.EMP_NUM_IN_PAGE, Constant.EMP_NUM_OF_PAGE);

		List<Product> list = productService.search(product, p.getBegin(), Constant.EMP_NUM_IN_PAGE);
		
		ModelAndView mv = new ModelAndView("Department/shudianliebiao");
		mv.addObject("list", list);
		mv.addObject("product", product);
		
		mv.addObject("categoryList", categorylist);
		mv.addObject("p", p);
		//mv.addObject("c", dep);

		return mv;
	}

	@RequestMapping(value = "ShowShangPinXiangQing")
	public ModelAndView test8(Integer id) {
		Product product = productService.searchById(id);
		List<Photo> photoList = photoService.searchByProductId(id);
		
		
		ModelAndView mv = new ModelAndView("Department/ShangPinXiangQing");
		mv.addObject("product", product);
		mv.addObject("photoList", photoList);
		return mv;
	}


}
