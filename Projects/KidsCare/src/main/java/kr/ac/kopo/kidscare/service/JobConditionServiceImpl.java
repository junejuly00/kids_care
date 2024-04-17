package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.JobConditionDao;
import kr.ac.kopo.kidscare.model.JobCondition;

@Service
public class JobConditionServiceImpl implements JobConditionService {
	
	@Autowired
	JobConditionDao dao;

	@Override
	public List<JobConditionService> list() {
		return dao.list();
	}

	@Override
	public void add(JobCondition jobconditionInfo) {
		dao.add(jobconditionInfo);
	}

	@Override
	public JobCondition jobconditionInfo(String ofCertId) {
		return dao.jobconditionInfo(ofCertId);
	}

	@Override
	public void update(JobCondition jobconditionInfo) {
		dao.update(jobconditionInfo);
	}

}
