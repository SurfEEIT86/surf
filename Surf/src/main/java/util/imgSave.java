package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;


import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class imgSave {
	//將(上傳的)圖片寫入(伺服器端)硬碟
	public boolean imgSave(byte[] bytes,Part part,String url) {
		boolean result = false;
		if (bytes != null) {
			String fileName = getFileName(part);
			System.out.println(url);
			File files = new File(url+fileName);
			System.out.println(url+fileName);
			FileOutputStream fileOutputStream=null;
			try {
				fileOutputStream = new FileOutputStream(files);
				fileOutputStream.write(bytes);// 貼上
				fileOutputStream.flush();
				fileOutputStream.close();
				return result ;
			} catch (Exception e) {
				e.printStackTrace();
				return result ;
			}
		} else {
			return result ;
		}
	}
	//得到檔案名稱
	public String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			//System.out.println(content);
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}
}
