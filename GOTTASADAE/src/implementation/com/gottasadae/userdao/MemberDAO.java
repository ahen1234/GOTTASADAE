package implementation.com.gottasadae.userdao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import implementation.com.gottasadae.member.MemberDTO;
import implementation.com.gottasadae.member.MemberDTO3;
import implementation.com.gottasadae.member.MemberLoginDTO;





public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() { // 데이터 연결 메서드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String db_id = "TH"; // 각자 수정
			String db_pw = "tmakdlf1"; // 각자 수정

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//String 생일 데이터 합쳐서 를 SQL DATE 으로 바꿈
	public Date birthDate(MemberDTO member){ 
		String year = member.getBirthyy();
		String month = member.getBirthmm();
		String day = member.getBirthdd();
		
		Date birth  = null;
		
		if(year != null && month != null && day != null){
			birth = Date.valueOf(year+"-"+month+"-"+day);
		}
		return birth;
	}
	
	//DB 종료
		private void close(Connection conn, PreparedStatement pstmt,ResultSet rs) {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	
	//회원가입
	public int insertMember(MemberDTO member) {
		int join = 0;
		try {
			
			conn = this.getConnection();

			String sql = "INSERT INTO USER_INFO VALUES (?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setDate(5, birthDate(member));
			pstmt.setString(6, member.getMail());
			pstmt.setString(7, (member.getPhone()));
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getMajor());

			join = pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return join;
	} 
	
	
	
	// 로그인 메서드
	public int login(MemberLoginDTO MLDTO) {
		String SQL = "SELECT Password FROM USER_INFO WHERE ID = ?";

		try {
			conn = this.getConnection();

			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, MLDTO.getId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("Password").equals(MLDTO.getPwd())) {
					return 1;
				} else
					return 0;
			}
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.close(conn, pstmt, rs);
		}
		return -2;
	}
	
	// 아이디 중복체크
	public int idCheck(String id) {
		int value = 0;
		
		try {

			conn= this.getConnection();
			
			String sql ="SELECT ID"; 
				  sql +=" FROM USER_INFO"; 
				  sql +=" WHERE ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				value = 1;				
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	// 마이페이지 회원정보
	public MemberDTO getUserInfo(String id) {
     
        MemberDTO member = null;
        try {
            // 쿼리
            StringBuffer query = new StringBuffer();
            query.append("SELECT * FROM USER_INFO WHERE ID=?");
 
            conn = this.getConnection();
            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
 
            if (rs.next()) {
              
                String birthday = rs.getDate("BIRTH").toString();
                String year = birthday.substring(0, 4);
                String month = birthday.substring(5, 7);
                String day = birthday.substring(8, 10);                       
                member = new MemberDTO();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setGender(rs.getString("gender"));
                member.setBirthyy(year);
                member.setBirthmm(month);
                member.setBirthdd(day);
                member.setMail(rs.getString("MAIL"));
                member.setPhone(rs.getString("phone"));
                member.setAddress(rs.getString("address"));
                member.setMajor(rs.getString("MAGOR"));
            }
 
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          this.close(conn, pstmt, rs);
        }
		return member;
    }   
	
	
	
	 public MemberDTO3 memberCheck(String id) {
		 
	        String sql = "SELECT * FROM USER_INFO WHERE ID=?";
	        MemberDTO3 DTO = new MemberDTO3();
	        try {
	            conn = getConnection();
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	            	DTO.setId(rs.getString("ID"));
	            	DTO.setPassword(rs.getString("PASSWORD"));
	            	DTO.setName(rs.getString("NAME"));
	            	DTO.setGender(rs.getString("GENDER"));
	            	DTO.setBirth(rs.getDate("BIRTH"));
	            	DTO.setMail(rs.getString("MAIL"));
	            	DTO.setPhone(rs.getString("PHONE"));
	            	DTO.setAdress(rs.getString("ADDRESS"));
	            	DTO.setMajor(rs.getString("MAJOR"));           
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            close(conn, pstmt, rs);
	        }
	        return DTO;
	    }
	
	

	
	
	 public int updateMember(MemberDTO member) throws Exception {
		 	int flag = 0;
	        conn = this.getConnection();
	        String sql = "UPDATE USER_INFO SET PASSWORD=?,BIRTH=?,MAIL=?,PHONE=?,ADRESS=?,MAGOR=? WHERE NAME=? AND GENDER=?";
	        try {
	            pstmt = conn.prepareStatement(sql);
	 
	           
	            pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getGender());
				pstmt.setDate(5, birthDate(member));
				pstmt.setString(6, member.getMail());
				pstmt.setString(7, (member.getPhone()));
				pstmt.setString(8, member.getAddress());
				pstmt.setString(9, member.getMajor());
	 
				flag = pstmt.executeUpdate();
	 
	            if (flag == 1) {
	           
	                return 1;
	 
	            } else {
	                return 0;
	            }
	        } catch (Exception e) {
	            System.out.println("uptateMember E : ");
	            e.printStackTrace();
	        } finally {
	            this.close(conn, pstmt, null);
	        }
	        return 3;
	    }
	 
	 
	
	 public void deleteUser(String id) {
			String sql = "DELETE FROM USER_INFO WHERE ID = ?";

			try {
				conn = this.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				this.close(conn, pstmt, rs);
			}
		}
	
	
	
	
	
	
	} 
		
		
			
	
	
		

	
	

