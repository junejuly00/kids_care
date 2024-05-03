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

import kr.ac.kopo.kidscare.model.SitterPost;
import kr.ac.kopo.kidscare.service.SitterPostService;

@RestController
@RequestMapping("/sitterpost")
public class SitterPostController {
	
	@Autowired
	SitterPostService service;
	
	@GetMapping("/list")
	List<SitterPost> list() {
		List<SitterPost> list = service.list();
		
		return list;
	}
	
	@PostMapping
	void add(@RequestBody SitterPost item) {
		service.add(item);
	}
	
	@GetMapping("/{sitterpostid}")
	SitterPost item(@PathVariable Integer sitterpostid) {
		return service.item(sitterpostid);
	}
	
	@PutMapping("/{sitterpostid}")
	void update(@PathVariable Integer sitterpostid, @RequestBody SitterPost item) {
		item.setSitterPostId(sitterpostid);
		
		service.update(item);
	}
}