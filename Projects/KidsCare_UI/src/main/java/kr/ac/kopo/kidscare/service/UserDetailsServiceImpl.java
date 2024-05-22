package kr.ac.kopo.kidscare.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.KCUserDao;
import kr.ac.kopo.kidscare.dao.SitterDao;
import kr.ac.kopo.kidscare.model.AllUserDetails;
import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.KCUser;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	KCUserDao userDao;
	
	@Autowired
	SitterDao sitterDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AllUserDetails user = new AllUserDetails();
		KCUser userInfo = userDao.searchById(username);
		BabySitter sitterInfo = sitterDao.searchSitterById(username);
		if (userInfo != null) {
			user.setId(userInfo.getUsername());
			user.setPassword(userInfo.getPassword()); 
			user.setName(userInfo.getName());
			user.setRole("USER");
			
			Set<GrantedAuthority> setUserAuth = new HashSet<GrantedAuthority>();
			setUserAuth.add(new SimpleGrantedAuthority("ROLE_USER"));
			user.setAuthority(setUserAuth);
			
			
		} else if(sitterInfo != null){
			user.setId(sitterInfo.getUsername());
			user.setPassword(sitterInfo.getPassword());
			user.setName(sitterInfo.getName());
			user.setRole("SITTER");
			
			Set<GrantedAuthority> setSitterAuth = new HashSet<GrantedAuthority>();
			setSitterAuth.add(new SimpleGrantedAuthority("ROLE_SITTER"));
			user.setAuthority(setSitterAuth);
		} 
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return user;
	}

}
