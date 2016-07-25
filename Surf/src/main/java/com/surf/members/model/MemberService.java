package com.surf.members.model;

public class MemberService {
	/*-----------------------spring---------------------------------*/
	MemberDAO memberDAO=null;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	/*會員登入*/
	public MemberVO memberLogin(String username,String password){
		MemberVO vo = memberDAO.select(username);
		if(vo!=null) {
			if(password!=null && password.length()!=0) {
				String pass = vo.getPassword();
				if(pass.equals(password)) {
					return vo;
				}
			}
		}
		return null;
	}
}
