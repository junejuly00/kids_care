package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.JobCondition;
import kr.ac.kopo.kidscare.service.JobConditionService;

public interface JobConditionDao {

	List<JobConditionService> list();

	void add(JobCondition jobconditionInfo);

	JobCondition jobconditionInfo(String ofCertId);

	void update(JobCondition jobconditionInfo);

}
