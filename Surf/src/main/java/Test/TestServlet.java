package Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.brands.model.BrandsDAO;
import com.surf.brands.model.BrandsVO;
import com.surf.customorders.model.CustomOrdersDAO;
import com.surf.customorders.model.CustomOrdersVO;
import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;
import com.surf.producttype.model.ProducttypesDAO;
import com.surf.producttype.model.ProducttypesVO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomOrdersDAO dao;
    public TestServlet() {
        
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomOrdersVO vo = dao.select(3);
		String pic = vo.getBoardpic();
		request.setAttribute("pic", pic);
		
		RequestDispatcher rd = request.getRequestDispatcher("NewFile.jsp");
		rd.forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		dao = (CustomOrdersDAO) context.getBean("customordersDAO");	
		
		
		

//		ProductsVO bean = dao.select(1);
//		System.out.println(bean.getName());
//		System.out.println(bean.getSize());
		
		//測試Insert Brands
//		ProducttypesDAO pDao = (ProducttypesDAO) context.getBean("producttypesDAO");
//		ProducttypesVO pVO = pDao.select(1);
//		BrandsVO b1 = new BrandsVO();
//		b1.setBrandno(2);
//		b1.setName("DHD");
//		b1.setProdtypesVO(pVO);
//		dao.insert(b1);
		
		
		//測試新增Products
//		ProductsVO b1 = new ProductsVO();
//		b1.setProductno(5);
//		b1.setBrandno(1);
//		b1.setName("OOOOOO");
//		b1.setPrice(26000.0);
//		b1.setSize("5'9, 18 1/2'', 2 1/4''");
//		b1.setStock(6);
//		b1.setDescription("123123123123");
//		dao.update(b1);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
