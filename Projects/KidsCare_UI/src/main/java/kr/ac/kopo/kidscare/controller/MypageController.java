package kr.ac.kopo.kidscare.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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
import kr.ac.kopo.kidscare.model.Comment;
import kr.ac.kopo.kidscare.model.KCUser;
import kr.ac.kopo.kidscare.model.KCUserPost;
import kr.ac.kopo.kidscare.model.Reservation;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.model.UserReview;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	private String uploadPath = "d:/upload/";
	@Autowired
	private RestTemplate rest = new RestTemplate();

	@Autowired
	private ObjectMapper om = new ObjectMapper();

	@GetMapping("/parents")
	String parents(Model model) throws JsonMappingException, JsonProcessingException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		// TODO if login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String username = auth.getName();

		KCUser userInfo = rest.getForObject("http://localhost:9090/kcuser/find/" + username, KCUser.class);

		String sitterResp = rest.getForObject("http://localhost:9090/babysitter/list", String.class);
		List<BabySitter> sitterList = om.readValue(sitterResp, new TypeReference<List<BabySitter>>() {
		});

		String postResp = rest.getForObject("http://localhost:9090/kcuserpost/mypost/" + username, String.class);
		List<KCUserPost> postList = om.readValue(postResp, new TypeReference<List<KCUserPost>>() {
		});

		String rsvResp = rest.getForObject("http://localhost:9090/reservation/parent/" + username, String.class);
		List<Reservation> rsvList = om.readValue(rsvResp, new TypeReference<List<Reservation>>() {
		});

		String rsvPastResp = rest.getForObject("http://localhost:9090/reservation/parent/past/" + username,
				String.class);
		List<Reservation> rsvPastList = om.readValue(rsvPastResp, new TypeReference<List<Reservation>>() {
		});

		String rvwResp = rest.getForObject("http://localhost:9090/userreview/find/" + username, String.class);
		List<UserReview> rvwList = om.readValue(rvwResp, new TypeReference<List<UserReview>>() {
		});

		String comResp = rest.getForObject("http://localhost:9090/comment/user/" + username, String.class);
		List<Comment> comList = om.readValue(comResp, new TypeReference<List<Comment>>() {
		});

		Address addressInfo = rest.getForObject("http://localhost:9090/address/find/" + username, Address.class);

		model.addAttribute("userInfo", userInfo);
		model.addAttribute("sitterList", sitterList);
		model.addAttribute("postList", postList);
		model.addAttribute("rsvList", rsvList);
		model.addAttribute("rsvPastList", rsvPastList);
		model.addAttribute("rvwList", rvwList);
		model.addAttribute("commentList", comList);

		return "mypage/parents";
	}

	@GetMapping("/sitter")
	String sitter(Model model) {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		BabySitter sitterInfo = rest.getForObject("http://localhost:9090/babysitter/find/" + username,
				BabySitter.class);
		model.addAttribute("sitterInfo", sitterInfo);

		return "mypage/sitter";

	}

	@GetMapping("/update/{username}")
	String updateParent(@PathVariable String username, Model model) {
		KCUser userInfo = rest.getForObject("http://localhost:9090/kcuser/find/" + username, KCUser.class);

		model.addAttribute("userInfo", userInfo);

		return "/mypage/update_u";
	}

	@PostMapping("/update/{username}")
	String updateParent(@PathVariable String username, KCUser userInfo, Address addressInfo)
			throws JsonProcessingException {
		userInfo.setUsername(username);

		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");

		String jsonString = om.writeValueAsString(userInfo);

		HttpEntity<String> req = new HttpEntity<String>(jsonString, header);

		ResponseEntity<Integer> resp = rest.exchange("http://localhost:9090/kcuser/update/" + username, HttpMethod.PUT,
				req, Integer.class);

		Integer result = resp.getBody();

		System.out.println(result);

		return "redirect:/mypage/parents";

	}

	@GetMapping("/sitter/update/{username}")
	String updateSitter(@PathVariable String username, Model model) {

		BabySitter sitterInfo = rest.getForObject("http://localhost:9090/babysitter/find/" + username,
				BabySitter.class);

		model.addAttribute("sitterInfo", sitterInfo);

		return "mypage/update_s";
	}

	@PostMapping("/sitter/update/{username}")
	String updateSitter(@PathVariable String username, BabySitter sitterInfo, MultipartFile uploadFile) throws JsonProcessingException {
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

		ResponseEntity<Integer> resp = rest.exchange("http://localhost:9090/babysitter/find/" + username,
				HttpMethod.PUT, req, Integer.class);

		Integer result = resp.getBody();

		System.out.println(result);

		return "redirect:/mypage/sitter";
	}
	
	@GetMapping("/delete_image/{code}")
	ResponseEntity<String> deleteImage(@PathVariable Long code){
		RequestEntity<Void> req = RequestEntity.delete("http://localhost:9090/babysitter/delete_image/" + code).build();
		
		ResponseEntity<String> result = rest.exchange(req, String.class);
		
		return result;
	}
}
