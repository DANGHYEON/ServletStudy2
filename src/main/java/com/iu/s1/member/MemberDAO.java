package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iu.s1.util.DBConnector;

public class MemberDAO {
	
	private MemberDTO dto;
	private DBConnector connector;
	
	public MemberDAO() {
		// TODO Auto-generated constructor stub
		dto=new MemberDTO();
		connector = new DBConnector();
	}

	public int memberJoin(MemberDTO memberDTO) throws Exception {
		Connection con =null;
		PreparedStatement st = null;
		int result = 0;
		
		con = connector.getConnect();
		
		String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?)";
		
		
			st = con.prepareStatement(sql);
			
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			st.setString(4, memberDTO.getPhone());
			st.setString(5, memberDTO.getEmail());
			
			
			result = st.executeUpdate();
			
			
	
			connector.disConnect(st, con);
		
		
		return result;
		
		
		
	}
	
	
	
}
