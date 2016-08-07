package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.producttype.model.ProducttypesDAO;
import com.surf.producttype.model.ProducttypesVO;

/**
 * Servlet implementation class MainProductsServlet
 */
@WebServlet("/MainProductsServlet.do")
public class MainProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProducttypesDAO dao;      
    public MainProductsServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		List<ProducttypesVO> prodTypes = dao.selectAll();
		Iterator<ProducttypesVO> beans = prodTypes.iterator();
		
		List<Map<String, String>> types = new LinkedList<Map<String, String>>();	
		while(beans.hasNext()){
			Map<String, String> m1 = new HashMap<String, String>();
			ProducttypesVO bean = beans.next();
			if(bean.getStatus()){
				m1.put("type", bean.getType());
				m1.put("typeno", bean.getTypeno().toString());
				types.add(m1);
			}
		}
		String jsonString = JSONValue.toJSONString(types);                    
		out.println(jsonString);						
	}
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		dao = (ProducttypesDAO) context.getBean("producttypesDAO");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
