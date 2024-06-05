package kr.ac.kopo.kidscare.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class RootController {

	
	@GetMapping("/")
	public String main(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUsername = auth.getName();
		session.setAttribute("currName", currentUsername);
		
		var role = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		var roleArray = role.toArray();
		
		
		if (roleArray[0].equals("ROLE_USER")) {
			session.setAttribute("curRole", "USER");
		} else if (roleArray[0].equals("ROLE_SITTER")) {
			session.setAttribute("curRole", "SITTER");
		}
			
		
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
