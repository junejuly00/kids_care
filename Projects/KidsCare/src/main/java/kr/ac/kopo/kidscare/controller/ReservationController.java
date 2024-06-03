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
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.kidscare.model.Reservation;
import kr.ac.kopo.kidscare.service.ReservationService;

@RestController
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
	void create(@RequestBody Reservation rsvInfo) {
		service.add(rsvInfo);
	}
	
	@GetMapping("/parent/{username}")
	List<Reservation> parentResvList(@PathVariable String username) {
		List<Reservation> list = service.parentList(username);
		return list;
	}
	
	@GetMapping("/parent/past/{username}")
	List<Reservation> parentPastList(@PathVariable String username) {
		List<Reservation> list = service.parentPastList(username);
		return list;
	}
	
	
	@DeleteMapping("/delete/{resId}")
	Integer delete(@PathVariable Long resId) {
		return service.delete(resId);
	}
	
	
}
