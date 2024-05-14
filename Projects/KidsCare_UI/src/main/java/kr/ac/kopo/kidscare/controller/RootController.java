package kr.ac.kopo.kidscare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
		
	}
	@GetMapping("/secured")
	public String secured() {
		return "secured";
	}
	
}
