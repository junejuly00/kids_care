package kr.ac.kopo.kidscare.model;

public class UserFile {
	private Long code;
	private Integer userPostId;
	private String filename;
	private String uuid;
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public Integer getUserPostId() {
		return userPostId;
	}
	public void setUserPostId(Integer userPostId) {
		this.userPostId = userPostId;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
