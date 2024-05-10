package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.kidscare.model.Reservation;
import kr.ac.kopo.kidscare.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	ReservationService service;
	
	@GetMapping("/list")
	List<Reservation> totalList() {
		List<Reservation> list = service.totalList();
		return list;
	}
}
