package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.JobCertDao;
import kr.ac.kopo.kidscare.model.JobCert;

@Service
public class JobCertServiceImpl implements JobCertService {

	@Autowired
	JobCertDao dao;
	
	@Override
	public List<JobCert> list() {
		
		return dao.list();
	}

	@Override
	public void add(JobCert jobCertInfo) {
		dao.add(jobCertInfo);
	}

	@Override
	public JobCert jobCertInfo(String certName) {
		// TODO Auto-generated method stub
		return dao.jobCertInfo(certName);
	}

	@Override
	public void update(JobCert jobCertInfo) {
		dao.update(jobCertInfo);
	}

	@Override
	public List<JobCert> searchByName(String username) {
		// TODO Auto-generated method stub
		return dao.searchByName(username);
	}

}
