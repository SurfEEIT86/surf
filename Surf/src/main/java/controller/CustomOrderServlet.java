package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONValue;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.brands.model.BrandsDAO;
import com.surf.brands.model.BrandsVO;
import com.surf.products.model.ProductsVO;
import com.surf.producttype.model.ProducttypesDAO;
import com.surf.producttype.model.ProducttypesVO;


@WebServlet("/CustomOrderServlet.do")
public class CustomOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProducttypesDAO dao;
	private BrandsDAO bDAO;
       
    public CustomOrderServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Integer typeno = Integer.parseInt(request.getParameter("typeno"));
		ProducttypesVO typeBean = dao.select(typeno);
		Set<BrandsVO> brandBean = typeBean.getBrands();	
		request.setAttribute("brands", brandBean);
		RequestDispatcher rd = request.getRequestDispatcher("CustomOrderBrand.jsp");
		rd.forward(request, response);	
	}
	

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		dao = (ProducttypesDAO) context.getBean("producttypesDAO");	
		bDAO = (BrandsDAO) context.getBean("brandsDAO");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.doGet(request, response);
	}

}
