package com.iu.s1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.s1.util.DBConnector;

public class BankBookDAO {
	
	private DBConnector connector;
	private BankBookDTO bankBookDTO;
	
	
	public BankBookDAO() {
		connector = new DBConnector();
		
		
	}
	
	
	public int setInsert(BankBookDTO bankbookDTO) {
		Connection con =null;
		PreparedStatement st=null;
		int result = 0;
		con = connector.getConnect();
		
		String spl = "INSERT INTO BANKBOOK VALUES(bankbook_seq.nextval,?,?,?) ";
		
		try {
			st =con.prepareStatement(spl);
			
			
			st.setString(1, bankbookDTO.getBookName());
			st.setDouble(2, bankbookDTO.getBookRate());
			st.setInt(3, bankbookDTO.getBookSale());
		
			
			result = st.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connector.disConnect(st, con);
		}
		
		
		return result;
		
		
	}
	
	
	
	public ArrayList<BankBookDTO> getList() {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Connection con =null;
		PreparedStatement st = null;
		ResultSet rs =null;
		bankBookDTO = null;
		con = connector.getConnect();
		
		String sql = "SELECT * FROM BANKBOOK";
		
		try {
			st= con.prepareStatement(sql);
			
			rs=st.executeQuery();
			
			while(rs.next()) {
				bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNumber(rs.getLong("BOOKNUMBER"));
				bankBookDTO.setBookName(rs.getString("BOOKNAME"));
				bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
				bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
				
				ar.add(bankBookDTO);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connector.disConnect(rs, st, con);
		}
		
		return ar;
		
		
	}
	
	
	
	
	
	public BankBookDTO getSelect(BankBookDTO bankbookdto) {
		Connection con =null;
		PreparedStatement st=null;
		ResultSet rs =null;
		bankBookDTO = null;
		
		con = connector.getConnect();
		
		String sql="SELECT * FROM BANKBOOK WHERE BOOKNUMBER=?";
		
		try {
			st=con.prepareStatement(sql);
			st.setLong(1, bankbookdto.getBookNumber());
			
			rs=st.executeQuery();
			
			if(rs.next()) {
				
				bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNumber(rs.getLong("BOOKNUMBER"));
				bankBookDTO.setBookName(rs.getString("BOOKNAME"));
				bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
				bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connector.disConnect(rs, st, con);
		}
		
		
		return bankBookDTO;
		
		
	}
	
	
	
	
	
	
	
	

}
