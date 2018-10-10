package ServLet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Dao.userDao;
import Entity.User;
import util.RandomNumber;
import util.ValidateCode;
import util.MD5;


@WebServlet("/Login")
public class UserServLet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String type = request.getParameter("type");
		if(type==null) {
			showLogin(request,response);
		}else if("doLogin".equals(type)) {
			doLogin(request,response);
		}else if("zhuce".equals(type)) {
			zhuce(request,response);
		}else if("randomImage".equals(type)) {
			randomImage(request,response);
		}else if("zhuce2".equals(type)) {
			zhuce2(request,response);
		}
		
		
		

	}
	public void randomImage(HttpServletRequest request, HttpServletResponse response) {
		try {
             	RandomNumber rn = new RandomNumber();	
             	//设置页面不缓存
             	response.setHeader("Pragme", "No-cache");
             	response.setHeader("Cache-Control", "no-cache");
             	response.setDateHeader("Expires", 0);
             	ValidateCode vc = rn.generateImage();
				
             	ServletOutputStream outStream = response.getOutputStream();
             	//输出图像到页面
             	ImageIO.write(vc.getImage(), "JPEG", outStream);
             	outStream.close();
             	request.getSession().setAttribute("random", vc.getRand());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void showLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = "";
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for(int i=0;i<cookies.length;i++) {
					if("username".equals(cookies[i].getName())) {
						name = cookies[i].getValue();
					}
				}
			}
			request.setAttribute("username", name);
			request.getRequestDispatcher("WEB-INF/Login/login.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void zhuce(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			request.getRequestDispatcher("WEB-INF/Login/zhuce.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void doLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String str = request.getParameter("userName");
			String str2 = request.getParameter("password");
			String random = request.getParameter("random");
			if(random.equals(session.getAttribute("random"))) {
				
		
			User user = new User();
			user.setUsername(str);
			user.setPassword(str2);
			//user.setPassword(MD5.GetMD5( str2+"周主帅"));

			userDao ud = new userDao();
			boolean flag = ud.search(user);

			if (flag) {
				
				session.setAttribute("user", str);
				Cookie cookie = new Cookie("username",str);
				cookie.setMaxAge(30); //单位是秒  保存的时间
				response.addCookie(cookie);
				
				response.sendRedirect("index");
			}

			else {
				response.sendRedirect("Login");

			}
			}else {
				request.setAttribute("mes", "验证码输入错误");
				
				request.getRequestDispatcher("WEB-INF/Login/login.jsp").forward(request, response);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void zhuce2(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String str = request.getParameter("userName");
			String str2 = request.getParameter("password");
			String password2 = request.getParameter("password2");
			if(str2.equals(password2)) {
				User user = new User();
				user.setUsername(str);
				user.setPassword(str2);
				//user.setPassword(MD5.GetMD5( str2+"周主帅"));
				
				userDao ud = new userDao();
				boolean flag = ud.add(user);
				if(flag) {
					response.sendRedirect("Login");

				}else {
					response.sendRedirect("Login?type=zhuce");

				}
				
			}else {
				response.sendRedirect("Login?type=zhuce");
			}
			
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
