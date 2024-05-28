package kr.ac.kopo.kidscare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.KCUser;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	final String path = "signup/";
	
	
	@GetMapping
	public String selectSignup() {
		return "signup/select";
	}
	
	@GetMapping("/parents")
	public String userSignup() {
		return path + "user";
	}
	
	@PostMapping("/parents")
	public String userSignup(KCUser userInfo) throws JsonProcessingException {
		userInfo.setStatus((byte) 0);
		userInfo.setRole((byte) 1);
		
		String rawPassword = userInfo.getPassword();
		userInfo.setPassword(passwordEncoder.encode(rawPassword));
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(userInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject("http://localhost:9090/kcuser/add", request, Integer.class);
		
		return "redirect:../login";
	}
	
	
	
	@GetMapping("/sitter")
	public String sitterSignup() {
		return path + "sitter";
	}
	@PostMapping("/sitter")
	public String sitterSignup(BabySitter sitterInfo) throws JsonProcessingException {
	
		sitterInfo.setOpen((byte) 1);
		
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(sitterInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject("http://localhost:9090/babysitter/add", request, Integer.class);
		
		return "redirect:../login";
		
	}
}
