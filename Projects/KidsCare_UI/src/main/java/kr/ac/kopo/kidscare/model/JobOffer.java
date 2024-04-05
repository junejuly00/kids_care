package kr.ac.kopo.kidscare.model;

public class JobOffer {
	private String offerId;
	private String userId;
	private String jobDate;
	private String jobInfo;
	private String estPay;
	private Integer viewCount;
	public String getOfferId() {
		return offerId;
	}
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJobDate() {
		return jobDate;
	}
	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}
	public String getJobInfo() {
		return jobInfo;
	}
	public void setJobInfo(String jobInfo) {
		this.jobInfo = jobInfo;
	}
	public String getEstPay() {
		return estPay;
	}
	public void setEstPay(String estPay) {
		this.estPay = estPay;
	}
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
}
