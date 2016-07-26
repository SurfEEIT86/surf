package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surf.members.model.MemberVO;


//@MultipartConfig(location = "", 
//fileSizeThreshold = 1024 * 1024, 
//maxFileSize = 1024 * 1024 * 500, 
//maxRequestSize = 1024 * 1024 * 500 * 5)

@WebServlet("/CustomCheckOutServlet.do")
public class CustomCheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public CustomCheckOutServlet() {
        super();    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();		
		String customlogo2 = request.getParameter("logo2");
		String width = request.getParameter("width");
		String length = request.getParameter("length");
		String thick = request.getParameter("thick");
		String material = request.getParameter("material");
		String fincount = request.getParameter("fincount");
		String finsys = request.getParameter("finsys");
		String boardcolor = request.getParameter("boardcolor");
		String boardpic = request.getParameter("print");
		String customlogo1 = request.getParameter("logo1");	
		String remark = request.getParameter("remark");
		Double price = Double.parseDouble(request.getParameter("price"));
				
		finsys = finsys+"," +fincount+" Fins";
		String dimension = length+","+width+","+thick;	
		
		session.setAttribute("dimension", dimension);
		session.setAttribute("material", material);
		session.setAttribute("boardcolor", boardcolor);
		session.setAttribute("customlogo1", customlogo1);
		session.setAttribute("customlogo2", customlogo2);
		session.setAttribute("boardpic", boardpic);
		session.setAttribute("finsys", finsys);
		session.setAttribute("remark", remark);
		session.setAttribute("price", price);
		
		
		MemberVO vo = (MemberVO) session.getAttribute("user");  //LoginServlet放的
		if(vo!=null){
			RequestDispatcher rd = request.getRequestDispatcher("CheckCustomOrder.jsp");
			rd.forward(request, response);				
		}else{		
			String uri = "/Surf/CheckCustomOrder.jsp";
			session.setAttribute("dest", uri);					
			response.sendRedirect("/Surf/members/index.jsp");					
		}
			
	}
}
