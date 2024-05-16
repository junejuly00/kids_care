package kr.ac.kopo.kidscare.model;

import java.util.List;

public class KcUserPost {
	private Integer userPostId;
	private String username;
	private String postdate;
	private String contents;
	private String title;
	private List<UserFile> userFiles;
	
	public Integer getUserPostId() {
		return userPostId;
	}
	public void setUserPostId(Integer userPostId) {
		this.userPostId = userPostId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
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
	public List<UserFile> getUserFiles() {
		return userFiles;
	}
	public void setUserFiles(List<UserFile> userFiles) {
		this.userFiles = userFiles;
	}
	
	
}
