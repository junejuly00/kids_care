package kr.ac.kopo.kidscare.model;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class KCUserPost {
	private Long userPostId;
	private String username;
	@DateTimeFormat(pattern="yyyyMMddHHmmss")
	private String postdate;
	private String contents;
	private String title;
	private List<UserFile> userFiles;
	

	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public Long getUserPostId() {
		return userPostId;
	}
	public void setUserPostId(Long userPostId) {
		this.userPostId = userPostId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public List<UserFile> getUserFiles() {
		return userFiles;
	}
	public void setUserFiles(List<UserFile> userFiles) {
		this.userFiles = userFiles;
	}
	
	
	
}
