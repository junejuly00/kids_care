package kr.ac.kopo.kidscare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpSession;

@Controller
public class RootController {

	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@GetMapping("/")
	public String main(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUsername = auth.getName();
		session.setAttribute("currName", currentUsername);
		
		var role = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		session.setAttribute("curRole", role);
		
		Integer count = rest.getForObject("http://localhost:9090/reservation/count/"+ String.valueOf(currentUsername), Integer.class);
		session.setAttribute("countRes", count);
			
		
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
