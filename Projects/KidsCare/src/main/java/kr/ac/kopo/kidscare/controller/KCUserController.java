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
import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;
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
		
	@PostMapping("/add")
	void add(@RequestBody KCUser userInfo) {
		service.add(userInfo);
	}
	
	@GetMapping("/find/{username}")
	KCUser getUserInfo(@PathVariable String username) {
		return service.getUserInfo(username);			
	}
	
	@PutMapping("/update/{username}")
	void update(@PathVariable String username, @RequestBody KCUser userInfo) {
		userInfo.setUsername(username);
		
		service.update(userInfo);
	}
	
	
	
	
}
