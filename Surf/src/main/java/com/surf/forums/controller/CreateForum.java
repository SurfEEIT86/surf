package com.surf.forums.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.surf.forums.model.ForumService;
import com.surf.forums.model.ForumVO;


import util.imgSave;



@MultipartConfig(location = "", 
fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 500, 
maxRequestSize = 1024 * 1024 * 500 * 5)
@WebServlet("/forums/createForum.do")
public class CreateForum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumService forumService;
	/*應用系統根目錄*/
	private String imagesPath;
	@Override
	public void init() throws ServletException {
		//取得根目錄
//		rootPath=getServletContext().getContextPath();
		imagesPath = "C:/Surf_data/forums/Images/";
		
		ServletContext application = this.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(application);
		forumService=(ForumService)context.getBean("forumService");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 文字資料轉內碼
		// 準備存放錯誤訊息的Map物件
		Map<String, String> errorMsg = new HashMap<String, String>();
		// 準備存放註冊成功之訊息的Map物件
		Map<String, String> msgOK = new HashMap<String, String>();
		// 註冊成功後將用response.sendRedirect()導向新的畫面，所以需要
		// session物件來存放共用資料。
		HttpSession session = request.getSession();
        request.setAttribute("MsgMap", errorMsg);  //顯示錯誤訊息
        session.setAttribute("MsgOK", msgOK);      //顯示正常訊息
		System.out.println(request.getContentType());
		String forumNOStr = "";
		String forumTitle = "";
		String fileName = "";
		InputStream is = null;
		
		Part picp = null;
		// 1. 接收資料
		
		
		Collection<Part> parts = request.getParts();
		
		ForumService.exploreParts(parts,request);
		if (parts != null) { // 如果這是一個上傳資料的表單
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				// 1. 讀取使用者輸入資料
				if (p.getContentType() == null) {
					if (fldName.equals("forumNO")) {
						forumNOStr = value;
					} else if (fldName.equals("forumTitle")) {
						forumTitle = value;
					}else if (fldName.equals("forumPic")){
						is = p.getInputStream();
					}
				} else {
					fileName = ForumService.getFileName(p); // 此為圖片檔的檔名
					if (fileName != null && fileName.trim().length() > 0) {
						is = p.getInputStream();
						picp=p;
					} else {
						System.out.println(fileName+"00");
						errorMsg.put("errPicture", "必須挑選圖片檔");
					}

				}
			}

		}
		// 2. 進行必要的資料轉換

		
		// 3. 檢查使用者輸入資料
		if (forumTitle == null || forumTitle.trim().length() == 0) {
			errorMsg.put("errForumTitle","請輸入討論區名稱");
		}
		
		// 如果有錯誤
		
		if (!errorMsg.isEmpty()) {
			// 導向原來輸入資料的畫面，這次會顯示錯誤訊息
			RequestDispatcher rd = request.getRequestDispatcher("CreateForums.jsp");
			rd.forward(request, response);
			return;
		}
		
			ForumVO bean = new ForumVO();
			bean.setStatus(true);
			bean.setTitle(forumTitle);
			int len;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[8192];
			while ((len = is.read(buf, 0, 8192)) != -1)
		        	bos.write(buf, 0, len);
		    buf = bos.toByteArray();
		    
		    imgSave image = new imgSave();
		    image.imgSave(buf, picp,imagesPath);  
		    bean.setPic1(image.getFileName(picp));
		    try{
		    	ForumVO vo = forumService.insetForum(bean);
		    }catch (Exception e){
		    	System.out.println("insert討論區失敗");
		    }
		    getServletContext().removeAttribute("forums");
		    getServletContext().setAttribute("forums", forumService.getAllForums());
		    
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
}

