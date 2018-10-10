package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UserService;

@Controller
@RequestMapping(value="User")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value="ShowLogin")
	public String showLogin() {
		return "Department/Login";
	}
	@RequestMapping(value="Dologin")
	public ModelAndView dologin(String username ,String password,HttpServletRequest request,HttpServletResponse response) {
		boolean flag = userService.searchByUserNameAndPassword(username,password);
		ModelAndView mv= new ModelAndView();
		if(flag) {
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			Cookie cookie = new Cookie("name" ,username);
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			mv.setViewName("redirect:../Product/search.do");
			
			
		}else {
			mv.addObject("mes", "用户名或密码错误");
			mv.setViewName("Department/Login");
		}
		return mv;
		
		
	}
	@RequestMapping(value="ShowZhuCe")
	public String ShowZhuCe() {
		return"Department/ZhuCe";
	}
	
}
