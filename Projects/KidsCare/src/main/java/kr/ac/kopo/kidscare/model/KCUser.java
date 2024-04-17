package kr.ac.kopo.kidscare.model;

public class KCUser {
	private String username;
	private String name;
	private String phone;
	private String email;
	private Byte role;
	
	
	public String getUserId() {
		return username;
	}
	public void setUserId(String username) {
		this.username = username;
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
	
}
