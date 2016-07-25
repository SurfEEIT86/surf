package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.brands.model.BrandsVO;
import com.surf.producttype.model.ProducttypesDAO;
import com.surf.producttype.model.ProducttypesVO;

@WebServlet("/ProductTypesServlet.do")
public class ProductTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProducttypesDAO dao;   
    public ProductTypesServlet() {
        super();   
    }

	@Override
	public void init() throws ServletException {
		
		ServletContext application = this.getServletContext();
//		System.out.println(application.getRealPath("/"));
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		dao = (ProducttypesDAO) context.getBean("producttypesDAO");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		request.setCharacterEncoding("UTF-8");
		Integer typeno = Integer.parseInt(request.getParameter("type"));
		HttpSession session = request.getSession();
		if (typeno==0){
			RequestDispatcher rd = request.getRequestDispatcher("/BrandServlet.do?brand=0");
			rd.forward(request, response);		
		}
		else{
			ProducttypesVO typeBean = dao.select(typeno);
			Set<BrandsVO> brandBean = typeBean.getBrands();
			session.setAttribute("typename", typeBean.getType());
			session.setAttribute("typeno", typeBean.getTypeno());
			request.setAttribute("brands", brandBean);
			RequestDispatcher rd = request.getRequestDispatcher("TypeSelected.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		this.doGet(request, response);
	}

}
