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

import kr.ac.kopo.kidscare.model.Notice;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	final String path = "notice/";
	final String url = "http://localhost:9090/notice/";
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping("/list")
	String list(Model model) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String resp = rest.getForObject(url + "list", String.class);
		
		List<Notice> list = om.readValue(resp, new TypeReference<List<Notice>>() {});
		
		model.addAttribute("list", list);
		
		return path + "list";
		
	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Notice item) throws JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(item);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + item.getCode().toString(), req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{code}")
	String update(@PathVariable Long code, Model model) {
		Notice item = rest.getForObject(url + code, Notice.class);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{code}")
	String update(@PathVariable Long code, Notice item) throws JsonProcessingException {
		item.setCode(code);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(item);
		
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString ,header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + code, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../list";
	}
	

}
