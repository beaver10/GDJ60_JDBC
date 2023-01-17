package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public void getConnection() throws Exception {
		//1. ID
		String username="hr";
		//2. PW
		String password="hr";
		//3. url
		String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
		//4. driver
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		String sql="SELECT * FROM LOCATIONS WHERE COUNTRY_ID='US'";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs =st.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("LOCATION_ID"));
			System.out.println(rs.getString("POSTAL_CODE"));
			System.out.println(rs.getString("STREET_ADDRESS"));
		}
		
	}

}
