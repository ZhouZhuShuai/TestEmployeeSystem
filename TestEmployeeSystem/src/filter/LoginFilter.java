package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	 //实现接口  不是继承      servlet是继承   接口在java中起一个约束作用
		//谁实现我这个方法 就必须调用我这个方法里的抽象方法  对我们来说很好 我们就知道写什么了


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  //执行过滤
			throws IOException, ServletException {
		HttpSession session =((HttpServletRequest)request).getSession();
		if(session.getAttribute("user")==null) {
			((HttpServletResponse)response).sendRedirect("Login");
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException { //初始
		
	} 
	@Override
	public void destroy() { //销毁
		
	}

	
	

}
