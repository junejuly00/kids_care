package kr.ac.kopo.kidscare.model;

public class KcUserPost {
	private Integer userPostId;
	private String username;
	private String date;
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
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
