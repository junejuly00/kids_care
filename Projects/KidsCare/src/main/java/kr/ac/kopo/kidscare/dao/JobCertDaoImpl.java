package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.JobCert;

@Repository
public class JobCertDaoImpl implements JobCertDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<JobCert> list() {
		return sql.selectList("jobcert.list");
	}

	@Override
	public void add(JobCert jobCertInfo) {
		sql.insert("jobcert.add", jobCertInfo);
	}

	@Override
	public JobCert jobCertInfo(String certName) {
		return sql.selectOne("jobcert.select", certName);
	}

	@Override
	public void update(JobCert jobCertInfo) {
		sql.update("jobcert.update", jobCertInfo);

	}

	@Override
	public List<JobCert> searchByName(String username) {
		// TODO Auto-generated method stub
		return sql.selectList("jobcert.searchName", username);
	}

}
