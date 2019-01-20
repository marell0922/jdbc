package com.douzon.jdbc.bookshop.test;

import java.util.List;

import com.douzon.jdbc.bookshop.dao.AuthorDao;
import com.douzon.jdbc.bookshop.vo.AuthorVo;

public class AuthorDaoTest {
	public static void main(String[] args) {
		/*insertTest("스테파니 메이어");
		insertTest("조정래");
		insertTest("김동인");
		insertTest("김난도");
		insertTest("천상병");
		insertTest("원수연");
		getListTest();*/
		getDateTest(2);
		//deleteTest(6);
	}
	
	public static void insertTest(String name) {
		AuthorVo vo=new AuthorVo();
		vo.setName(name);
		vo.setBio("");
		
		new AuthorDao().insert(vo);
	}
	
	public static void getListTest() {
		List<AuthorVo> list=new AuthorDao().getList();
		for(AuthorVo authorVo : list) {
			System.out.println(authorVo);
		}
	}
	
	public static void getDateTest(long author_no) {
		AuthorVo authorVo=new AuthorDao().getDate(author_no);
		System.out.println(authorVo);
	}
	
	/*public static void updateTest(long no, String name, String bio) {
		AuthorVo authorVo=new AuthorVo();
		authorVo.setNo(no);
		authorVo.setName(name);
		authorVo.setBio(bio);
	}
	
	public static void deleteTest(long no) {
		new AuthorDao().delete(no);
	}*/
}
