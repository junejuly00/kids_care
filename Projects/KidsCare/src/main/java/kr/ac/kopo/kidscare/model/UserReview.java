package kr.ac.kopo.kidscare.model;

public class UserReview {
	private String reviewId;
	private String username;
	private String sitterUsername;
	private Byte rating;
	private String reviewInfo;
	private Byte status;
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Byte getRating() {
		return rating;
	}
	public void setRating(Byte rating) {
		this.rating = rating;
	}
	public String getReviewInfo() {
		return reviewInfo;
	}
	public void setReviewInfo(String reviewInfo) {
		this.reviewInfo = reviewInfo;
	}
	public String getSitterUsername() {
		return sitterUsername;
	}
	public void setSitterUsername(String sitterUsername) {
		this.sitterUsername = sitterUsername;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
}
