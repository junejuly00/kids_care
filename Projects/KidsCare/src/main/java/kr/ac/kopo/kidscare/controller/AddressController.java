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

import kr.ac.kopo.kidscare.model.Address;
import kr.ac.kopo.kidscare.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	AddressService service;
	
	@GetMapping("/list")
	List<Address> list() {
		List<Address> list = service.list();
		
		return list;
	}
	
	@PostMapping
	void add(@RequestBody Address addressInfo) {
		service.add(addressInfo);
	}
	
	@GetMapping("/{username}")
	Address addressInfo(@PathVariable String username) {
		return service.addressInfo(username);
	}
	
	@PutMapping("/{username}")	
	void update(@PathVariable String username, @RequestBody Address addressInfo) {
		addressInfo.setUsername(username);
		
		service.update(addressInfo);
		
	}
}
