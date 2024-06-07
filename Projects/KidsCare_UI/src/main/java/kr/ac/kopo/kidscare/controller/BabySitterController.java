package kr.ac.kopo.kidscare.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.Address;
import kr.ac.kopo.kidscare.model.BabySitter;

import kr.ac.kopo.kidscare.model.JobCert;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.model.UserReview;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;


@Controller
@RequestMapping("/babysitter")
public class BabySitterController {
	private String uploadPath = "d:/upload/";
	final String url = "http://localhost:9090/babysitter/";
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	@GetMapping("/list")
	String list(Model model, Pager pager) throws JsonMappingException, JsonProcessingException {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();

		String parentName=auth.getName();
		
		Address parentAddress = rest.getForObject("http://localhost:9090/address/find/"+parentName,Address.class);
		String[] parentCity = new String[5];
		String city = String.valueOf(parentAddress.getCity());
		parentCity[0] = city;
		pager.setMisc(parentCity);

		
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(pager);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		ResponseEntity<String> resp = rest.postForEntity(url + "list", req, String.class);
		String body = resp.getBody();
		
		
		
		PagerMap<BabySitter> map = om.readValue(body, new TypeReference<PagerMap<BabySitter>>() {});

		model.addAttribute("list", map.getList());
		model.addAttribute("pager", map.getPager());
				
		
		return "babysitter/list";
	}
	
	@GetMapping("/add")
	String add() {
		return "babysitter/add";
	}
	
	@PostMapping("/add")
	String add(BabySitter sitterInfo) throws JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(sitterInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + "add", req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{username}")
	String update(@PathVariable String username, Model model) {
		BabySitter sitterInfo = rest.getForObject(url + username, BabySitter.class);
		
		model.addAttribute("sitterInfo", sitterInfo);
		
		return "babysitter/update";
	}
	
	@PostMapping("/update/{username}")
	String update(@PathVariable String username, BabySitter sitterInfo, MultipartFile uploadFile) throws JsonProcessingException {
		sitterInfo.setUsername(username);
		
		if(uploadFile != null && !uploadFile.isEmpty()) {
			String filename = uploadFile.getOriginalFilename();
			String uuid = UUID.randomUUID().toString();
			
			try {
				uploadFile.transferTo(new File(uploadPath + uuid + "_" + filename));
				
				SitterPhoto img = new SitterPhoto();
				img.setFilename(filename);
				img.setUuid(uuid);
				img.setUsername(username);
				
				sitterInfo.setPhotos(img);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(sitterInfo);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + username, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../list";	
	}
	
	@GetMapping("/detail/{username}")
	String post(@PathVariable String username, Model model) throws JsonProcessingException {
		
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String resp = rest.getForObject("http://localhost:9090/jobcert/search/" + username, String.class);
		List<JobCert> certList = om.readValue(resp, new TypeReference<List<JobCert>>() {});
		
		BabySitter sitterInfo = rest.getForObject(url + "find/" + username, BabySitter.class);	

		String reviewResp = rest.getForObject("http://localhost:9090/userreview/find/sitter/"+ username , String.class);
		List<UserReview> revList = om.readValue(reviewResp, new TypeReference<List<UserReview>>() {});
		
		for (UserReview userReview : revList) {
			System.out.println(userReview.getReviewInfo());
		}
		model.addAttribute("revList", revList);
		model.addAttribute("sitterInfo", sitterInfo);
		model.addAttribute("jobcert", certList);
		
		return "babysitter/detail";
	}
}
