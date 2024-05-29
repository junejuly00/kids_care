package kr.ac.kopo.kidscare.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;
import kr.ac.kopo.kidscare.service.KCUserPostService;

@RestController
@RequestMapping("/kcuserpost")
public class KcUserPostController {
	private String uploadPath = "d:/upload/";
	
	@Autowired
	KCUserPostService service;
	
	@PostMapping("/list")
	PagerMap<KcUserPost> list(@RequestBody Pager pager){
		PagerMap<KcUserPost> map = new PagerMap<KcUserPost>();			
		
		List<KcUserPost> list = service.list(pager);
		
		map.setList(list);
		map.setPager(pager);
		
		return map;
	}
	
	@PostMapping("/{userPostId}")
	void add(@RequestBody KcUserPost item) {
		
		
		service.add(item);
	}
	
	@GetMapping("/{userPostId}")
	KcUserPost item(@PathVariable Integer userPostId) {
		return service.item(userPostId);
	}
	
	@PutMapping("/{userPostId}")
	void update(@PathVariable Integer userPostId, @RequestBody KcUserPost item) {
		item.setUserPostId(userPostId);
		
		service.update(item);
	}
	
	@GetMapping("/mypost/{username}")
	List<KcUserPost> mypost(@PathVariable String username) {
		List<KcUserPost> myPostList = service.mypost(username);
		return myPostList;
	}
	
	@GetMapping("/hide/{userPostId}")
	void hide(@PathVariable Integer userPostId) {
		
		service.hide(userPostId);
	}
	
	@ResponseBody
	@DeleteMapping("/{code}")
	String deleteImage(@PathVariable Integer code) {
		UserFile userFile = service.itemImage(code);
		
		if(service.deleteImage(code)) {
			File file = new File(uploadPath + userFile.getUuid() + "_" + userFile.getFilename());
			file.delete();
			return "OK";
		}
		return "FAIL";
	}
	
}
