package com.surf.member.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import util.imgSave;

import com.surf.forums.model.ForumService;
import com.surf.members.model.MemberService;
import com.surf.members.model.MemberVO;

/**
 * Servlet implementation class Register
 */
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 500, maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/members/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	private String imagesPath;

	@Override
	public void init() throws ServletException {
		imagesPath = "C:/Surf_data/memberInfo/";
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
		request.setCharacterEncoding("UTF-8");

		String lastName = null;
		String firstName = null;
		String id = null;
		String password = null;
		String password2 = null;
		String gender = null;
		String email = null;
		String birthday = null;
		String address = null;
		String tel = null;
		String intro = null;
		String nameUpdate = null;
		InputStream is = null;
		String fileName = "";
		Part picp = null;
		Collection<Part> parts = request.getParts();
		ForumService.exploreParts(parts, request);
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("lastName")) {
						lastName = value;
					} else if (fldName.equals("firstName")) {
						firstName = value;
					} else if (fldName.equals("id")) {
						id = value;
					} else if (fldName.equals("password")) {
						password = value;
					} else if (fldName.equals("password2")) {
						password2 = value;
					} else if (fldName.equals("gender")) {
						gender = value;
					} else if (fldName.equals("email")) {
						email = value;
					} else if (fldName.equals("birthday")) {
						birthday = value;
					} else if (fldName.equals("address")) {
						address = value;
					} else if (fldName.equals("tel")) {
						tel = value;
					} else if (fldName.equals("intro")) {
						intro = value;
					} else if (fldName.equals("name")) {
						nameUpdate = value;
					} else if (fldName.equals("pic")) {
						is = p.getInputStream();
					}
				} else {
					fileName = ForumService.getFileName(p); // 此為圖片檔的檔名
					if (fileName != null && fileName.trim().length() > 0) {
						is = p.getInputStream();
						picp = p;
					} else {
					}

				}
			}

		}
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		if (user == null) {
//			try {
				String name = lastName + firstName;
				if (!password.equals(password2)) {
					/* 密碼錯誤回報 */
					System.out.println("密碼錯誤回報");
					return;
				}
				int gdr;
				try {
					gdr = Integer.parseInt(gender);
					if (gdr != 1 && gdr != 2) {
						/* 性別錯誤 */
						System.out.println("gdr  " + gdr);
						System.out.println("性別錯誤");
						return;
					}
				} catch (Exception e) {
					/* 性別無法轉換 */
					System.out.println("性別無法轉換 ");
					return;
				}

				java.sql.Date sqlBirthday;
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				try {
					Date bir = df.parse(birthday);
					sqlBirthday = new java.sql.Date(bir.getTime());
				} catch (ParseException e) {
					/* 日期轉換失敗 */
					System.out.println("日期轉換失敗  ");
					return;
				}
				MemberVO vo = new MemberVO();
				vo.setUsername(id);
				vo.setPassword(password);
				vo.setGender(gdr);
				vo.setAddress(address);
				vo.setEmail(email);
				vo.setName(name);
				vo.setTel(tel);
				vo.setBirthday(sqlBirthday);
				vo.setStatus(true);
				vo.setIntro(intro);
				int len;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				if(is!=null){
				byte[] buf = new byte[8192];
				while ((len = is.read(buf, 0, 8192)) != -1)
					bos.write(buf, 0, len);
				buf = bos.toByteArray();
				

				imgSave image = new imgSave();
				image.imgSave(buf, picp, imagesPath);
				vo.setPic1(image.getFileName(picp));
				}else{
					vo.setPic1("noimage.png");
				}
				
				System.out.println("aaaaaaaaaasssssssssdddddddddd");
				memberService.register(vo);
				request.getRequestDispatcher("/members/RegisterSuccess.html")
						.forward(request, response);
//			} catch (Exception e) {
//				System.out.println("run here");
//				return;
//			}
		} else if (user != null) {
			user.setName(nameUpdate);
			user.setAddress(address);
			user.setEmail(email);
			user.setTel(tel);
			user.setIntro(intro);
			if(is!=null){
			int len;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[8192];
			while ((len = is.read(buf, 0, 8192)) != -1)
				bos.write(buf, 0, len);
			buf = bos.toByteArray();

			imgSave image = new imgSave();
			image.imgSave(buf, picp, imagesPath);

			user.setPic1(image.getFileName(picp));
			}
			
			MemberVO vo = memberService.updateMember(user);
			
			
//			request.getSession().removeAttribute("user");
//			request.getSession().setAttribute("user", vo);
		
			response.sendRedirect("Theme/MemberData.jsp");
		}

	}
}
