package com.iu.s1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankBookController {
	private BankBookDAO bankBookDAO;
	
	
	public BankBookController() {
		// TODO Auto-generated constructor stub
		bankBookDAO = new BankBookDAO();
	}
	
	
	
	public void start(HttpServletRequest request , HttpServletResponse response) {
		System.out.println("BankBook Controller 실행");
		
		String st = request.getRequestURI();
		String path ="";
		
		int startIndex = st.lastIndexOf("/");
		int lastIndex = st.lastIndexOf(".");
		path = st.substring(startIndex,lastIndex); //  /test
		
		// path = st.substring(startindex)
		String test = request.getPathInfo();
		System.out.println("test : "+ test);
		
		
		if(path.equals("/bankbookList")) {
			System.out.println("상품목록");
			ArrayList<BankBookDTO> ar =new ArrayList<BankBookDTO>();
			
			ar = bankBookDAO.getList();
			
			// for(모은타입명 변수명:컬렉션참조변수명)
			// for(BankBookDTO bankbookDTO:ar){
			// System.out.println(bankbookDTO.getBookNumber());
			//}
			
			
			for(int i =0; i<ar.size();i++) {
				System.out.println(ar.get(i).getBookNumber());
				System.out.println(ar.get(i).getBookName());
				System.out.println(ar.get(i).getBookRate());
				System.out.println(ar.get(i).getBookSale());
				
			}
			
			RequestDispatcher view =request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			request.setAttribute("ar", ar);
			
			try {
				
				view.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(path.equals("/bankbookInsert")) {
			System.out.println("상품등록");
			
			String method = request.getMethod();
			
			
			if(method.equals("POST")) {
				
				String bn =	request.getParameter("bookName");
				String br = request.getParameter("bookRate");
				String bs = request.getParameter("bookSale");
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookName(bn);
				bankBookDTO.setBookRate(Double.parseDouble(br));
				bankBookDTO.setBookSale(Integer.parseInt(bs));
				
				int result = bankBookDAO.setInsert(bankBookDTO);
				System.out.println(result);
				
//				ArrayList<BankBookDTO> ar =bankBookDAO.getList();
//				request.setAttribute("ar", ar);
				
				try {
					response.sendRedirect("./bankbookList.do");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}else {
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookInsert.jsp");	
			
				try {
					view.forward(request, response);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else if(path.equals("/bankbookSelect")) {
			System.out.println("상품상세조회");
			long value = Long.parseLong(request.getParameter("booknumber"));
			BankBookDTO bankBookDTO  = new BankBookDTO();
			bankBookDTO.setBookNumber(value);
			
			bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
			
			System.out.println(bankBookDTO.getBookName());
			
			HttpSession session =request.getSession();
			session.setAttribute("se", "session");
			request.setAttribute("se", "request");
			
			RequestDispatcher view =request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			
			request.setAttribute("dto",bankBookDTO );
			request.setAttribute("count", 123);
			request.setAttribute("name", "iu");
			
			try {
				
				view.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("그외 나머지");
		}
		
		
		
	}

}
