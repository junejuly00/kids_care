package kr.ac.kopo.kidscare.model;

public class UserReview {
	private String reviewId;
	private String userId;
	private String sitterId;
	private Byte rating;
	private String reviewInfo;
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
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
}
