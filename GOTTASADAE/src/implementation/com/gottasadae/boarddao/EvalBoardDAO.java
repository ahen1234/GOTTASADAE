package implementation.com.gottasadae.boarddao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import implementation.com.gottasadae.boarddto.EvalBoardDTO;
import implementation.com.gottasadae.member.MemberDTO2;

public class EvalBoardDAO {
	private static EvalBoardDAO dao = new EvalBoardDAO();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static EvalBoardDAO getInstance() {
		return dao;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int boardEvalCount() {
		String sql = "select count(*) from evaluation";
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
	
	public ArrayList<EvalBoardDTO> boardEvaluationList(int startRow, int endRow) {
		String sql = "select * from eval_paging where eval_paging.rn between ? and ?";
		ArrayList<EvalBoardDTO> evalBoardList = new ArrayList<EvalBoardDTO>();
		EvalBoardDTO dto = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new EvalBoardDTO();
				dto.setEval_num(rs.getInt("eval_num"));
				dto.setEval_id(rs.getString("eval_id"));
				dto.setEval_subject(rs.getString("eval_subject"));
				dto.setEval_content(rs.getString("eval_content"));
				dto.setEval_file(rs.getString("eval_file"));
				dto.setEval_date(rs.getDate("eval_date"));
				dto.setEval_count(rs.getInt("eval_count"));
				
				evalBoardList.add(dto);
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
		
		return evalBoardList;
	}
	
	public int boardEvalWrite(EvalBoardDTO dto) {
		String sql = "insert into evaluation values(evaluation_seq.nextval, ?, ?, ?, sysdate, 0, ?)";
		int insertResult = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEval_id());
			pstmt.setString(2, dto.getEval_subject());
			pstmt.setString(3, dto.getEval_content());
			pstmt.setString(4, dto.getEval_file());
			insertResult = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return insertResult;
	}
	
	public int evalBoardHit(int eval_num) {
		String sql = "update evaluation set eval_count=eval_count+1 where eval_num=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eval_num);
			result = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return result;
	}
	
	public EvalBoardDTO boardEvalContents(int eval_num) {
		String sql = "select * from evaluation where eval_num=?";
		EvalBoardDTO evalBoardList = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eval_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				evalBoardList = new EvalBoardDTO();
				evalBoardList.setEval_num(rs.getInt("eval_num"));
				evalBoardList.setEval_id(rs.getString("eval_id"));
				evalBoardList.setEval_subject(rs.getString("eval_subject"));
				evalBoardList.setEval_content(rs.getString("eval_content"));
				evalBoardList.setEval_file(rs.getString("eval_file"));
				evalBoardList.setEval_date(rs.getDate("eval_date"));
				evalBoardList.setEval_count(rs.getInt("eval_count"));
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
		
		return evalBoardList;
	}
	
	public EvalBoardDTO BoardEvalModifyView(String evalBoardNum) {
		String sql = "select * from evaluation where eval_num=?";
		EvalBoardDTO evalBoardList = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, evalBoardNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				evalBoardList = new EvalBoardDTO();
				evalBoardList.setEval_num(rs.getInt("eval_num"));
				evalBoardList.setEval_id(rs.getString("eval_id"));
				evalBoardList.setEval_subject(rs.getString("eval_subject"));
				evalBoardList.setEval_content(rs.getString("eval_content"));
				evalBoardList.setEval_file(rs.getString("eval_file"));
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
		
		return evalBoardList;
	}
	
	public int BoardEvalModifyComplete(EvalBoardDTO dto) {
		String sql = "update evaluation set eval_subject=?, eval_content=?, eval_file=? "
				+ "where eval_num=?";		
		int insertResult = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEval_subject());
			pstmt.setString(2, dto.getEval_content());
			pstmt.setString(3, dto.getEval_file());
			pstmt.setInt(4, dto.getEval_num());
			insertResult = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return insertResult;
	}
	
	public int BoardEvalDelete(int evalBoardNum) {
		String sql = "delete from evaluation where free_num=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, evalBoardNum);
			result = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		
		return result;
	}
	
	public MemberDTO2 BoardEvalUserDetail(String id) {
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
