package controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(location = "", 
fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)

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
		
		String dimension = "";
		String frontpui
		
		
		request.getParameter("p2");
		request.getParameter("width");
		request.getParameter("length");
		request.getParameter("thick");
		request.getParameter("material");
		request.getParameter("fincount");
		request.getParameter("finsys");
		request.getParameter("boardcolor");
		request.getParameter("print1");
		request.getParameter("print2");
		request.getParameter("p1");
		
	}

}
