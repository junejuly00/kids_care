package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.UserReview;

@Controller
@RequestMapping("/userreview")
public class UserReviewController {
	final String url = "http://localhost:9090/userreview/";
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping("/list")
	String list(Model model) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> req = new HttpEntity<String>(header);
		
		ResponseEntity<String> resp = rest.postForEntity(url + "list", req, String.class);
		
		String body = resp.getBody();
		
		List<UserReview> list = om.readValue(body, new TypeReference<List<UserReview>>() {});
		
		model.addAttribute("list", list);
		
		return "userreview/list";
	}
	
	@GetMapping("/add/{username}")
	String add(@PathVariable String username, Model model) {
		model.addAttribute("sitterName", username);
		return "userreview/add";
	}
	
	@PostMapping("/add/{username}")
	String add(UserReview reviewInfo, @PathVariable String username) throws JsonProcessingException {
		String parentName = SecurityContextHolder.getContext().getAuthentication().getName();
		reviewInfo.setUsername(parentName);
		reviewInfo.setSitterUsername(username);
		reviewInfo.setStatus((byte) 0);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(reviewInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + "add", req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:../../mypage/parents";
	}
	
	@GetMapping("/update/{reviewId}")
	String update(@PathVariable String reviewId, Model model) {
		UserReview userreviewInfo = rest.getForObject(url + reviewId, UserReview.class);
		
		model.addAttribute("reviewInfo", userreviewInfo);
		
		return "userreview/update";
	}
	
	@PostMapping("/update/{reviewId}")
	String update(@PathVariable String reviewId, UserReview userreviewInfo) throws JsonProcessingException {
		userreviewInfo.setReviewId(reviewId);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(userreviewInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + reviewId, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../list";
	}
	
	
	
}
