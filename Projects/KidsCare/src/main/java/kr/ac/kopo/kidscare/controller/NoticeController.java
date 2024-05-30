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
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;
import kr.ac.kopo.kidscare.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	

	@Autowired
	NoticeService service;
	
	@PostMapping("/list")	
	PagerMap<Notice> list(@RequestBody Pager pager){
		PagerMap<Notice> map = new PagerMap<Notice>();
		
		List<Notice> list = service.list(pager);
		
		map.setList(list);
		map.setPager(pager);
	
	return map;
	}
	
	@PostMapping("/add")
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
	
	@GetMapping("/hide/{code}")
	void hide(@PathVariable Integer code) {
		service.hide(code);
	}
	
	@GetMapping("/mypost/{username}")
		List<Notice> mypost(@PathVariable String username ){
			List<Notice> myPostList = service.mypost(username);
			return myPostList;
	}
	
	
}
