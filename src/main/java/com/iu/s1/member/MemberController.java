package com.iu.s1.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {
	
	private MemberService memberService;
	private MemberDAO memberDAO;
	
	
	public MemberController() {
		// TODO Auto-generated constructor stub
		memberService = new MemberService();
		memberDAO = new MemberDAO();
	}
	
	
	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			
			String method = request.getMethod();
			
			if(method.equals("POST")) {
				int result = memberService.memberJoin(request, response);
				
				if(result>0) {
					response.sendRedirect("../index.jsp");
				}else {
					response.sendRedirect("./memberJoin.do");
				}
				
			}else { //get
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				view.forward(request, response);
				
			}
			
			
			System.out.println("회원가입");
		}else if(path.equals("/memberPage")) {
			System.out.println("마이페이지");
		}
		
		
		
	}

}
