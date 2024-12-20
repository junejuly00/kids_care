package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.JobCert;

public interface JobCertDao {

	List<JobCert> list();

	void add(JobCert jobCertInfo);

	JobCert jobCertInfo(String certName);

	void update(JobCert jobCertInfo);

	List<JobCert> searchByName(String username);

}
