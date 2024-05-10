package kr.ac.kopo.kidscare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	final String path = "login/";
	
	@GetMapping("/user")
	String userLogin() {
		return path + "user";
	}
	
	@GetMapping("/sitter")
	String sitterLogin() {
		return path + "sitter";
	}
	
}
	
