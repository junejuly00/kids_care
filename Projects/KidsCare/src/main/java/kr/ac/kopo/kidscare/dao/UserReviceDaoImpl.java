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
		return sql.selectList("userreview.list");
	}

	@Override
	public void add(UserReview reviewInfo) {
		sql.insert("userreview.add",reviewInfo);
	}

}
