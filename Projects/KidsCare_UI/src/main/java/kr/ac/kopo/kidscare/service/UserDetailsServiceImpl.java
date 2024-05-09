package kr.ac.kopo.kidscare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.dao.KCUserDao;
import kr.ac.kopo.kidscare.model.KCUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	KCUserDao dao;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public KCUser loadUserByUsername(String username) throws UsernameNotFoundException {
		
		KCUser user = dao.searchById(username);
		
		if (user != null) {
			
			
		
			return user;
		} else {
			throw new UsernameNotFoundException(username);
		}
				
	}
	
		
}
