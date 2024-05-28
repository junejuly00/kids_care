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

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.JobCert;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;

@Controller
@RequestMapping("/babysitter")
public class BabySitterController {
	
	final String url = "http://localhost:9090/babysitter/";
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping("/list")
	String list(Model model, Pager pager) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(pager);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		ResponseEntity<String> resp = rest.postForEntity(url + "list", req, String.class);
		String body = resp.getBody();
		
		PagerMap<BabySitter> map = om.readValue(body, new TypeReference<PagerMap<BabySitter>>() {});

		model.addAttribute("list", map.getList());
		model.addAttribute("pager", map.getPager());
				
		
		return "babysitter/list";
	}
	
	@GetMapping("/add")
	String add() {
		return "babysitter/add";
	}
	
	@PostMapping("/add")
	String add(BabySitter sitterInfo) throws JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(sitterInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + "add", req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{username}")
	String update(@PathVariable String username, Model model) {
		BabySitter sitterInfo = rest.getForObject(url + username, BabySitter.class);
		
		model.addAttribute("sitterInfo", sitterInfo);
		
		return "babysitter/update";
	}
	
	@PostMapping("/update/{username}")
	String update(@PathVariable String username, BabySitter sitterInfo) throws JsonProcessingException {
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
	
	@GetMapping("/detail/{username}")
	String post(@PathVariable String username, Model model) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String resp = rest.getForObject("http://localhost:9090/jobcert/search/" + username, String.class);
		List<JobCert> certList = om.readValue(resp, new TypeReference<List<JobCert>>() {});
		BabySitter sitterInfo = rest.getForObject(url + username, BabySitter.class);	
		System.out.println(sitterInfo.getUsername());
		
		model.addAttribute("sitterInfo", sitterInfo);
		model.addAttribute("jobcert", certList);
		
		return "babysitter/detail";
	}
}
