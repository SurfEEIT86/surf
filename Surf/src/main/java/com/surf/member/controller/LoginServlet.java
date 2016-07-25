package com.surf.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.members.model.MemberService;
import com.surf.members.model.MemberVO;

@WebServlet("/secure/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;

	@Override
	public void init() throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
			memberService = (MemberService) context.getBean("memberService");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Map<String, String> errors = new HashMap<String, String>();
		request.setAttribute("error", errors);

		if (username == null || username.length() == 0) {
			errors.put("username", "Please Enter ID");
		}
		if (password == null || password.length() == 0) {
			errors.put("password", "Please Enter PWD");
		}
		if (errors != null && !errors.isEmpty()) {
			request.getRequestDispatcher("/members/login.jsp").forward(request,
					response);
			return;
		}

		MemberVO vo = memberService.memberLogin(username, password);
		if (vo == null) {
			errors.put("password", "Login failed, please try again.");
			request.getRequestDispatcher("/members/login.jsp").forward(request,response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);    //設定vo給之後該登入的網頁使用

			String dest = (String) session.getAttribute("dest");
			if (dest != null && dest.length() != 0) {
				session.removeAttribute("dest");
				response.sendRedirect(dest);
			} else {
				System.out.println("aaa");
				String path = request.getContextPath();
				System.out.println(path + "/members/index.jsp");
				response.sendRedirect(path + "/members/index.jsp");
			}
		}
	}

}
