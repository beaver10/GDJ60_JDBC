package com.iu.main.locations;

import java.util.Scanner;

public class LocationInput {
	private Scanner sc;
	
	public LocationInput() {
		sc= new Scanner(System.in);
	}
	
	public LocationDTO updateData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("수정할 지역 ID 입력");
		locationDTO.setLocation_id(sc.nextInt());
		
		System.out.println("수정할 주소 입력");
		locationDTO.setStreet_address(sc.next());
		
		System.out.println("수정할 우편번호 입력");
		locationDTO.setPostal_code(sc.next());
		
		return locationDTO;
		
	}
	
	
	
	
	//추가
	public LocationDTO setData() {
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("주소 입력");
		locationDTO.setStreet_address(sc.next());
		
		System.out.println("우편번호 입력");
		locationDTO.setPostal_code(sc.next());
		
		System.out.println("도시 입력");
		locationDTO.setCity(sc.next());
		
		System.out.println("지역 입력");
		locationDTO.setState_province(sc.next());
		
		System.out.println("지역 주소 입력");
		locationDTO.setCountry_id(sc.next());
		
		
		return locationDTO;
		
		
	}
	
	//삭제
	
	public LocationDTO deleteData() {
		
		LocationDTO locationDTO = new LocationDTO();
		
		System.out.println("삭제할 지역 번호 입력");
		locationDTO.setLocation_id(sc.nextInt());
		
		return locationDTO;
		
		
	}
	
	

}
