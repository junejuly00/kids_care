package kr.ac.kopo.kidscare.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Reservation {
	private String resId;
	private String username;
	private String sittername;
	
	private String resDate;
	
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
	public String getSitterUsername() {
		return sittername;
	}
	public void setSitterUsername(String sitterUsername) {
		this.sittername = sitterUsername;
	}
	
}
