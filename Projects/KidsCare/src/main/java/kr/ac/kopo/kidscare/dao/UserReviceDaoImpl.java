package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.UserReview;
import kr.ac.kopo.kidscare.pager.Pager;

@Repository
public class UserReviceDaoImpl implements UserReviceDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<UserReview> list(Pager pager) {
		return sql.selectList("userreview.list", pager);
	}

	@Override
	public void add(UserReview userreviewInfo) {
		sql.insert("userreview.add",userreviewInfo);
	}

	@Override
	public UserReview userreviewInfo(String reviewId) {
		return sql.selectOne("userreview.reviewId",reviewId);
	}

	@Override
	public void update(UserReview userreviewInfo) {
		sql.update("UserReview.update",userreviewInfo);
	}

	@Override
	public List<UserReview> findByParent(String username, Pager pager) {
		pager.setKeyword(username);
		return sql.selectList("userreview.findparent", pager);
	}

	@Override
	public List<UserReview> findBySitter(Pager pager) {
		return sql.selectList("userreview.findsitter", pager);
	}

}
