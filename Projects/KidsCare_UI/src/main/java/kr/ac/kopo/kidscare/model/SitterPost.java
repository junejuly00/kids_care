package kr.ac.kopo.kidscare.model;


public class SitterPost {
	private Long sitterPostId;
	private String username;
	private String date;
	private String contents;
	
	public Long getSitterPostId() {
		return sitterPostId;
	}
	public void setSitterPostId(Long sitterPostId) {
		this.sitterPostId = sitterPostId;
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
