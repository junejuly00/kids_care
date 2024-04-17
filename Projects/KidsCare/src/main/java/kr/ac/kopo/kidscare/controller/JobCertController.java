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

import kr.ac.kopo.kidscare.model.JobCert;
import kr.ac.kopo.kidscare.service.JobCertService;

@RestController
@RequestMapping("/address")
public class JobCertController {
	
	@Autowired
	JobCertService service;
	
	@GetMapping("/list")
	List<JobCert> list() {
		List<JobCert> list = service.list();
		
		return list;
	}
	
	@PostMapping
	void add(@RequestBody JobCert jobCertInfo) {
		service.add(jobCertInfo);
	}
	
	@GetMapping("/{username}")
	JobCert jobCertInfo(@PathVariable String certName) {
		return service.jobCertInfo(certName);
	}
	
	@PutMapping("/{username}")	
	void update(@PathVariable String username, @RequestBody JobCert jobCertInfo) {
		jobCertInfo.setSitterId(username);
		
		service.update(jobCertInfo);
		
	}
}
