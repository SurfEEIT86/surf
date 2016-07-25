package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.brands.model.BrandsDAO;
import com.surf.brands.model.BrandsVO;
import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;


@WebServlet("/BrandServlet.do")
public class BrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BrandsDAO dao; 
    private ProductsDAO pDao;
  
    public BrandServlet() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer brandno = Integer.parseInt(request.getParameter("brand"));
	
		HttpSession session = request.getSession();
		session.removeAttribute("brandname");
		
		if(brandno==0){		
			List<ProductsVO> productlist = pDao.selectAll();
			request.setAttribute("allProducts", productlist);
			RequestDispatcher rd = request.getRequestDispatcher("ViewAllProducts.jsp");
			rd.forward(request, response);		
		}else{	
			BrandsVO brandBean = dao.select(brandno);
			Set<ProductsVO> productBeans = brandBean.getProds();
			request.setAttribute("products", productBeans);
			session.setAttribute("brandname", brandBean.getName());
			session.setAttribute("brandno", brandBean.getBrandno());
			RequestDispatcher rd = request.getRequestDispatcher("BrandSelected.jsp");
			rd.forward(request, response);
		}
	}
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		dao = (BrandsDAO) context.getBean("brandsDAO");
		pDao=(ProductsDAO)context.getBean("productsDAO");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
