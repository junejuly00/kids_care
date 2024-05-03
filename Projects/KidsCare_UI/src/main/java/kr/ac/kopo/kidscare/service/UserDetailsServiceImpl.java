package kr.ac.kopo.kidscare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.KCUser;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	public KCUser loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = null;
		try {
			jsonString = om.writeValueAsString(username);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<KCUser> resp = rest.postForEntity("/kcuser/find", req, KCUser.class);
		
		KCUser user = resp.getBody();
		
		if (user != null) {
			return user;
		}
		
		else {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
		}
		
		
	}
	
		
}
