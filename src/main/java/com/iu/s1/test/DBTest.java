package com.iu.s1.test;

import java.sql.Connection;
import java.util.ArrayList;

import com.iu.s1.bankbook.BankBookController;
import com.iu.s1.bankbook.BankBookDAO;
import com.iu.s1.bankbook.BankBookDTO;
import com.iu.s1.util.DBConnector;

public class DBTest {

	public static void main(String[] args) {
		// DBConnector connector = new DBConnector();
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
//		bankBookDTO.setBookNumber(1);
		
		
//		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
		
		ar = bankBookDAO.getList();
		
		for(int i =0; i<ar.size();i++) {
			System.out.println(ar.get(i).getBookNumber());
			System.out.println(ar.get(i).getBookName());
			System.out.println(ar.get(i).getBookRate());
			System.out.println(ar.get(i).getBookSale());
			
		}
		
//		System.out.println(bankBookDTO.getBookNumber());
//		System.out.println(bankBookDTO.getBookName());
//		System.out.println(bankBookDTO.getBookRate());
//		System.out.println(bankBookDTO.getBookSale());
//		

	}

}
