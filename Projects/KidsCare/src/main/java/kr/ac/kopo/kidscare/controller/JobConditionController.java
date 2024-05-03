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

import kr.ac.kopo.kidscare.model.JobCondition;
import kr.ac.kopo.kidscare.service.JobConditionService;

@RestController
@RequestMapping("/jobcondition")
public class JobConditionController {
	
	@Autowired
	JobConditionService service;
	
	@GetMapping("/list")
	List<JobConditionService> list(){
	List<JobConditionService> list = service.list();
	
		return list;
	}
	
	@PostMapping
	void add(@RequestBody JobCondition jobconditionInfo) {
		service.add(jobconditionInfo);
	}
	
	@GetMapping("/{ofcertid}")
	JobCondition jobconditionInfo(@PathVariable String ofCertId) {
		return service.jobconditionInfo(ofCertId);
	}
	
	@PutMapping("/{ofcertid}")
	void update(@PathVariable String ofcertId, @RequestBody JobCondition jobconditionInfo) {
		jobconditionInfo.setOfCertId(ofcertId);
		
		service.update(jobconditionInfo);
	}
}
