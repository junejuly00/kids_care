package kr.ac.kopo.kidscare.model;

public class BabySitter {
	private String username;
	private String name;
	private String phone;
	private String email;
	private Byte gender;
	private Short age;
	private String major;
	private Byte scope;
	private Integer rating;
	public String getSitterId() {
		return username;
	}
	public void setSitterId(String username) {
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
	public Byte getGender() {
		return gender;
	}
	public void setGender(Byte gender) {
		this.gender = gender;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Byte getScope() {
		return scope;
	}
	public void setScope(Byte scope) {
		this.scope = scope;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
