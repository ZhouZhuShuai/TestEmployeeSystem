package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Entity.Adress;
import Entity.Area;
import Entity.Cart2;
import Entity.City;
import Entity.Province;
import Entity.User;
import service.AdressService;
import service.AreaService;
import service.Cart2Service;
import service.CityService;
import service.ProvinceService;
import service.UserService;

@Controller
@RequestMapping(value="Adress")
public class AdressController {
	@Autowired
	UserService userService;
	@Autowired
	AdressService adressService;
	@Autowired
	Cart2Service  cart2Service;
	@Autowired
	ProvinceService provinceService;
	@Autowired
	CityService cityService;
	@Autowired
	AreaService areaService;
	@RequestMapping(value="showAdress")
	public ModelAndView showAdress(String ids,HttpServletRequest request,int zongji) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			mv.setViewName("redirect:../User/ShowLogin.do");
			
		}else {
			List<Cart2> cart2list = new ArrayList<>();
			cart2list = cart2Service.searchByIds(ids);
			User user = userService.searchByusername((String)session.getAttribute("user"));
			int user_id= user.getId();
			List<Adress> list = adressService.searchByUserId(user_id);
			mv.addObject("list", list);
			mv.addObject("cart2list", cart2list);
			mv.addObject("zongji", zongji);
			mv.setViewName("Department/Adress");
		}
		return mv;
	}
	
	@RequestMapping(value="sheng")
	@ResponseBody
	public List<Province> sheng() {
		List<Province> provinceList = provinceService.searchAll();
		//将list转换成json格式
//		JSONArray json=JSONArray.fromObject(provinceList);
		//只能用json将list转换成String
		return provinceList;
	}
	@RequestMapping(value="shi")
	@ResponseBody
	public List<City> shi(Integer father) {
		List<City> cityList = cityService.searchAll(father);
	
		return cityList;
		}
	@RequestMapping(value="qu")
	@ResponseBody
	public List<Area> qu(Integer father) {
		List<Area> AreaList = areaService.searchAll(father);
	
		return AreaList;
		}
	
	@RequestMapping(value="baocun")

	public String baocun(Adress adress,HttpServletRequest request,int provinceID,Integer cityID,Integer areaID,String ids,String zongji){
		HttpSession session = request.getSession();
		User user = userService.searchByusername((String)session.getAttribute("user"));
		int user_id= user.getId();
		adress.setUser_id(user_id);
		Province province = new Province();
		province.setProvinceID(provinceID);
		City city = new City();
		city.setCityID(cityID);
		Area area = new Area();
		area.setAreaID(areaID);
		adress.setArea(area);
		adress.setCity(city);
		adress.setProvince(province);
		
		boolean flag = adressService.add(adress);
		
		return "redirect:showAdress.do?ids="+ids+"&zongji="+zongji;
		
		
	}
	@RequestMapping(value="shanchu")
	public String shanchu(String ids,int id,String zongji) {
		boolean flag = adressService.deleteById(id);
		return "redirect:showAdress.do?ids="+ids+"&zongji="+zongji;
	}
	
	
}
