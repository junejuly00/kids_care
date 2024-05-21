package kr.ac.kopo.kidscare.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class BabySitter implements UserDetails{

   private static final long serialVersionUID = 1L;
   
   private String username;
   private String password;
   private String name;
   private String phone;
   private String email;
   private Byte gender;
   private Short age;
   private String major;
   private Byte scope;
   private Integer avgRating;
   private String content;
   private Byte open;
   private String provider;


   private Integer status;
   private String insurance;
   private String document;
   private String other;
   private String worktime;
   private Integer cctv;
   private String nickname;
   private String startday;
   private String salary;

   private String title;
   
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public Integer getStatus() {
      return status;
   }
   public void setStatus(Integer status) {
      this.status = status;
   }
   public String getInsurance() {
      return insurance;
   }
   public void setInsurance(String insurance) {
      this.insurance = insurance;
   }
   public String getDocument() {
      return document;
   }
   public void setDocument(String document) {
      this.document = document;
   }
   public String getOther() {
      return other;
   }
   public void setOther(String other) {
      this.other = other;
   }
   public String getWorktime() {
      return worktime;
   }
   public void setWorktime(String worktime) {
      this.worktime = worktime;
   }
   public Integer getCctv() {
      return cctv;
   }
   public void setCctv(Integer cctv) {
      this.cctv = cctv;
   }
   public String getNickname() {
      return nickname;
   }
   public void setNickname(String nickname) {
      this.nickname = nickname;
   }
   public String getStartday() {
      return startday;
   }
   public void setStartday(String startday) {
      this.startday = startday;
   }
   public String getSalary() {
      return salary;
   }
   public void setSalary(String salary) {
      this.salary = salary;
   }

   public String getCareer() {
      return career;
   }
   public void setCareer(String career) {
      this.career = career;
   }
   private String career;
   
   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      
      List<SimpleGrantedAuthority> list = new ArrayList<>();
      list.add(new SimpleGrantedAuthority("ROLE_SITTER"));
      return list;
   }
   @Override
   public String getUsername() {
      // TODO Auto-generated method stub
      return username;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
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
   public Integer getAvgRating() {
      return avgRating;
   }
   public void setAvgRating(Integer avgRating) {
      this.avgRating = avgRating;
   }


   public String getProvider() {
      return provider;
   }
   public void setProvider(String provider) {
      this.provider = provider;
   }

   public void setUsername(String username) {
      this.username = username;
   }
   @Override
   public boolean isAccountNonExpired() {
      // TODO Auto-generated method stub
      return true;
   }
   @Override
   public boolean isAccountNonLocked() {
      // TODO Auto-generated method stub
      return true;
   }
   @Override
   public boolean isCredentialsNonExpired() {
      // TODO Auto-generated method stub
      return true;
   }
   @Override
   public boolean isEnabled() {
      // TODO Auto-generated method stub
      return true;
   }
   public Byte getOpen() {
      return open;
   }
   public void setOpen(Byte open) {
      this.open = open;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   
}

