package com.douzon.jdbc.hr;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.hr.dao.EmployeeDao;
import com.douzon.jdbc.hr.vo.EmployeeVo;

public class HRMain {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
		System.out.print("검색 어 >> ");
		String line=sc.nextLine();
		
		if("quit".equals(line)) break;
		
		search(line);
		}
	}
	
	public static void search(String line) {
		
		System.out.println("==================== 검색 결과 =====================");
		List<EmployeeVo> list=new EmployeeDao().getList(line);
		
		for(EmployeeVo employeeVo :list) {
			System.out.println(employeeVo);
		}
	}
}
