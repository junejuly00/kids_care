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

import kr.ac.kopo.kidscare.model.Notice;
import kr.ac.kopo.kidscare.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	

	@Autowired
	NoticeService service;
	
	@GetMapping("/list")
	List<Notice> list(){
		List<Notice> list = service.list();
	
	return list;
	}
	
	@PostMapping("/{code}")
	void add(@RequestBody Notice item) {
		service.add(item);
	}
	
	@GetMapping("/{code}")
	Notice item(@PathVariable Integer code) {
		return service.item(code);
	}
	
	@PutMapping("/{code}")
	void update(@PathVariable Integer code ,@RequestBody Notice item) {
		item.setCode(code);
		
		service.update(item);
	}
	
}
