package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.customorders.model.CustomOrdersDAO;
import com.surf.customorders.model.CustomOrdersVO;
import com.surf.members.model.MemberVO;
import com.surf.models.model.ModelsVO;


@WebServlet("/CreateCustomOrderServlet.do")
public class CreateCustomOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomOrdersDAO cDao;   
  
    @Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		cDao = (CustomOrdersDAO)context.getBean("customordersDAO"); 
    }


	public CreateCustomOrderServlet() {
        super();      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String dimension = (String) session.getAttribute("dimension");
		String material = (String) session.getAttribute("material");
		String boardcolor = (String) session.getAttribute("boardcolor");
		String customlogo1 =(String) session.getAttribute("customlogo1");
		String customlogo2= (String) session.getAttribute("customlogo2");
		String boardpic = (String) session.getAttribute("boardpic");
		String finsys = (String) session.getAttribute("finsys");
		String remark = (String) session.getAttribute("remark");
		Double price = (Double) session.getAttribute("price");
		String zip = request.getParameter("zip");
		String add= request.getParameter("address");
		String address = zip+add;
		String creditcard=request.getParameter("creditcard");
				
		MemberVO mvo = (MemberVO) session.getAttribute("user");
		Integer memberno = mvo.getMemberno();
		ModelsVO mdvo = (ModelsVO)session.getAttribute("model");	
		String to = mvo.getEmail();
		String clientname = mvo.getName();
		long time = new Date().getTime();	
		CustomOrdersVO vo = new CustomOrdersVO();
		vo.setMaterial(material);
		vo.setDimension(dimension);
		vo.setAddress(address);
		vo.setBoardcolor(boardcolor);
		vo.setFinsys(finsys);
		vo.setCustomlogo1(customlogo1);
		vo.setCustomlogo2(customlogo2);
		vo.setBoardpic(boardpic);
		vo.setPrice(price);
		vo.setRemark(remark);
		vo.setCreditcard(creditcard);
		vo.setDate(new Timestamp(time));
		vo.setMemberno(memberno);
		vo.setModelsvo(mdvo);
		vo.setStatus(1);
		
		cDao.insert(vo);	
		
		SendConfirmation send = new SendConfirmation();
		String ordertype="客製化訂單";
		send.sendMail(to, clientname, ordertype);		
		session.removeAttribute("creditcard");
		session.removeAttribute("remark");
		session.removeAttribute("finsys");
		session.removeAttribute("boardpic");
		session.removeAttribute("customlogo2");
		session.removeAttribute("customlogo1");
		session.removeAttribute("boardcolor");
		session.removeAttribute("material");
		session.removeAttribute("dimension");
		session.removeAttribute("model");
		out.print("success");				
		
	}

}
