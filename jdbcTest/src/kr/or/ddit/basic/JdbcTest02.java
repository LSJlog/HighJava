package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) 사용자로부터 Lprod_id값을 입력 받아 
//		 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.

public class JdbcTest02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Lprod_id값 입력 >> ");
		int num = scan.nextInt();
		
		// DB작업에 필요한 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "SEM", "java");
			
			String sql = "select * from lprod where lprod_id > " + num;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println(" == 실행 결과 ==");
			while(rs.next()) {
				System.out.println("Lprod_ID : " + rs.getInt("Lprod_ID"));
				System.out.println("Lprod_GU : " + rs.getString("Lprod_gu"));
				System.out.println("Lprod_NM : " + rs.getString("Lprod_nm"));
				System.out.println("----------------------------------------");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); }catch(SQLException e) {}
			if(stmt!=null) try { stmt.close(); }catch(SQLException e) {}
			if(conn!=null) try { conn.close(); }catch(SQLException e) {}
		}
		
		

	}

}
