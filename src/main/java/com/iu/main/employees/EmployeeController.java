package com.iu.main.employees;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
	private Scanner sc;
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private EmployeeInput employeeInput;
	
	
	public EmployeeController() {
		this.sc = new Scanner(System.in);
		this.employeeDAO= new EmployeeDAO();
		this.employeeView = new EmployeeView();
		this.employeeInput = new EmployeeInput();
		
	}
	
	
	public void start () throws Exception {
		
		boolean check = true;
		ArrayList<EmployeeDTO>ar=null;
		EmployeeDTO employeeDTO = new EmployeeDTO();

		
		while(check) {
			System.out.println("1. 사원 정보 리스트");
			System.out.println("2. 개별 사원 정보");
			System.out.println("3. 사원 검색");
			System.out.println("4. 사원 추가");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 사원 수정");
			System.out.println("7. 종료");
			
			int select =  sc.nextInt();
			
			switch(select) {
			case 1:
				ar = employeeDAO.getList();
				employeeView.view(ar);
				break;
			case 2:
				System.out.println("사원 ID 입력");
				select = sc.nextInt();
				employeeDTO = employeeDAO.getDetail(select);
				if(employeeDTO!=null) {
					employeeView.view(employeeDTO);
				}else {
					employeeView.view("그런 사람은 없어요");
				}
				break;
			case 3:
				System.out.println("사원 이름 입력");
				String name = sc.next();
				ar = employeeDAO.getFind(name);
				if(ar.size()>0) {
					employeeView.view(ar);
					
				}else {
					employeeView.view("그런사람은 없어요");
				}
				break;
			case 4 :
				employeeDTO =employeeInput.setData();
				select = employeeDAO.setData(employeeDTO);
				if(select > 0) {
					employeeView.view("추가 성공");
				}else {
					employeeView.view("추가 실패");
				}
				break;
			case 5 :
				
				break;
			case 6 :
				
				break;
			default :
				check=false;
			
			
			}
		}
	}	
}
