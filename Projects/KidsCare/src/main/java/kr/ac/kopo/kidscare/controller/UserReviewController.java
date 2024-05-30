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
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.service.UserReviewService;

@RestController
@RequestMapping("/userreview")
public class UserReviewController {
	
	@Autowired
	UserReviewService service;
	
	@GetMapping("/list")
	List<UserReview> list(Pager pager){
		List<UserReview> list = service.list(pager);
		
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
	
	@GetMapping("/find/{username}")
	List<UserReview> findByParent(@PathVariable String username, Pager pager) {
		List<UserReview> list = service.findByParent(username, pager);
		
		return list;
		
	}
	
	@GetMapping("/find/sitter/{username}")
	List<UserReview> findBySitter(@PathVariable String username, Pager pager) {
		pager.setKeyword(username);
		List<UserReview> list = service.findBySitter(pager);
		return list;
	}
	
}
