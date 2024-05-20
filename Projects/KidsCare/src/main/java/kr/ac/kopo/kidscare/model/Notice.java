package kr.ac.kopo.kidscare.model;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice {
	private Integer code;
	private String username;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private String postdate;
	private String contents;
	private String title;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getpostdate() {
		return postdate;
	}
	public void setpostdate(String postdate) {
		this.postdate = postdate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
