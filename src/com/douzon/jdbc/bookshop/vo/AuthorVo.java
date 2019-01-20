package com.douzon.jdbc.bookshop.vo;

public class AuthorVo {
	private long no;
	private String name;
	private String bio;
	
	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "AuthorVo [no=" + no + ", name=" + name + ", bio=" + bio + "]";
	}
}
