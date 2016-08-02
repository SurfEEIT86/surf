package com.surf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surf.members.model.MemberVO;


@WebFilter(
		urlPatterns={"/forums/*", "/ShoppingCart.jsp"}
)
public class LoginFilter implements Filter {
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("user");  //LoginServlet放的
		if(vo!=null) {
			chain.doFilter(request, response);
		} else {
			String uri = request.getRequestURI();
			 //放了使用者原本想去的URI 讓使用者登入後直接轉跳想去的頁面
			session.setAttribute("dest", uri);  
			String path = request.getContextPath();
			response.sendRedirect(path+"/members/index.jsp");
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
