package kr.ac.kopo.kidscare.model;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Notice {
	private Integer code;
	private String username;
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private String postdate;
	private String contents;
	private String title;
	private Integer status;
	
	private List<NoticeFile> noticeFiles;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
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
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public List<NoticeFile> getNoticeFiles() {
		return noticeFiles;
	}
	public void setNoticeFiles(List<NoticeFile> noticeFiles) {
		this.noticeFiles = noticeFiles;
	}

}
