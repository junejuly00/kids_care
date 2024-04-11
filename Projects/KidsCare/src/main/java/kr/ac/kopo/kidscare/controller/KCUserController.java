package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
