package com.surf.information.sites.model.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.information.model.InformationService;
import com.surf.information.shops.model.ShopsVO;

/**
 * Servlet implementation class ShopImg
 */
@WebServlet("/information/ShopImg")
public class ShopImg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InformationService informationService;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		informationService = (InformationService) context
				.getBean("informationService");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathFile = "C:/Surf_data/information/Image/Shops/";
		
		String shopno = request.getParameter("ShopNo");
		System.out.println("shopno   "+shopno);
		int ShopNo = Integer.parseInt(shopno);
		ShopsVO shop = informationService.findByShopNo(ShopNo);
		System.out.println(shop.getName());
		String fileName = shop.getPic1();
		String filePath = pathFile+fileName;
		File img = new File(filePath);
		FileInputStream fis=new FileInputStream(img);
		BufferedInputStream bfi = new BufferedInputStream(fis);
		
	ServletOutputStream out = response.getOutputStream();
	BufferedOutputStream bfo = new BufferedOutputStream(out);
	
	int length = 0;
	while((length=bfi.read())!=-1){
		bfo.write(length);
	}
		bfo.flush();
		bfo.close();
		out.close();
		bfi.close();
		fis.close();
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
