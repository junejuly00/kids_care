package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.JobCert;

public interface JobCertService {

	public List<JobCert> list();

	public void add(JobCert jobCertInfo);

	public JobCert jobCertInfo(String certName);

	public void update(JobCert jobCertInfo);

	List<JobCert> searchByName(String username);

}
