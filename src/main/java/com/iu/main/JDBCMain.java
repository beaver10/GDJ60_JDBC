package com.iu.main;

import com.iu.main.departments.DepartmentController;
import com.iu.main.departments.DepartmentDAO;
import com.iu.main.departments.DepartmentDTO;
import com.iu.main.employees.EmployeeController;
import com.iu.main.locations.LocationController;
import com.iu.main.locations.LocationDAO;
import com.iu.main.locations.LocationDTO;
import com.iu.main.util.DBConnection;

public class JDBCMain {

	public static void main(String[] args) {
		System.out.println("start");
		
		DepartmentController dc = new DepartmentController();
		LocationController lc = new LocationController();
		EmployeeController ec = new EmployeeController();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		LocationDAO locationDAO = new LocationDAO();
		
		
		//참조변수명.멤버들
		try {
			//dc.start();
			//lc.start();
			ec.start();
			//DepartmentDTO departmentDTO = new DepartmentDTO();
			//LocationDTO locationDTO = new LocationDTO();
			
			//departmentDTO.setDepartment_id(300);
//			locationDTO.setLocation_id(3600);
//			locationDTO.setCity("Test");
//			locationDTO.setCountry_id("IT");
//			locationDTO.setPostal_code("Test");
//			locationDTO.setState_province(null);
//			locationDTO.setStreet_address("test");
			
			//int result =departmentDAO.deleteData(departmentDTO);
			//int result = locationDAO.deletedata(locationDTO);
			//int result = locationDAO.setdata(locationDTO);
			
//			if(result>0) {
//				System.out.println("성공");
//			}else {
//				System.out.println("실패");
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("finish");

	}

}
