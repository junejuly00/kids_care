package kr.ac.kopo.kidscare.controller;

import java.util.List;

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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.Comment;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	final String url = "http://localhost:9090/comment/";
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping("/list")
	String list(Model model) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String resp = rest.getForObject(url + "list", String.class);
		

		List<Comment> list = om.readValue(resp, new TypeReference<List<Comment>>() {});
		
		
		model.addAttribute("list",list);	
		
		return url + "list";
	}
	
	@PostMapping("/add")
	String add(Comment commentInfo) throws JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(commentInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + "add", req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		String postId = commentInfo.getUserPostId().toString();
		
		return "redirect:../kcuserpost/post/" + postId;
	}
		
		@GetMapping("/update/{username}")
		String update(@PathVariable String username, Model model) {
		Comment commentInfo = rest.getForObject(url + username, Comment.class);
			
		model.addAttribute("commentInfo", commentInfo);
			
		return "comment/update";

	}
		
		@PostMapping("/update/{username}")
		String update(@PathVariable String username, Comment sitterInfo) throws JsonProcessingException {
			sitterInfo.setUsername(username);
			
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", "application/json");
			
			String jsonString = om.writeValueAsString(sitterInfo);
			
			HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
			
			ResponseEntity<Integer> resp = rest.exchange(url + username, HttpMethod.PUT, req, Integer.class);
			
			Integer result = resp.getBody();
			
			System.out.println(result);
			
			return "redirect:../list";	
		}
		
}
