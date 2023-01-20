package com.iu.main.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.iu.main.util.DBConnection;

public class EmployeeDAO {
	
	//월급의 평균
	public HashMap<String, Double> getAvg() throws Exception{
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		Connection connection = DBConnection.getConnection();
		String sql ="SELECT AVG(SALARY)*12+100 AS A, SUM(SALARY) AS B FROM EMPLOYEES";
		
		PreparedStatement st = connection.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		//1. List, Array
		//2. DTO(class)
		//3.Map(Key,Value)
		
		map.put("avg", rs.getDouble("A"));
		map.put("sum", rs.getDouble(2));
		
		
		System.out.println(rs.getDouble("A"));
		System.out.println(rs.getDouble(2));
	
		
		DBConnection.disConnect(rs, st, connection);
		return map;
	}
	
	
	
	//insert
	public int setData(EmployeeDTO employeeDTO)throws Exception{
		Connection connection = DBConnection.getConnection();
		String sql ="INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, JOB_ID, COMMISSION_PCT,HIRE_DATE, PHONE_NUMBER, EMAIL)"
				+ " VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, ?,?,?,?)";
		
		
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, employeeDTO.getFirst_name());
		st.setString(2, employeeDTO.getLast_name());
		st.setDouble(3, employeeDTO.getSalary());
		st.setString(4, employeeDTO.getJob_id());
		st.setDouble(5, employeeDTO.getCommission_pct());
		st.setString(6, employeeDTO.getHire_date());
		st.setString(7, employeeDTO.getPhone_number());
		st.setString(8, employeeDTO.getEmail());
		
		int result = st.executeUpdate();
		
		return result; 
	}
	
	
	
	
	//method 1 : query 1 각각
	
	public ArrayList<EmployeeDTO> getFind(String search) throws Exception {
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		Connection connection = DBConnection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE '%'||?||'%'";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setString(1, search);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setSalary(rs.getDouble("SALARY"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			
			ar.add(employeeDTO);
			
		}
			DBConnection.disConnect(rs, st, connection);
			return ar;
		
		
		
	}
	
	
	
	public EmployeeDTO getDetail(int employee_id) throws Exception {
		
		EmployeeDTO employeeDTO = null;
		
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, employee_id);
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			employeeDTO.setHire_date(rs.getString("HIRE_DATE"));
			
		}
		
		DBConnection.disConnect(rs, st, connection);
		
		return employeeDTO;
		
	}
	
	
	
	public ArrayList<EmployeeDTO> getList() throws Exception {
		
		
		ArrayList<EmployeeDTO>ar = new ArrayList<EmployeeDTO>();
		//DB연결
		Connection connection = DBConnection.getConnection();
		//쿼리문 생성
		String sql = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME , JOB_ID ,DEPARTMENT_ID "
				+ "FROM EMPLOYEES "
				+ "ORDER BY HIRE_DATE DESC";
		//미리 전송
		PreparedStatement st = connection.prepareStatement(sql);
		//최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
			employeeDTO.setFirst_name(rs.getString("FIRST_NAME"));
			employeeDTO.setLast_name(rs.getString("LAST_NAME"));
			employeeDTO.setJob_id(rs.getString("JOB_ID"));
			employeeDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			
			ar.add(employeeDTO);
		}
		//연결 해제
			DBConnection.disConnect(rs, st, connection);
			return ar;
		
		
		
	}
	
	
	

}
