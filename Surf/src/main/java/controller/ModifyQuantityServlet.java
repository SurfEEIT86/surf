package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;


@WebServlet("/ModifyQuantityServlet.do")
public class ModifyQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO pDao;
	private List<Map<String, Object>> purchase;
	
    public ModifyQuantityServlet() {
        super();
        
    }
    
    @Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		pDao = (ProductsDAO) context.getBean("productsDAO");
		
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		PrintWriter out = response.getWriter();
		
		Integer productno = Integer.parseInt(request.getParameter("productno"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		purchase = (List<Map<String, Object>>)session.getAttribute("purchaselist");
		
		Iterator<Map<String, Object>> check = purchase.iterator();	
		while(check.hasNext()){
			Map<String, Object> m2 = check.next();
			ProductsVO bean1 = (ProductsVO) m2.get("bean");
			if(bean1.getProductno().equals(productno)){
				m2.replace("quantity", quantity);
				Double price = bean1.getPrice() * quantity;
				session.setAttribute("newprice", price);
				out.println(price);					
				break;
			}else{			
				continue;
			}
		}					
				
	}

}
