package implementation.com.gottasadae.boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import implementation.com.gottasadae.boarddto.FreeBoardDTO;
import implementation.com.gottasadae.member.MemberDTO2;

public class FreeBoardDAO {
	private static FreeBoardDAO dao = new FreeBoardDAO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static FreeBoardDAO getInstance() {
		return dao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int boardFreeCount() {
		String sql = "select count(*) from freeboard";
		int boardCount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return boardCount;	
	}
	
	public ArrayList<FreeBoardDTO> boardFreetalkList(int startRow, int endRow) {
		String sql = "select * from freeboard_paging where freeboard_paging.rn between ? and ?";
		ArrayList<FreeBoardDTO> freeBoardList = new ArrayList<FreeBoardDTO>();
		FreeBoardDTO dto = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new FreeBoardDTO();
				dto.setFree_num(rs.getInt("free_num"));
				dto.setFree_id(rs.getString("free_id"));
				dto.setFree_subject(rs.getString("free_subject"));
				dto.setFree_content(rs.getString("free_content"));
				dto.setFree_file(rs.getString("free_file"));
				dto.setFree_date(rs.getDate("free_date"));
				dto.setFree_count(rs.getInt("free_count"));
				
				freeBoardList.add(dto);
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return freeBoardList;
	}
	
	public int boardFreeWrite(FreeBoardDTO dto) {
		String sql = "insert into freeboard values(freeboard_seq.nextval, ?, ?, ?, sysdate, 0, ?)";
		int insertResult = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFree_id());
			pstmt.setString(2, dto.getFree_subject());
			pstmt.setString(3, dto.getFree_content());
			pstmt.setString(4, dto.getFree_file());
			insertResult = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return insertResult;
	}
	
	public int freeBoardHit(int free_num) {	
		String sql = "update freeboard set free_count=free_count+1 where free_num=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			result = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return result;
	}
	
	public FreeBoardDTO boardFreetalkContents(int free_num) {
		String sql = "select * from freeboard where free_num=?";
		FreeBoardDTO freeBoardList = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, free_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				freeBoardList = new FreeBoardDTO();
				freeBoardList.setFree_num(rs.getInt("free_num"));
				freeBoardList.setFree_id(rs.getString("free_id"));
				freeBoardList.setFree_subject("free_subject");
				freeBoardList.setFree_content("free_content");
				freeBoardList.setFree_file(rs.getString("free_file"));
				freeBoardList.setFree_date(rs.getDate("free_date"));
				freeBoardList.setFree_count(rs.getInt("free_count"));
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return freeBoardList;
	}
	
	public FreeBoardDTO BoardFreetalkModifyView(String freeBoardNum) {
		String sql = "select * from freeboard where free_num=?";
		FreeBoardDTO freeBoardList = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, freeBoardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				freeBoardList = new FreeBoardDTO();
				freeBoardList.setFree_id(rs.getString("free_id"));
				freeBoardList.setFree_subject(rs.getString("free_subject"));
				freeBoardList.setFree_content(rs.getString("free_content"));
				freeBoardList.setFree_num(rs.getInt("free_num"));
				freeBoardList.setFree_file(rs.getString("free_file"));
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return freeBoardList;
	}
	
	public int BoardFreetalkModifyComplete(FreeBoardDTO dto) {
		String sql = "update freeboard set free_subject=?, free_content=?, free_file=? "
				+ "where free_num=?";		
		int insertResult = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFree_subject());
			pstmt.setString(2, dto.getFree_content());
			pstmt.setString(3, dto.getFree_file());
			pstmt.setInt(4, dto.getFree_num());
			insertResult = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return insertResult;
	}
	
	public int BoardFreetalkDelete(int freeBoardNum) {
		String sql = "delete from freeboard where free_num=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, freeBoardNum);
			result = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return result;
	}
	
	public MemberDTO2 BoardFreetalkUserDetail(String id) {
		String sql = "select * from user_info where id=?";
		MemberDTO2 memberList = null;
		
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberList = new MemberDTO2();
				memberList.setId(rs.getString("id"));
				memberList.setPassword(rs.getString("password"));
				memberList.setName(rs.getString("name"));
				memberList.setGender(rs.getString("gender"));
				memberList.setBirthyy(rs.getInt("birthyy"));
				memberList.setBirthmm(rs.getInt("birthmm"));
				memberList.setBirthdd(rs.getInt("birthdd"));
				memberList.setMail(rs.getString("mail"));
				memberList.setPhone(rs.getString("phone"));
				memberList.setAddress(rs.getString("address"));
				memberList.setMajor(rs.getString("major"));
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return memberList;
	}
}
