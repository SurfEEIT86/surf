package com.surf.forums.controller;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.ReplyVO;
import com.surf.members.model.MemberVO;


@Controller
@RequestMapping("/forums/getMemberPhoto")
public class LeaveMsgMemberPhoto{
	
	@Autowired
	ForumService forumService;
    @RequestMapping(value = "{userId}", headers = "Accept=image/jpeg, image/jpg, image/png, image/gif", method = RequestMethod.GET)
    public void getImage(@PathVariable int userId,HttpServletResponse response){
    	String imagesFile;
    	String imagePath;
    	imagesFile = "C:/Surf_data/memberInfo/";
        try {
			MemberVO vo = forumService.selectMember(userId);
			String pic=vo.getPic1();
			imagePath=imagesFile+pic;
			System.out.println(imagePath);
			File f = new File(imagePath);
			FileInputStream fin = new FileInputStream(f);
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			BufferedOutputStream bout = new BufferedOutputStream(out);
			int length = 0;
			while ((length = bin.read()) != -1) {
				bout.write(length);
				
			}
			bout.flush();
			bin.close();
			fin.close();
			bout.close();
			out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

	

}
