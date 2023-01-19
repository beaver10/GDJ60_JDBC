package com.iu.main.employees;

import java.util.ArrayList;

public class EmployeeView {
	
	
	public void view(String msg) {
		
		System.out.println(msg);
		
	}
	
	public void view(EmployeeDTO employeeDTO) {
		
		System.out.println(employeeDTO.getEmployee_id());
		System.out.println(employeeDTO.getFirst_name());
		System.out.println(employeeDTO.getLast_name());
		System.out.println(employeeDTO.getJob_id());
		System.out.println(employeeDTO.getDepartment_id());
		
	}
	
	
	
	public void view(ArrayList<EmployeeDTO>ar) {
		for(EmployeeDTO employeeDTO : ar) {
			this.view(employeeDTO);
			
			
		}
	}
	
	
	
	

}
