package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;

public class MemberController {
	
	public void start(HttpServletRequest request) {
		System.out.println("MemberController 실행");
		
		String st = request.getRequestURI();
		String path ="";
		
		int startIndex = st.lastIndexOf("/");
		int lastIndex = st.lastIndexOf(".");
		path = st.substring(startIndex,lastIndex); //  /test
		
		
		
		if(path.equals("/memberLogin")) {
			System.out.println("로그인");
		String id =	request.getParameter("id");
		String pw = request.getParameter("pw");	
			
			System.out.println("id : "+id);
			System.out.println("pw : "+pw);
			
		}else if(path.equals("/memberJoin")) {
			System.out.println("회원가입");
		}else if(path.equals("/memberPage")) {
			System.out.println("마이페이지");
		}
		
		
		
	}

}
