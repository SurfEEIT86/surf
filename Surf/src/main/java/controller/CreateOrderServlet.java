package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.surf.members.model.MemberVO;
import com.surf.orderdetails.model.OrderDetailsDAO;
import com.surf.orderdetails.model.OrderDetailsVO;
import com.surf.orders.model.OrdersDAO;
import com.surf.orders.model.OrdersVO;
import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;


@WebServlet("/CreateOrderServlet.do")
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OrdersVO order;
    private OrdersDAO oDao;  
    private ProductsDAO pDao;
    
    public CreateOrderServlet() {
        super();
       
    }
    
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		oDao = (OrdersDAO) context.getBean("ordersDAO");	
		pDao = (ProductsDAO) context.getBean("productsDAO");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String add = request.getParameter("address");		
		String zip = request.getParameter("zip");
		String address = (zip+add);
		String creditcard = request.getParameter("creditcard");		
		Double totalprice = (Double) session.getAttribute("finalprice");
		MemberVO mVo = (MemberVO) session.getAttribute("user");
		
		order = new OrdersVO();
		order.setMemberno(mVo.getMemberno());
		long time = new Date().getTime();
		order.setDatetime(new Timestamp(time));
		order.setCreditcard(creditcard);
		order.setAddress(address);
		order.setStatus(1);
		order.setTotalprice(totalprice);	
						
		Set<OrderDetailsVO> orderdetails = new HashSet<OrderDetailsVO>();
		List<Map<String, Object>> orderlist = (List<Map<String, Object>>) session.getAttribute("purchaselist");
		Iterator<Map<String, Object>> orderlistIter = orderlist.iterator();
		while(orderlistIter.hasNext()){
			OrderDetailsVO detail = new OrderDetailsVO();
			Map<String, Object> m1 = orderlistIter.next();
			ProductsVO vo = (ProductsVO) m1.get("bean");
			Integer productno = vo.getProductno();
			Integer quantity = (Integer) m1.get("quantity");
			detail.setProductno(productno);
			detail.setQuantity(quantity);
			detail.setOrdersvo(order);
			orderdetails.add(detail);
			
			ProductsVO pvo = pDao.select(productno);
			Integer stock = pvo.getStock()- quantity;
			pvo.setStock(stock);
			pDao.update(pvo);			
		}
		String clientname = mVo.getName();
		String to = mVo.getEmail();
		order.setOrderdetails(orderdetails);
		oDao.insert(order);
		session.removeAttribute("purchaselist");
		
		SendConfirmation send = new SendConfirmation();
		send.sendMail(to, clientname);		
		out.print("success");					
	}

}
