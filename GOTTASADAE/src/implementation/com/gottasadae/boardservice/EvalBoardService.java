package implementation.com.gottasadae.boardservice;

import static implementation.com.gottasadae.board.JDBC.getConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import implementation.com.gottasadae.boarddao.EvalBoardDAO;
import implementation.com.gottasadae.boarddto.EvalBoardDTO;
import implementation.com.gottasadae.member.MemberDTO2;

public class EvalBoardService {
	
	public ArrayList<EvalBoardDTO> boardEvaluationList(int startRow, int endRow) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		ArrayList<EvalBoardDTO> evalBoardList = dao.boardEvaluationList(startRow, endRow);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return evalBoardList;
	}
	
	public int boardEvalCount() {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int result = dao.boardEvalCount();
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean boardEvalWrite(EvalBoardDTO dto) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int uploadResult = dao.boardEvalWrite(dto);
		boolean result;
		
		if(uploadResult > 0) {
			result = true;
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			result = false;
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
		
		return result;
	}
	
	public int evalBoardHit(int eval_num) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int hitResult = dao.evalBoardHit(eval_num);
		
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
	
	public EvalBoardDTO boardEvalContents(int eval_num) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		EvalBoardDTO evalBoardList = dao.boardEvalContents(eval_num);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return evalBoardList;
	}
	
	public EvalBoardDTO BoardEvalModifyView(String evalBoardnum) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		EvalBoardDTO evalBoardList = dao.BoardEvalModifyView(evalBoardnum);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return evalBoardList;
	}
	
	public boolean BoardEvalModifyComplete(EvalBoardDTO dto) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		boolean modifyResult = false;
		int result = dao.BoardEvalModifyComplete(dto);
		
		if(result > 0) {
			modifyResult = true;
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			modifyResult = false;
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
		
		return modifyResult;
	}
	
	public boolean BoardEvalDelete(int evalBoardNum) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int result = dao.BoardEvalDelete(evalBoardNum);
		boolean deleteResult = false;
		
		if(result > 0) {
			deleteResult = true;
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			deleteResult = false;
			try {
				conn.rollback();
			} catch (SQLException e) {
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
	
	public MemberDTO2 BoardEvalUserDetail(String id) {
		EvalBoardDAO dao = EvalBoardDAO.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		MemberDTO2 memberList = dao.BoardEvalUserDetail(id);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
}
