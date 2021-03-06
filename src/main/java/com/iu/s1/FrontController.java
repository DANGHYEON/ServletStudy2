package com.iu.s1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.s1.bankbook.BankBookController;
import com.iu.s1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberController memberController;
	private BankBookController bankBookController;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        memberController = new MemberController();
        bankBookController = new BankBookController();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig(); //내장객체를 가지고 올때 
		HttpSession session = request.getSession();
		ServletContext context =session.getServletContext();
		context = getServletContext();
		
		
		
		
		
		
			System.out.println("FrontController 실행");
			String st = request.getRequestURI();
			System.out.println(st);
			//subString
			String path ="";
			int startIndex = request.getContextPath().toString().length();
			int lastIndex = st.lastIndexOf("/");
			path = st.substring(startIndex,lastIndex); //  결과 : /bankbook ('/' 빼고싶으면 startIndex+1)
			
			if(path.equals("/member")) {
				try {
					memberController.start(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(path.equals("/bankbook")) {
				
				bankBookController.start(request,response);
				
			}else
			{
				System.out.println("없는 url");
			}
			

			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
