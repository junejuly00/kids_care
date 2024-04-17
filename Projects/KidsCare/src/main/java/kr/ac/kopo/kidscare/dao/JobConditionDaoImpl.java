package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.JobCondition;
import kr.ac.kopo.kidscare.service.JobConditionService;

@Repository
public class JobConditionDaoImpl implements JobConditionDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<JobConditionService> list() {
		return sql.selectList("mapper.jobcondition.list");
	}

	@Override
	public void add(JobCondition jobconditionInfo) {
		sql.insert("mapper.jobcondition.add",jobconditionInfo);
	}

	@Override
	public JobCondition jobconditionInfo(String ofCertId) {
		return sql.selectOne("mapper.JobCondition.ofCertId",ofCertId);
	}

	@Override
	public void update(JobCondition jobconditionInfo) {
		sql.update("mapper.JobCondition.update",jobconditionInfo);
	}

}
