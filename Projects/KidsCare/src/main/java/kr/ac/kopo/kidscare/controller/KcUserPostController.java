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

import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.service.KCUserPostService;

@RestController
@RequestMapping("/kcuserpost")
public class KcUserPostController {
	@Autowired
	KCUserPostService service;
	
	@GetMapping("/list")
	List<KcUserPost> list(){
		List<KcUserPost> list = service.list();
		
		return list;
	}
	
	@PostMapping("/{userpostid}")
	void add(@RequestBody KcUserPost item) {
		service.add(item);
	}
	
	@GetMapping("/{userpostid}")
	KcUserPost item(@PathVariable Integer userPostId) {
		return service.item(userPostId);
	}
	
	@PutMapping("/{userpostid}")
	void update(@PathVariable Integer userPostId, @RequestBody KcUserPost item) {
		item.setUserPostId(userPostId);
		
		service.update(item);
	}
}
