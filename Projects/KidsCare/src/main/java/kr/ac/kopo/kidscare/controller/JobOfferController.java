package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.kidscare.model.JobOffer;
import kr.ac.kopo.kidscare.service.JobOfferService;

@RestController
@RequestMapping("/joboffer")
public class JobOfferController {
	
	@Autowired
	JobOfferService service;
	
	@GetMapping("/list")
	List<JobOffer> list(){
		List<JobOffer> list = service.list();
		
		return list;
	}

	@PostMapping
	void add(@RequestBody JobOffer offerInfo) {
		service.add(offerInfo);
	}
	
	@GetMapping("/{offerId}")
	JobOffer getInfo(@PathVariable String offerId) {
		return service.getOfferInfo(offerId);
	}
	
	@PutMapping("/{offerId}")
	void update(@PathVariable String offerId, @RequestBody JobOffer offerInfo) {
		offerInfo.setOfferId(offerId);
		
		service.update(offerInfo);
	}
}
