package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;

@WebServlet("/ProductDetailServlet.do")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO pDao;
         
    public ProductDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer productno = Integer.parseInt(request.getParameter("productno"));
		ProductsVO bean = pDao.select(productno);
		request.setAttribute("productdetail", bean);
		RequestDispatcher rd = request.getRequestDispatcher("ProductDetail.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		pDao = (ProductsDAO)context.getBean("productsDAO");
	}

}
