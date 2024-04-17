package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.UserReview;

@Repository
public class UserReviceDaoImpl implements UserReviceDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<UserReview> list() {
		return sql.selectList("mapper.userreview.list");
	}

	@Override
	public void add(UserReview userreviewInfo) {
		sql.insert("mapper.userreview.add",userreviewInfo);
	}

	@Override
	public UserReview userreviewInfo(String reviewId) {
		return sql.selectOne("mapper.UserReview.reviewId",reviewId);
	}

	@Override
	public void update(UserReview userreviewInfo) {
		sql.update("mapper.UserReview.update",userreviewInfo);
	}

}
