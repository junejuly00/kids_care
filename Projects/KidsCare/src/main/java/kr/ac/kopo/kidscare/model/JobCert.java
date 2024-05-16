package kr.ac.kopo.kidscare.model;

public class JobCert {
	private String certName;
	private String username;
	private String certDate;
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
	public String getSitterId() {
		return username;
	}

	public void setSitterId(String username) {
		this.username = username;

	}
	public String getCertDate() {
		return certDate;
	}
	public void setCertDate(String certDate) {
		this.certDate = certDate;
	}
	public String getTermination() {
		return termination;
	}
	public void setTermination(String termination) {
		this.termination = termination;
	}
	private String termination;
	
}
