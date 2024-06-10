package kr.ac.kopo.kidscare.model;

public class Reservation {
	private String resId;
	private String username;
	private String sittername;
	private String resDate;
	private Integer status;
	
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	public String getSittername() {
		return sittername;
	}
	public void setSittername(String sittername) {
		this.sittername = sittername;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
