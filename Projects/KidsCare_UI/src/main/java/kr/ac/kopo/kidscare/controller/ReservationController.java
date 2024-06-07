package kr.ac.kopo.kidscare.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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
		model.addAttribute("resInfo",resInfo);
		
		return "/reservation/totallist";
	}
	
	@GetMapping("/{sitterId}")
	String newReservation(@PathVariable String sitterId, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String resUserName = auth.getName();
		model.addAttribute("resUser", resUserName);
		model.addAttribute("resSitter", sitterId);
		return "/reservation";
	}
	
	@PostMapping("/{sitterId}")
	String newReservation(@PathVariable String sitterId, Reservation rsvInfo) throws JsonProcessingException {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		rsvInfo.setUsername(username);
		rsvInfo.setSittername(sitterId);
		
		String jsonString = om.writeValueAsString(rsvInfo);
		HttpEntity<String> request = new HttpEntity<String>(jsonString, header);
		
		Integer body = rest.postForObject(defaultUrl+"create", request, Integer.class);
		
		
		return "redirect:/mypage/parents";
	}
	
	@GetMapping("/delete/{resId}")
	String delete(@PathVariable Long resId) {
		RequestEntity<Void> req = RequestEntity.delete(defaultUrl+resId).build();
		ResponseEntity<Integer> result = rest.exchange(defaultUrl+resId, HttpMethod.DELETE, req, Integer.class);
		System.out.println(result);
		
		return "redirect:../list";
	}
}
