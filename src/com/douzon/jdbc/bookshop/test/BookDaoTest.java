package com.douzon.jdbc.bookshop.test;

import java.util.List;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insertTest("트와일라잇", 1);
		insertTest("뉴문", 1);
		insertTest("이클립스", 1);
		insertTest("브레이킹던", 1);
		insertTest("아리랑", 2);
		insertTest("젊은그들", 3);
		insertTest("아프니깐 청춘이다", 4);
		insertTest("귀천", 5);
		insertTest("태백산맥", 2);
		insertTest("풀하우스", 6);
		getListTest();
		updateStatusTest(6);
		getListNoTest(6);
		getListTest();
	}
	
	public static void insertTest(String title, long authorNo) {
		BookVo bookVo=new BookVo();
		bookVo.setTitle(title);
		bookVo.setAuthorNo(authorNo);
		
		new BookDao().insert(bookVo);
		
	}
	
	public static void getListTest() {
		List<BookVo> list=new BookDao().getList();
		
		for(BookVo bookVo : list) {
			System.out.println(bookVo);
		}
	}

	public static void updateStatusTest(long no) {
		new BookDao().updateStatus(no, "대여중");
	}
	
	public static void getListNoTest(long no) {
		BookVo bookVo =new BookDao().getBookVo(no);
		
		System.out.println(bookVo);
		
	}
}
