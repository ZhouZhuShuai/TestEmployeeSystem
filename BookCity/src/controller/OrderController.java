package controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Entity.Cart2;
import Entity.Order1;
import Entity.Order2;
import Entity.User;
import service.Cart2Service;
import service.Order2Service;
import service.OrderService;
import service.UserService;
import util.GenerateOrderNo;

@Controller
@RequestMapping(value = "Order")
public class OrderController {
	@Autowired
	UserService userService;
	@Autowired
	OrderService orderService;
	@Autowired
	Order2Service  order2Service;
	@Autowired
	Cart2Service  cart2Service;
	@RequestMapping(value = "xiadan")
	public ModelAndView showAdress(Order1 order1, HttpServletRequest request, String ids) {
	
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			mv.setViewName("redirect:../User/ShowLogin.do");

		} else {
			User user = userService.searchByusername((String) session.getAttribute("user"));
			int user_id = user.getId();
			Date now = new Date();
			Timestamp payment_time = new Timestamp(now.getTime());

			GenerateOrderNo order_no1 = new GenerateOrderNo();
			String order_no = order_no1.generate();
			
			order1.setUser_id(user_id);
			order1.setOrder_no(order_no);
			order1.setPayment_time(payment_time);
		    orderService.add(order1);
			int order1_id=order1.getId();
			
			String[] ids2 = ids.split(",");
			for(int i =0;i<ids2.length;i++) {
			Cart2 cart2 = cart2Service.searchById(Integer.parseInt(ids2[i]));
			Order2 order2 = new Order2();
			order2.setOrder1_id(order1_id);
			order2.setOrder2_product_count(cart2.getCount());
			order2.setOrder2_xiaoji(cart2.getXiaoji());
			order2.setProduct(cart2.getProduct());
			order2Service.add(order2);	
			cart2Service.deleteById(Integer.parseInt(ids2[i]));	
			}

			mv.setViewName("redirect:zhanshidingdan.do");

		}
		return mv;
	}

	@RequestMapping(value = "zhanshidingdan")
	public ModelAndView zhanshidingdan(HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			mv.setViewName("redirect:../User/ShowLogin.do");

		} else {
		User user = userService.searchByusername((String) session.getAttribute("user"));
		int user_id = user.getId();
		
		List<Order1> order1List = orderService.searchByUserId(user_id);
		
		mv.addObject("order1List", order1List);
		mv.setViewName("Department/Order");
		}
		return mv;
	}

}
