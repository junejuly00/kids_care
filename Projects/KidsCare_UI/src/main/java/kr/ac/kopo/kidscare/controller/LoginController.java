package kr.ac.kopo.kidscare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.KCUser;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	final String path = "login/";
	
	
	@GetMapping("/user")
	String userLogin() {
		return path + "user";
	}
	
	@PostMapping("/user")
	String userLogin(KCUser userInfo) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(userInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject(""/* TODO */, request, Integer.class);
		
		return "redirect:../../secured";
	}
	
	@GetMapping("/sitter")
	String sitterLogin() {
		return path + "sitter";
	}
	
}
