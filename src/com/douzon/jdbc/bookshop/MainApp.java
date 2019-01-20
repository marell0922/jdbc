package com.douzon.jdbc.bookshop;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class MainApp {
	public static void main(String[] args) {
		displayBookInfo();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		long no = scanner.nextLong();
		scanner.close();
		
		rent(no);
		displayBookInfo();
	}
	
	private static void rent(long no) {
		BookVo bookVo=new BookDao().getBookVo(no);
		if(bookVo.getStatus().equals("대여중")) {
			System.out.println("이미 대여중인 도서입니다. 다른 도서를 선택해 주세요!");
			return;
		}
		
		new BookDao().updateStatus(no, "대여중");
		System.out.println(bookVo.getTitle()+"이(가) 대여 됐습니다.");
	}
	
	private static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기******");
		List<BookVo> list=new BookDao().getList();
		for(BookVo bookVo:list) {
			System.out.println(bookVo);
		}
	}	
}
