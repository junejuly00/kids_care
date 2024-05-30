package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;
import kr.ac.kopo.kidscare.service.BabySitterService;

@RestController
@RequestMapping("/babysitter")
public class BabySitterController {
	
	@Autowired
	BabySitterService service;
	
	
	
	@GetMapping("/list")
	List<BabySitter> list(){
		List<BabySitter> list = service.list();
		
		return list;
	}
	
	@PostMapping("/list")
	PagerMap<BabySitter> list(@RequestBody Pager pager) {
		PagerMap<BabySitter> map = new PagerMap<BabySitter>();
		List<BabySitter> list = service.list(pager);
		
		map.setList(list);
		map.setPager(pager);
		
		return map;
		
	}
	
		
	@PostMapping("/add")
	void add(@RequestBody BabySitter sitterInfo) {
		service.add(sitterInfo);
	}
	
	@GetMapping("/{username}")
	BabySitter sitterInfo(@PathVariable String username) {
		return service.sitterInfo(username);
	}
	
	@PutMapping("/{username}")
	void update(@PathVariable String username, @RequestBody BabySitter sitterInfo) {
		sitterInfo.setUsername(username);

		service.update(sitterInfo);
	}
	
	@PostMapping("/sitter/find/{username}")
	public BabySitter findSitter(@PathVariable String username) {
		
		return service.sitterInfo(username);
	}
	
	@GetMapping("/detail/{username}")
	List<BabySitter> detail(@PathVariable String username){
		List<BabySitter> sitterList = service.detail(username);
		
		return sitterList;
	}
	
	
		

}
