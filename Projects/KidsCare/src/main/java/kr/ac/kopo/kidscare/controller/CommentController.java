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

import kr.ac.kopo.kidscare.model.Comment;
import kr.ac.kopo.kidscare.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@GetMapping("/list")
	List<Comment> list(){
		List<Comment> list = service.list();
		
		return list;
	}
	
	@GetMapping("/filter/{userPostId}")
	List<Comment> filter(@PathVariable Integer userPostId){
		List<Comment> list = service.filter(userPostId);
		
		return list;
	}
	
	@PostMapping("/add")
	void add(@RequestBody Comment commentInfo) {
		service.add(commentInfo);
	}
	
	@GetMapping("/{commentId}")
	Comment commentInfo(@PathVariable Integer commentId) {
		return service.CommentInfo(commentId);
	}
	
	@PutMapping("/commentId")
	void update(@PathVariable Integer commentId, @RequestBody Comment commentInfo) {
		commentInfo.setCommentId(commentId);
		
		service.update(commentInfo);
	}
	
}
