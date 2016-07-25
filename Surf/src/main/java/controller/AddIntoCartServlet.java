package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet("/AddIntoCartServlet.do")
public class AddIntoCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	private ProductsDAO pDao;
	private List<Map<String, Object>> purchase;
    public AddIntoCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Integer productno = Integer.parseInt(request.getParameter("product"));
		Integer quantity  = Integer.parseInt(request.getParameter("quantity"));
		ProductsVO pbean = pDao.select(productno);
		purchase = (List<Map<String, Object>>)session.getAttribute("purchaselist");
		if(purchase!=null && purchase.size()!=0){
			Iterator<Map<String, Object>> check = purchase.iterator();	
				while(check.hasNext()){
					Map<String, Object> m2= check.next();
					ProductsVO bean1 = (ProductsVO) m2.get("bean");
					if(bean1.getProductno().equals(productno)){
						m2.replace("quantity", quantity);
						out.print("modified");
						break;
					}else{
						if(check.hasNext()){
							continue;
						}else{
							Map<String, Object> m1 = new HashMap<String, Object>();
							m1.put("bean", pbean);
							m1.put("quantity", quantity);
							purchase.add(m1);		
							session.setAttribute("purchaselist", purchase);		
							out.print("success");
							break;
						}
					}					
				}
		}else{
			Map<String, Object> m1 = new HashMap<String, Object>();
			purchase = new ArrayList<Map<String, Object>>();
			m1.put("bean", pbean);
			m1.put("quantity", quantity);
			purchase.add(m1);		
			session.setAttribute("purchaselist", purchase);		
			out.print("success");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer prodno = Integer.parseInt(request.getParameter("prodno"));
		ProductsVO pbean = pDao.select(prodno);
		purchase = (List<Map<String, Object>>)session.getAttribute("purchaselist");
		Iterator<Map<String, Object>> check = purchase.iterator();	
		while(check.hasNext()){
			Map<String, Object> m3 = check.next();
			ProductsVO bean1 = (ProductsVO) m3.get("bean");
			if(bean1.getProductno()==prodno){
				purchase.remove(m3);
				out.print("success");
				break;
			}
		}
	}

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		pDao = (ProductsDAO) context.getBean("productsDAO");
		
	}

}
