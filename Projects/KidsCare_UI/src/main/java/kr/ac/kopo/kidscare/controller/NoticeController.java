package kr.ac.kopo.kidscare.controller;

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

import kr.ac.kopo.kidscare.model.Notice;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;

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
	String list(Model model,Pager pager) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(pager);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);

		ResponseEntity<String> resp = rest.postForEntity(url + "list", req, String.class);
	
		String body = resp.getBody();

		PagerMap<Notice> map = om.readValue(body, new TypeReference<PagerMap<Notice>>() { });

		model.addAttribute("list", map.getList());
		model.addAttribute("pager", map.getPager());
		
		return "notice/list";

	}
	
	@GetMapping("/add")
	String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	String add(Notice item) throws JsonProcessingException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currUser = auth.getName();
		item.setUsername(currUser);
		
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(item);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + "add", req, Integer.class);
		
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
	
	@GetMapping("/post/{code}")
		String post(@PathVariable Long code, Model model) throws
		JsonProcessingException {
		
		Notice postInfo = rest.getForObject(url + code, Notice.class);	
		
		model.addAttribute("postInfo", postInfo);
		
		return "notice/post";
	}

	
	
	@GetMapping("/hide/{code}")
	String hide(@PathVariable Integer code) {
		Notice item = rest.getForObject(url + "hide/" + code.toString() , Notice.class);				
		return "redirect:../list";
		
	}

}
