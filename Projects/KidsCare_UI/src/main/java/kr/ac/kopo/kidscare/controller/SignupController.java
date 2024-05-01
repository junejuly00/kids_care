package kr.ac.kopo.kidscare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	final String path = "signup/";
	
	@GetMapping("/user")
	public String userSignup() {
		return path + "user";
	}
	
	@PostMapping("/user")
	public String userSignup(KCUser userInfo) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(userInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject("kcuser/add", request, Integer.class);
		
		return "redirect:../login";
	}
	
	
	
	@GetMapping("/sitter")
	public String sitterSignup() {
		return path + "sitter";
	}
	@PostMapping("/sitter")
	public String sitterSignup(BabySitter sitterInfo) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(sitterInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject("sitter/add", request, Integer.class);
		
		return "redirect:../login";
		
	}
}
