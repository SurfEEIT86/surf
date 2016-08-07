package Test;

import com.surf.members.model.MemberVO;


public class aaa {
	public static void main(String[] args){
		MemberVO a = new MemberVO();
		a.setName("Aname");
		MemberVO b = a;
		
		b.setName("Bname");
		System.out.println(a.getName());
	}
}
