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
		return sql.selectList("mapper.jobcert.list");
	}

	@Override
	public void add(JobCert jobCertInfo) {
		sql.insert("mapper.jobcert.add", jobCertInfo);
	}

	@Override
	public JobCert jobCertInfo(String certName) {
		return sql.selectOne("mapper.jobcert.select", certName);
	}

	@Override
	public void update(JobCert jobCertInfo) {
		sql.update("mapper.jobcert.update", jobCertInfo);

	}

}
