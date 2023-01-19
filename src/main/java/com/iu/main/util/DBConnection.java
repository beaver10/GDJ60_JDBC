package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
		
		//어디서든 메서드 생성안하고 쓸수 있게 static
	public static Connection getConnection() throws Exception {
		//1. 접속 정보 준비
		
		//ID
		String username="hr";
		//PW
		String password="hr";
		//url
		//String url="jdbc:oracle:thin:@localhost:1521:SID";
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
//요즘은 안써도 됨	
		//driver 
		String driver="oracle.jdbc.driver.OracleDriver";
		//클래스 타입처럼 쓰겠다 
		Class.forName(driver);
		
		//2. DB접속 실행
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
		
		
//		//3. Query문 생성
//		String sql="SELECT * FROM LOCATIONS";
//		//4. Query문 DB로 미리 전송 (미완성)
//		PreparedStatement st = connection.prepareStatement(sql);
//		//5. ? 값 세팅(option)
//		
//		//6. 최종 전송 및 결과 처리
//		ResultSet rs =st.executeQuery();
//		while(rs.next()) {
//			System.out.println(rs.getInt("LOCATION_ID"));
//			System.out.println(rs.getString("POSTAL_CODE"));
//			System.out.println(rs.getString("STREET_ADDRESS"));
//		}
//		
	}
	
	public static void disConnect(PreparedStatement st, Connection connection) throws Exception {
		st.close();
		connection.close();
	}
	
	
//		//7. 연결 해제
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection connection) throws Exception {
		rs.close();
		st.close();
		connection.close();
		
		
	}

}
