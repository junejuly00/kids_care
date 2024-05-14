package kr.ac.kopo.kidscare.model;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice {
	private Long code;
	private String username;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private String noticedate;
	private String contents;
	private String title;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNoticedate() {
		return noticedate;
	}
	public void setNoticedate(String noticedate) {
		this.noticedate = noticedate;
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
