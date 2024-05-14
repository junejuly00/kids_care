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

import kr.ac.kopo.kidscare.model.KCUserPost;

@Controller
@RequestMapping("/kcuserpost")
public class KCUserPostController {
	final String url = "http://localhost:9090/kcuserpost/";
	
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	
	
	@GetMapping("/list")
	String list(Model model) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String resp = rest.getForObject(url + "list", String.class);
		
		List<KCUserPost> list = om.readValue(resp, new TypeReference<List<KCUserPost>>() {});
		
		model.addAttribute("list", list);
		
		return "kcuserpost/list";
	}
	
	@GetMapping("/add")
	String add() {
		return "kcuserpost/add";
	}
	
	@PostMapping("/add")
	String add(KCUserPost item) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(item);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + item.getUserPostId().toString(), req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{userPostId}")
	String update(@PathVariable Long userPostId, Model model) {
		KCUserPost item = rest.getForObject(url + userPostId, KCUserPost.class);
		
		model.addAttribute("item", item);
		
		return "kcuserpost/update";
	}
	
	@PostMapping("/update/{userPostId}")
	String update(@PathVariable Long userPostId, KCUserPost item) throws JsonProcessingException {
		item.setUserPostId(userPostId);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(item);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + userPostId, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../kcuserpost";
	}
	
	@GetMapping("/post/{userPostId}")
	String post(@PathVariable Long userPostId, Model model) throws JsonProcessingException {
		
		KCUserPost postInfo = rest.getForObject(url + userPostId, KCUserPost.class);	
		
		model.addAttribute("postInfo", postInfo);
		
		return "kcuserpost/post";
	}
	
}
