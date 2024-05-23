package kr.ac.kopo.kidscare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class RootController {

	
	
	@GetMapping("/")
	public String main(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUsername = auth.getName();
		model.addAttribute("currName", currentUsername);
		
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
