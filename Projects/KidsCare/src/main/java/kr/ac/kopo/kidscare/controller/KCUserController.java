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

import kr.ac.kopo.kidscare.model.KCUser;
import kr.ac.kopo.kidscare.service.KCUserService;

@RestController
@RequestMapping("/kcuser")
public class KCUserController {
	
	@Autowired
	KCUserService service;
	
	@GetMapping("/list")
	List<KCUser> list(){
		List<KCUser> list = service.list();
		
		return list;
	}
		
	@PostMapping
	void add(@RequestBody KCUser item) {
		service.add(item);
	}
	
	@GetMapping("/{userId}")
	KCUser item(@PathVariable String userId) {
		return service.item(userId);			
	}
	
	@PutMapping("/{userId}")
	void update(@PathVariable String userId, @RequestBody KCUser item) {
		item.setUserId(userId);
		
		service.update(item);
	}
	
	
}
