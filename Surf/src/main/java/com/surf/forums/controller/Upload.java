package com.surf.forums.controller;
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.io.PrintWriter;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.List;  

import javax.servlet.ServletConfig;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
  
 
@WebServlet("/forums/upload")
public class Upload extends HttpServlet {  

	private static final long serialVersionUID = 1L;
	private List<String> allowedImages = new ArrayList<String>();  
    private String uploadPath;  
      
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response);  
    }  
  
    /** 
     * 利用firebug可以看到ckeditor给我们生成了这样一段代码 
     * <form lang="zh-cn" action="servlet/upload?type=image&CKEditor=content&CKEditorFuncNum=1&langCode=zh-cn" dir="ltr" method="POST" enctype="multipart/form-data"> 
     *      <input type="file" size="38" name="upload"> 
     * </form> 
     * 可以知道ckeditor上传图片是提交到了servlet/upload?type=image&CKEditor=content&CKEditorFuncNum=1&langCode=zh-cn 
     * 这里面的CKEditorFuncNum是页面传过来的回调方法，在上传成功后应该回调这个方法，使生成的图片在预览窗口进行显示 
     */  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        String type = request.getParameter("type");  
        FileItemFactory itemFactory = new DiskFileItemFactory();  
        ServletFileUpload servletFileUpload = new ServletFileUpload(itemFactory);  
        try {  
            FileItemIterator itemIterator = servletFileUpload.getItemIterator(request);  
            //因为ckeditor只是上传文件，所以这里就可以这样写了  
            if (itemIterator.hasNext()) {  
                FileItemStream itemStream = itemIterator.next();  
                String name = itemStream.getName();  
                InputStream inputStream = itemStream.openStream();  
                String tagName = getTagName(name);  
                if (allowedImages.contains(tagName) && "image".equals(type)) {  
                    String fileName = this.geneFileName(tagName);  
                    this.upload(inputStream, fileName);  
                    String callback = request.getParameter("CKEditorFuncNum"); 
                    System.out.println(callback);
                    response.setContentType("text/html;charset=utf-8");  
                    PrintWriter out = response.getWriter();  
                    out.write("<script type=\"text/javascript\">");  
                    out.write("window.parent.CKEDITOR.tools.callFunction("+callback+",'http://localhost:8080/Surf/ckeditor/upload/"+fileName+"',''"+")");  
                    out.write("</script>");  
                }  
            }  
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
    @Override  
    public void init(ServletConfig config) throws ServletException {  
        // TODO Auto-generated method stub  
        String allowedImage ="jpg,jpeg,gif,png"; 
        String[] images = allowedImage.split(",");  
        for (String image:images)  
            allowedImages.add(image);  
        uploadPath = config.getServletContext().getRealPath("/ckeditor/upload"); 
        System.out.println(config.getServletContext().getRealPath("/ckeditor/upload"));
    }  
  
    private String getTagName(String fileName) {  
        int index = fileName.lastIndexOf(".")+1;  
        return fileName.substring(index);  
    }  
      
    private String geneFileName(String tagName) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");  
        return sdf.format(new Date()) + "." + tagName;  
    }  
      
    private void upload(InputStream inputStream, String fileName) throws IOException {  
        File file = new File(uploadPath, fileName);  
        OutputStream os = new FileOutputStream(file);  
        byte[] bytes = new byte[1024];  
        int len = 0;  
        while ((len = inputStream.read(bytes)) != -1) {  
            os.write(bytes, 0, len);  
        }  
        inputStream.close();  
        os.close();  
    }  
      
}  