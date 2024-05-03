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

import kr.ac.kopo.kidscare.model.UserReview;
import kr.ac.kopo.kidscare.service.UserReviewService;

@RestController
@RequestMapping("/userreview")
public class UserReviewController {
	
	@Autowired
	UserReviewService service;
	
	@GetMapping("/list")
	List<UserReview> list(){
		List<UserReview> list = service.list();
		
		return list;
	}
	
	@PostMapping
	void add(@RequestBody UserReview userreviewInfo) {
		service.add(userreviewInfo);
	}
	
	@GetMapping("/{reviewId}")
	UserReview userreviewInfo(@PathVariable String reviewId, @RequestBody UserReview userreviewInfo) {
		return service.userreviewInfo(reviewId);
	}
	
	@PutMapping("/{reviewId}")
	void update(@PathVariable String reviewId, @RequestBody UserReview userreviewInfo) {
		userreviewInfo.setReviewId(reviewId);
		
		service.update(userreviewInfo);
	}
}