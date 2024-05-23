package kr.ac.kopo.kidscare.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.kidscare.model.KCUserPost;
import kr.ac.kopo.kidscare.model.UserFile;
import kr.ac.kopo.kidscare.pager.Pager;
import kr.ac.kopo.kidscare.pager.PagerMap;

@Controller
@RequestMapping("/kcuserpost")
public class KCUserPostController {
	final String url = "http://localhost:9090/kcuserpost/";
	private String uploadPath = "d:/upload/";
	
	@Autowired
	private RestTemplate rest = new RestTemplate();
	
	@Autowired
	private ObjectMapper om = new ObjectMapper();
	
	
	
	@GetMapping("/list")
	String list(Model model, Pager pager, @RequestParam Integer search, @RequestParam String keyword) throws JsonMappingException, JsonProcessingException {
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);	
		
		pager.setSearch(search);
		pager.setKeyword(keyword);
		//System.out.println(search + "," + keyword);  //여기까지 들어감
		String jsonString = om.writeValueAsString(pager);
		
				HttpEntity<String> req = new HttpEntity<String>(jsonString, header);

				ResponseEntity<String> resp = rest.postForEntity(url + "list", req, String.class);
			
				String body = resp.getBody();
		
				PagerMap<KCUserPost> map = om.readValue(body, new TypeReference<PagerMap<KCUserPost>>() { });
		
		model.addAttribute("list", map.getList());
		model.addAttribute("pager", map.getPager());
		
		return "kcuserpost/list";
	}
	
	@GetMapping("/add")
	String add() {
		return "kcuserpost/add";
	}
	
	@PostMapping("/add")
	String add(KCUserPost item, List<MultipartFile> uploadFile) throws JsonProcessingException {
		
		List<UserFile> userFiles = new ArrayList<UserFile>();
		
		if(uploadFile != null) {
			for(MultipartFile file : uploadFile) {
				if(file.isEmpty())
					continue;
				
				String filename = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				
				try {
					file.transferTo(new File(uploadPath + uuid + "_" + filename));
					
					UserFile img = new UserFile();
					img.setFilename(filename);
					img.setUuid(uuid);
					
					userFiles.add(img);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		item.setUserFiles(userFiles);
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonString = om.writeValueAsString(item);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.postForEntity(url + item.getUserPostId().toString(), req, Integer.class);
		
		Integer body = resp.getBody();
		
		System.out.println(body);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{userPostId}")
	String update(@PathVariable Long userPostId, Model model) {
		KCUserPost item = rest.getForObject(url + userPostId, KCUserPost.class);
		
		model.addAttribute("item", item);
		
		return "kcuserpost/update";
	}
	
	@PostMapping("/update/{userPostId}")
	String update(@PathVariable Integer userPostId, KCUserPost item) throws JsonProcessingException {
		item.setUserPostId(userPostId);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		
		String jsonString = om.writeValueAsString(item);
		
		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);
		
		ResponseEntity<Integer> resp = rest.exchange(url + userPostId, HttpMethod.PUT, req, Integer.class);
		
		Integer result = resp.getBody();
		
		System.out.println(result);
		
		return "redirect:../list";
	}
	
	@GetMapping("/post/{userPostId}")
	String post(@PathVariable Long userPostId, Model model) throws JsonProcessingException {
		
		KCUserPost postInfo = rest.getForObject(url + userPostId, KCUserPost.class);	
		
		model.addAttribute("postInfo", postInfo);
		
		return "kcuserpost/post";
	}
	
	@GetMapping("/hide/{userPostId}")
	String hide(@PathVariable Long userPostId) {
		KCUserPost item = rest.getForObject(url + "hide/" + userPostId.toString() , KCUserPost.class);				
		return "redirect:../list";
	
}
}
