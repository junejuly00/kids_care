package kr.ac.kopo.kidscare.model;

public class KCUser {
	private String userid;
	private String name;
	private String phone;
	private String email;
	private Byte role;
	private String provider;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Byte getRole() {
		return role;
	}
	public void setRole(Byte role) {
		this.role = role;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
}
