package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.brands.model.BrandsDAO;
import com.surf.brands.model.BrandsVO;
import com.surf.products.model.ProductsVO;
import com.surf.producttype.model.ProducttypesDAO;


@WebServlet("/Custom.do")
public class Custom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProducttypesDAO dao;
	private BrandsDAO bDAO;
       
    public Custom() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
//		Integer typeno = Integer.parseInt(request.getParameter("typeno"));
		String type = request.getParameter("typeno");
		if(type!=null){
			Integer typeno = Integer.parseInt(type);
			Set<BrandsVO> brandBeans = dao.select(typeno).getBrands();
			Iterator<BrandsVO> brands = brandBeans.iterator();
			List<Map<String, String>> brandList = new LinkedList<Map<String, String>>(); 
		
			while(brands.hasNext()){
				Map<String, String> m1 = new HashMap<String, String>();
				BrandsVO beans = brands.next();
				m1.put("brandname", beans.getName());
				m1.put("brandno", beans.getBrandno().toString());
				brandList.add(m1);
			}
			String jsonString = JSONValue.toJSONString(brandList); 
			out.println(jsonString);
			
		}else{
				Integer brandno = Integer.parseInt(request.getParameter("brandno"));
				if(brandno!=0){
					Set<ProductsVO> productBeans = bDAO.select(brandno).getProds();
					Iterator<ProductsVO> products = productBeans.iterator();
					List<Map<String, String>> productList = new LinkedList<Map<String, String>>();
					
					while(products.hasNext()){
						Map<String, String> m2 = new HashMap<String, String>();
						m2.put("productname", products.next().getName());
						productList.add(m2);
					}
					String jsonString1 = JSONValue.toJSONString(productList); 
					out.println(jsonString1);
					
				}
			}
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
