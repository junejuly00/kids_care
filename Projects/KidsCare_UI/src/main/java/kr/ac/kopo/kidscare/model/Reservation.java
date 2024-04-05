package kr.ac.kopo.kidscare.model;

public class Reservation {
	private String resId;
	private String userId;
	private String sitterId;
	private String resDate;
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSitterId() {
		return sitterId;
	}
	public void setSitterId(String sitterId) {
		this.sitterId = sitterId;
	}
	public String getResDate() {
		return resDate;
	}
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
}
