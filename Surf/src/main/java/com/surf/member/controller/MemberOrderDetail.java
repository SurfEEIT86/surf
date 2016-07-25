package com.surf.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.members.model.MemberService;
import com.surf.orderdetails.model.OrderDetailsVO;
import com.surf.orders.model.OrdersDAO;
import com.surf.orders.model.OrdersVO;
import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;

/**
 * Servlet implementation class MemberOrderDetail
 */
@WebServlet("/members/Theme/MemberOrderDetail")
public class MemberOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	private ProductsDAO pDao;
	private OrdersDAO ordersDAO;
	@Override
	public void init() throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		memberService = (MemberService) context.getBean("memberService");
		pDao = (ProductsDAO)context.getBean("productsDAO");
		ordersDAO=(OrdersDAO)context.getBean("ordersDAO");
		
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String orderNO = request.getParameter("orderNo");
		Integer no;
		try {
			no = Integer.parseInt(orderNO);
		} catch (Exception e) {
			System.out.println("型態轉換失敗");
			return;
		}
		/*找個地方裝需要的產品*/
		List<ProductsVO> productsInfo=new ArrayList<ProductsVO>();
		/*需要用到的單筆訂單資料*/
		OrdersVO orderVO = ordersDAO.select(no);
		/*需要用到的訂單明細們*/
		List<OrderDetailsVO> orderdetials = memberService.findOrderDetialsByOrderNo(no);
		Iterator<OrderDetailsVO> iter = orderdetials.iterator();
		
		/*把需要的產品資料裝進去啦*/
		while(iter.hasNext()){
			OrderDetailsVO vo = iter.next();
			ProductsVO productVO = pDao.select(vo.getProductno());
			productsInfo.add(productVO);
		}
		/*放*/
		request.setAttribute("orderVO", orderVO);
		request.setAttribute("orderdetials", orderdetials);
		request.setAttribute("productsInfo", productsInfo);
		/*傳*/
		RequestDispatcher rd = request.getRequestDispatcher("MemberOrderDetail.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
