package com.beehyv.assignment.springAssignment;

public class Hello {
	private long id;
	private String content;

	public Hello(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
}
