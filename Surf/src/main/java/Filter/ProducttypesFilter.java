package Filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.producttype.model.ProducttypesDAO;
import com.surf.producttype.model.ProducttypesVO;

@WebFilter(urlPatterns={"/Types123213213.jsp"})
public class ProducttypesFilter implements Filter {
	
	private ProducttypesDAO dao;
	@Override
	public void destroy() {
		

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request =  (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		List<ProducttypesVO> vo = dao.selectAll();
//		Iterator<ProducttypesVO> vList = vo.iterator();
//		while(vList.hasNext()){
//			ProducttypesVO bean = vList.next();
//			System.out.println(bean.getType());
//		}	
		
		request.setAttribute("typesFilter", vo);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		ServletContext application = config.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		dao = (ProducttypesDAO) context.getBean("producttypesDAO");
	}

}
