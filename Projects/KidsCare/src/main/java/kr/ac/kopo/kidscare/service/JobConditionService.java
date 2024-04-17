package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.JobCondition;

public interface JobConditionService {

	List<JobConditionService> list();

	void add(JobCondition jobconditionInfo);

	JobCondition jobconditionInfo(String ofCertId);

	void update(JobCondition jobconditionInfo);

}
