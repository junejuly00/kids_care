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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.JobOffer;

@Controller
public class JobOfferController {
	
	final String url = "http://localhost:9090/joboffer/";
	
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
		

		List<JobOffer> list = om.readValue(body, new TypeReference<List<JobOffer>>() {} );

		model.addAttribute("list", list);
						
		return "joboffer/list";	
	}
	
	@GetMapping("/add")
	String add() {
		return "joboffer/add";
	}
	
	@PostMapping("/add")
	String add(JobOffer offerInfo) throws JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(offerInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + "add", req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{offerId}")
	String update(@PathVariable Long offerId, Model model) {
		JobOffer offerInfo = rest.getForObject(url + offerId, JobOffer.class);
		
		model.addAttribute("offerInfo", offerInfo);
		
		return "joboffer/update";
	}
	
	@PostMapping("/update/{offerId}")
	String update(@PathVariable String offerId, JobOffer offerInfo) throws JsonProcessingException {
		offerInfo.setOfferId(offerId);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(offerInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + offerId, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{offerId}")
	String delete(@PathVariable String offerId) {
		RequestEntity<Void> req = RequestEntity.delete(url + offerId).build();
		
		ResponseEntity<Integer> result = rest.exchange(req, Integer.class);
		
		System.out.println(result);
		
		return "redirect:../list";
	}
}
