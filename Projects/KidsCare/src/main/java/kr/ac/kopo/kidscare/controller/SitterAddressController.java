package kr.ac.kopo.kidscare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.kidscare.model.SitterAddress;
import kr.ac.kopo.kidscare.service.SitterAddressService;

@RestController
@RequestMapping("/sitteraddress")
public class SitterAddressController {
	
	@Autowired
	SitterAddressService service;
	
	@GetMapping("/list")
	List<SitterAddress> list(){
		List<SitterAddress> list = service.list();
		
		return list;
	}
	
	@PostMapping
	void add(@RequestBody SitterAddress sitterAddressInfo) {
		service.add(sitterAddressInfo);
	}
	
	@GetMapping("/{username}")
	SitterAddress sitterAddressInfo(@PathVariable String username,@RequestBody SitterAddress sitterAddressInfo) {
	return service.sitterAddressInfo(username);
	}

	@PutMapping("/{username}")
	void update(@PathVariable String username, @RequestBody SitterAddress sitterAddressInfo) {
		sitterAddressInfo.setUsername(username);
		
		service.update(sitterAddressInfo);
		
	}
	}
	
