package kr.ac.kopo.kidscare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.KCUser;

@Controller
@RequestMapping("/kcuser")
public class KCUserController {
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	private final String defaultUrl = "http://localhost:9090/kcuser/default/";
	
	@PostMapping("/default/register")
	String register(KCUser userInfo) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(userInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject(defaultUrl + "register", request, Integer.class);
		
		
		
		return "redirect:../../list";
	}
	
	@GetMapping("/default/update_info")
	String updateInfo(Model model) {
		KCUser userInfo = rest.getForObject(defaultUrl +"update_info", KCUser.class);
		model.addAttribute("userInfo", userInfo);
		return "/kcuser/default/update_info";
	}
	
	@PostMapping("/default/update_info")
	String updateInfo(@PathVariable String userId, KCUser userInfo) throws JsonProcessingException {
		userInfo.setUserid(userId);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(userInfo);
		
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> response = rest.exchange(defaultUrl + "userId", HttpMethod.POST, request, Integer.class);
		
		Integer result = response.getBody();
		
		return "redirect:../../list";
	}
}
