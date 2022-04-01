package t4_DBTest_VO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTestDAO {
 Connection conn = null;
 Statement stmt = null;
 ResultSet rs = null;
 
 String sql = "";
 
 // 컨트롤 + 스페이스바 + 엔터 => 생성자 만들기
 // 처음 DAO생성시에 Database 연결한다.
 public DBTestDAO() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/javagreen";
		String user = "root";
		String password = "1234";
		conn = DriverManager.getConnection(url, user, password);
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 검색 실패~~~");
	} catch (SQLException e) {
		System.out.println("데이터베이스 연결 실패~~~");
	}
}
	
	//Database Close
	public void dbClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	// statement객체 Close
	public void stmtClose() {
		try {
			if(stmt != null) stmt.close();
			} catch (Exception e) {}
	}
	
	// resultset객체 Close
	public void rsClose() {
		try {
			if(rs != null) {
				rs.close();
				stmtClose();
			}
		} catch (Exception e) {}
	}
	
	// 개별자료 조회하기
	public DBTestVO search(String name) {
		DBTestVO vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest where name='"+name+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String joinday = rs.getString("joinday");
				System.out.println("========================");
				System.out.println("성명 : " + name);
				System.out.println("나이 : " + age);
				System.out.println("성별 : " + gender);
				System.out.println("가입일 : " + joinday);
				System.out.println("========================");
			}
			else {
				System.out.println("========================");
				System.out.println(name + "을(를) 찾지 못했습니다.");
				System.out.println("========================");
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());			
		} finally {
			rsClose();
		}	
		return vo;
	}
	

	// 자료 등록 처리하기
	public void input(DBTestVO vo) {
		try {
			stmt = conn.createStatement();
			sql = "insert into dbtest values (default,'"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getJoinday()+"')";
			stmt.executeUpdate(sql);
			System.out.println(vo.getName() + "님 자료가 등록되었습니다.");
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			stmtClose();
		}
	}

	// 전체자료 검색하기
	public ArrayList<DBTestVO> list() {
		ArrayList<DBTestVO> vos = new ArrayList<DBTestVO>();
		try {
			stmt = conn.createStatement();
			sql = "select * from dbtest order by idx desc";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				DBTestVO vo = new DBTestVO();   	 //while문 안으로 들어와야지 각각의 vo를 만들 수 있음.
				vo.setIdx(rs.getInt("idx")); 			 //레코드셋에 있는 idx를 vo에 넣어줌
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setJoinday(rs.getString("joinday"));
				
				vos.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	
	// 자료 수정하기
	public DBTestVO update(String name) {
		DBTestVO vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "update dbtest set ";
			stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
	
	
	// 자료 삭제하기 
	public DBTestVO delete(String name) {
		DBTestVO vo = new DBTestVO();
		try {
			stmt = conn.createStatement();
			sql = "delete from dbtest where name ='"+name+"'";
			stmt.executeUpdate(sql);
			if(rs.next()) {
				System.out.println(name + "님의 자료가 삭제되었습니다.");		
			}
			else {
				System.out.println(name + "님의 자료를 찾지 못했습니다.");
			}			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}
}
