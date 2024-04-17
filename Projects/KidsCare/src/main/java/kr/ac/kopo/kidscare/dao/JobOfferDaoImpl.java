package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.JobOffer;

@Repository
public class JobOfferDaoImpl implements JobOfferDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<JobOffer> list() {
		return sql.selectList("mapper.joboffer.list");
	}

	@Override


	public void add(JobOffer offerInfo) {
		sql.insert("joboffer.add",offerInfo);
	}

	@Override
	public JobOffer getOfferInfo(String offerId) {
		return sql.selectOne("joboffer.offerId",offerId);
	}

	@Override
	public void update(JobOffer offerInfo) {
		sql.update("joboffer.update",offerInfo);
	}

}
