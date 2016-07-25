package controller;

import java.io.IOException;

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

import com.surf.models.model.ModelsDAO;
import com.surf.models.model.ModelsVO;


@WebServlet("/CustomModelServlet.do")
public class CustomModelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModelsDAO mDao;   
    
    public CustomModelServlet() {
        super();     
    }
    
    @Override
	public void init() throws ServletException {	
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		mDao=(ModelsDAO)context.getBean("modelsDAO");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session= request.getSession();
		Integer modelno = Integer.parseInt(request.getParameter("modelno"));
		ModelsVO vo = mDao.selectByModelno(modelno);
		session.setAttribute("model", vo);	
		RequestDispatcher rd = request.getRequestDispatcher("CustomShape.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
