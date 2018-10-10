package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Entity.Cart1;
import Entity.Cart2;
import Entity.Product;
import Entity.User;
import service.Cart1Service;
import service.Cart2Service;
import service.ProductService;
import service.UserService;

@Controller
@RequestMapping(value="Cart")
public class CartController {
	@Autowired
	UserService userService;
	@Autowired
	Cart1Service cart1Service;
	@Autowired
	Cart2Service cart2Service;
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="ShowCart")
	public String showCart(int product_id,int count, HttpServletRequest request) {
		HttpSession session = request.getSession();
	if(session.getAttribute("user")==null) {
		return "redirect:../User/ShowLogin.do";
	}else {
	User user = userService.searchByusername((String)session.getAttribute("user"));
	int user_id= user.getId();
	Cart1 cart1 = cart1Service.searchByUserId(user_id);
	int cart1_id = cart1.getId();
	Product product = productService.searchById(product_id);
	double price = product.getPrice()*0.79;
	int count2 = cart2Service.searchByCart1_idAndProduct_id(cart1_id,product_id);
	if(count2>0) {
		int count3 =cart2Service.searchCount(product_id,cart1_id);
		
		int count4 = count3+count;
		double xiaoji = count4*price;
		boolean flag = cart2Service.update(product_id,count4,cart1_id,xiaoji);
	}else {
		double xiaoji = count*price;
		boolean flag = cart2Service.add(product_id,count,cart1_id,xiaoji);
	}
	
	
	
		return "Department/chenggong";
	}
		
	}
	@RequestMapping(value="ShowGoWuChe")
	public ModelAndView ShowGoWuChe(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("user")==null) {
			mv.setViewName("redirect:../User/ShowLogin.do");
		}else {
		User user = userService.searchByusername((String)session.getAttribute("user"));
		int user_id= user.getId();
		Cart1 cart1 = cart1Service.searchByUserId(user_id);
		int cart1_id = cart1.getId();
		List<Cart2> list2 = new ArrayList<>();
		list2 = cart2Service.searchBycart1Id(cart1_id);
		int zongji = 0;
		for(int i=0;i<list2.size();i++) {
		zongji  +=	list2.get(i).getXiaoji();
		}
		boolean flag = cart1Service.updateZongji(zongji,cart1_id);
		Cart1 cart2 = cart1Service.searchByUserId(user_id);
		List<Cart2> list = new ArrayList<>();
		list = cart2Service.searchBycart1Id(cart1_id);
		
		mv.setViewName("Department/GouWuChe");
		mv.addObject("list", list);
		mv.addObject("cart1", cart2);
		
		}
		return mv;
	}
	@RequestMapping(value="biandong")
	@ResponseBody
	public String biandong(int cart2Id,int count,int productId) {
		Product product = productService.searchById(productId);
		double price = product.getPrice()*0.79;
		double xiaoji = count*price;
		boolean flag = cart2Service.updateCountAndXiaoji(count,xiaoji,cart2Id);
		
		
		
		return String.valueOf(xiaoji);
	}
//	@RequestMapping(value="biandong2")
//	@ResponseBody
//	public String biandong2(String ids, HttpServletRequest request) {
//		
//		List<Cart2> list = new ArrayList<>();
//		list = cart2Service.searchByIds(ids);
//		
//		int zongji = 0;
//		for(int i=0;i<list.size();i++) {
//			zongji  +=	list.get(i).getXiaoji();
//			}
//		HttpSession session = request.getSession();
//		User user = userService.searchByusername((String)session.getAttribute("user"));
//		int user_id= user.getId();
//		Cart1 cart1 = cart1Service.searchByUserId(user_id);
//		int cart1_id = cart1.getId();
//		boolean flag = cart1Service.updateZongji(zongji,cart1_id);
//		return   String.valueOf(zongji);
//	}
	
	@RequestMapping(value="shanchu")
	
	public String shanchu(int cart2Id) {
		boolean flag = cart2Service.deleteById(cart2Id);
		
		
		
		return "redirect:ShowGoWuChe.do";
	}
@RequestMapping(value="shanchu2")
	
	public String shanchu2(String cart2Ids) {
		boolean flag = cart2Service.deleteByIds(cart2Ids);
		
		
		
		return "redirect:ShowGoWuChe.do";
	}
	
	
}
