package com.surf.forums.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.forums.model.ForumService;
import com.surf.forums.model.ForumVO;

@WebServlet("/forums/photo.do")
public class PhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForumService forumService;
	

	public void init() throws ServletException {
		
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("image/jpeg");
		String imagesFile;
		String imagePath;
		imagesFile = "C:/Surf_data/forums/Images/";
		String id = request.getParameter("forumNo");
		ForumVO vo = forumService.selectForum(Integer.parseInt(id));
		imagePath = imagesFile + vo.getPic1();
		File f = new File(imagePath);
		System.out.println(imagePath);
		if (f.exists()) {
			writeImgToBrowser(response, imagePath);
			System.out.println("run here!!!!");
		} else {
			if (f.exists()) {
				writeImgToBrowser(response, vo.getPic1());
				System.out.println("run aaaa!!!!");
			}
		}

	}

	public void writeImgToBrowser(HttpServletResponse response, String imagePath)
			throws IOException {
		File photo = new File(imagePath);
		FileInputStream fin = new FileInputStream(photo);
		OutputStream out = response.getOutputStream();
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int length = 0;
		;
		while ((length = bin.read()) != -1) {
			bout.write(length);
			
		}
		bout.flush();
		bin.close();
		fin.close();
		bout.close();
		out.close();
	}

	public void makeImgFromDb(String type, String id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;database=surf", "sa",
					"passw0rd");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ServletContext context = getServletContext();
		FileOutputStream out = null;
		Blob blob = null;
		try {
			PreparedStatement pstat = conn
					.prepareStatement("SELECT photo from " + type
							+ " WHERE id =" + id);
			ResultSet rs = pstat.executeQuery();
			if (rs.next()) {

				blob = rs.getBlob(1);
			}
			if (blob != null) {
				InputStream is = blob.getBinaryStream();
				String path = context.getRealPath("/photo/" + type + id
						+ ".jpg");
				File img = new File(path);

				try {
					out = new FileOutputStream(img);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				try {
					BufferedInputStream bin = new BufferedInputStream(is);
					BufferedOutputStream bout = new BufferedOutputStream(out);
					int length = 0;
					;
					while ((length = bin.read()) != -1) {
						bout.write(length);
					}
					bin.close();
					is.close();
					bout.close();
					out.close();
					rs.close();
					conn.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
