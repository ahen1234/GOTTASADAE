package implementation.com.gottasadae.boardservice;

import static implementation.com.gottasadae.board.JDBC.getConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import implementation.com.gottasadae.boarddao.FreeBoardDAO;
import implementation.com.gottasadae.boarddto.FreeBoardDTO;
import implementation.com.gottasadae.member.MemberDTO2;


public class FreeBoardService {
	
	public ArrayList<FreeBoardDTO> boardFreetalkList(int startRow, int endRow) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		ArrayList<FreeBoardDTO> freeBoardList = dao.boardFreetalkList(startRow, endRow);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return freeBoardList;
	}
	
	public int boardFreeCount() {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int result = dao.boardFreeCount();
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean boardFreeWrite(FreeBoardDTO dto) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int uploadResult = dao.boardFreeWrite(dto);
		boolean result;
		
		if(uploadResult > 0) {
			result = true;
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			result = false;
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int freeBoardHit(int free_num) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int hitResult = dao.freeBoardHit(free_num);
		if(hitResult > 0) {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hitResult;
	}
	
	public FreeBoardDTO boardFreetalkContents(int free_num) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		FreeBoardDTO freeBoardList = dao.boardFreetalkContents(free_num);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return freeBoardList;
	}
	
	public FreeBoardDTO BoardFreetalkModifyView(String freeBoardnum) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		FreeBoardDTO freeBoardList = dao.BoardFreetalkModifyView(freeBoardnum);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return freeBoardList;
	}
	
	public boolean BoardFreetalkModifyComplete(FreeBoardDTO dto) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		boolean modifyResult = false;
		int result = dao.BoardFreetalkModifyComplete(dto);
		
		if(result > 0) {
			modifyResult = true;
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			modifyResult = false;
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return modifyResult;
	}
	
	public boolean BoardFreetalkDelete(int freeBoardNum) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int result = dao.BoardFreetalkDelete(freeBoardNum);
		boolean deleteResult = false;
		
		if(result > 0) {
			deleteResult = true;
			try {
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			deleteResult = false;
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleteResult;
	}
	
	public MemberDTO2 BoardFreetalkUserDetail(String id) {
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		MemberDTO2 memberList = dao.BoardFreetalkUserDetail(id);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
}
