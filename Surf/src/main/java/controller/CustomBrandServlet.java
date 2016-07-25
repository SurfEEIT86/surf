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
import com.surf.models.model.ModelsDAO;
import com.surf.models.model.ModelsVO;
import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;


@WebServlet("/CustomBrandServlet.do")
public class CustomBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModelsDAO mDao;
    private BrandsDAO bDao;
  
    public CustomBrandServlet() {
        super();
    }
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer brandno = Integer.parseInt(request.getParameter("brandno"));
		BrandsVO bean = bDao.select(brandno);
		HttpSession session = request.getSession();		
		List<ModelsVO> mlist = mDao.selectByBrandno(brandno);
		request.setAttribute("models", mlist);
		session.setAttribute("brandbean", bean);
		RequestDispatcher rd = request.getRequestDispatcher("CustomOrderModels.jsp");
		rd.forward(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		mDao=(ModelsDAO)context.getBean("modelsDAO");
		bDao= (BrandsDAO) context.getBean("brandsDAO");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
