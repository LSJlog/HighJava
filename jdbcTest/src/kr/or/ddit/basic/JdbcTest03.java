package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제) Lprod_id값을 2개를 입력 받아서 
//		 두 값 중 작은 값부터 큰 값 사이의 자료들을 출력하시오.

public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 Lprod_ID값 입력 >> ");
		int num1 = scan.nextInt();
		
		System.out.print("두번째 Lprod_ID값 입력 >> ");
		int num2 = scan.nextInt();
		
//		int max = Math.max(num1, num2);
		int max = num1 > num2 ? num1 : num2;
		
		int min = Math.min(num1, num2);
		
		// DB작업용 객체 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "SEM", "java");
			
//			String sql = "select * from lprod where lprod_id >= " + min + " and lprod_id <= " + max;
			String sql = "select * from lprod where lprod_id between " + min + " and " + max;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println(" == 결과 출력 ==");
			while(rs.next()) {
				System.out.println("Lprod_ID : " + rs.getInt("lprod_id"));
				System.out.println("Lprod_GU : " + rs.getString("lprod_gu"));
				System.out.println("Lprod_NM : " + rs.getString("lprod_nm"));
				System.out.println("----------------------------------------");
			}
			
			System.out.println("출력 끝...");
			
					
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
