package kr.ac.kopo.kidscare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.Reservation;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	private final String defaultUrl = "http://localhost:9090/reservation/";
	
	@GetMapping("/totallist")
	String list(Model model) throws JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		Reservation resInfo = rest.getForObject( defaultUrl +"list", Reservation.class);
		model.addAttribute(resInfo);
		
		return "/reservation/totallist";
	}
}
