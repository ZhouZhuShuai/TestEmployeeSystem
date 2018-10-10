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
	 //ʵ�ֽӿ�  ���Ǽ̳�      servlet�Ǽ̳�   �ӿ���java����һ��Լ������
		//˭ʵ����������� �ͱ�����������������ĳ��󷽷�  ��������˵�ܺ� ���Ǿ�֪��дʲô��


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  //ִ�й���
			throws IOException, ServletException {
		HttpSession session =((HttpServletRequest)request).getSession();
		if(session.getAttribute("user")==null) {
			((HttpServletResponse)response).sendRedirect("Login");
		}else {
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException { //��ʼ
		
	} 
	@Override
	public void destroy() { //����
		
	}

	
	

}
