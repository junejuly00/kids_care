package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.kidscare.model.Reservation;
import kr.ac.kopo.kidscare.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	ReservationService service;
	
	@GetMapping("/totallist")
	List<Reservation> totalList() {
		List<Reservation> list = service.totalList();
		return list;
	}
	
	@PostMapping("/create")
	Integer create(@RequestBody Reservation rsvInfo) {
		return service.add(rsvInfo);
	}
	
	@DeleteMapping("/delete/{resId}")
	Integer delete(@PathVariable Long resId) {
		return service.delete(resId);
	}
	
	
}
