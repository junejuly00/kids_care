package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.JobCondition;

@Controller
@RequestMapping("/jobcondition")
public class JobConditionController {
	final String url = "http://localhost:9090/jobcondition/";
	
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
		
		List<JobCondition> list = om.readValue(body, new TypeReference<List<JobCondition>>() {});
		
		model.addAttribute("list",list);
		
		return "jobcondition/list";
	}
	
	@GetMapping("/add")
	String add() {
		return "jobcondition/add";
	}
	
	@PostMapping("/add")
	String add(JobCondition conditionInfo) {
		
	}
}
