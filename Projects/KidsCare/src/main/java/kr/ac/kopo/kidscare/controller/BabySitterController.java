package kr.ac.kopo.kidscare.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;
import kr.ac.kopo.kidscare.service.BabySitterService;

@RestController
@RequestMapping("/babysitter")
public class BabySitterController {
	private String uploadPath = "d:/upload/";
	
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
	
	@GetMapping("/find/{username}")
	BabySitter sitterInfo(@PathVariable String username) {
		return service.sitterInfo(username);
	}
	
	@PutMapping("/find/{username}")
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
	
	@ResponseBody
	@DeleteMapping("/delete_image/{code}")
	public ResponseEntity<String> deleteImage(@PathVariable Long code){
		SitterPhoto sitterphoto = service.itemImage(code);
		
		if(service.deleteImage(code)) {
			File file = new File(uploadPath + sitterphoto.getUuid() + "_" + sitterphoto.getFilename());
			file.delete();
			
			return ResponseEntity.ok().body("{\"message\": \"Image deleted successfully\"}");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Failed to delete image\"}");
	}
}
