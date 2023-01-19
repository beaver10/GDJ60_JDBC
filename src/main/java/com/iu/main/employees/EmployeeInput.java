package com.iu.main.employees;

import java.util.Scanner;

public class EmployeeInput {
	private Scanner sc;
	
	public EmployeeInput() {
		sc = new Scanner(System.in);
	}
	
	
	public EmployeeDTO setData() {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		System.out.println("추가할 성 입력");
		employeeDTO.setFirst_name(sc.next());
		
		System.out.println("추가할 이름 입력");
		employeeDTO.setLast_name(sc.next());
		
		System.out.println("추가할 월급 입력");
		employeeDTO.setSalary(sc.nextDouble());
		
		System.out.println("추가할 직급 입력");
		employeeDTO.setJob_id(sc.next());
		
		System.out.println("추가할 커미션 입력");
		employeeDTO.setCommission_pct(sc.nextDouble());
		
		System.out.println("추가할 입사일 입력");
		employeeDTO.setHire_date(sc.next());
		
		
		st.setDate(6, employeeDTO.getHire_date());
		st.setString(7, employeeDTO.getPhone_number());
		st.setString(8, employeeDTO.getEmail());
		
		
		return employeeDTO;
	}
	
	

}
