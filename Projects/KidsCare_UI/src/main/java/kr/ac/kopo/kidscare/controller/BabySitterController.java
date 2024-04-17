package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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

@Controller
@RequestMapping("/babysitter")
public class BabySitterController {
	
	final String url = "http://localhost:9090/babysitter/";
	
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
		
		List<BabySitter> list = om.readValue(body, new TypeReference<List<BabySitter>>() {	});
		model.addAttribute("list", list);
		
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
	
	@GetMapping("/update/{sitterId}")
	String update(@PathVariable String sitterId, Model model) {
		BabySitter sitterInfo = rest.getForObject(url + sitterId, BabySitter.class);
		
		model.addAttribute("sitterInfo", sitterInfo);
		
		return "babysitter/update";
	}
	
	@PostMapping("/update/{sitterId}")
	String update(@PathVariable String sitterId, BabySitter sitterInfo) throws JsonProcessingException {
		sitterInfo.setSitterId(sitterId);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(sitterInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + sitterId, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{sitterId}")
	String delete(@PathVariable String sitterId) {
		RequestEntity<Void> req = RequestEntity.delete(url + sitterId).build();
		
		ResponseEntity<Integer> result = rest.exchange(req, Integer.class);
		
		System.out.println(result);
		
		return "redirect:../list";
	}
	
}
