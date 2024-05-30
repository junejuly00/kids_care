package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.KCUser;
import kr.ac.kopo.kidscare.model.KCUserPost;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	
	@GetMapping("/parents")  
	String parents(Model model) throws JsonMappingException, JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//TODO if login 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		KCUser userInfo = rest.getForObject("http://localhost:9090/kcuser/find/"+ username , KCUser.class);
		
		String sitterResp = rest.getForObject("http://localhost:9090/babysitter/list", String.class);
		List<BabySitter> sitterList = om.readValue(sitterResp, new TypeReference<List<BabySitter>>() {});
		
		String postResp = rest.getForObject("http://localhost:9090/kcuserpost/mypost/"+ username, String.class);
		List<KCUserPost> postList = om.readValue(postResp, new TypeReference<List<KCUserPost>>() {});
		
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("sitterList", sitterList);
		model.addAttribute("postList", postList);
		
		return "mypage/parents";
	}
	
	@GetMapping("/sitter")
	String sitter(Model model) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String username = "sitter";
		
		BabySitter sitterInfo = rest.getForObject("http://localhost:9090/babysitter/find" + username, BabySitter.class);
		model.addAttribute("sitterInfo",sitterInfo);
		
		return "/mypage/sitter";
		
	}
}
