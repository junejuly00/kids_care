package kr.ac.kopo.kidscare.model;

public class KcUserPost {
	private Integer userPostId;
	private String username;
	private String postdate;
	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String contents;

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

	public String getDate() {
		return postdate;
	}

	public void setDate(String postdate) {
		this.postdate = postdate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
