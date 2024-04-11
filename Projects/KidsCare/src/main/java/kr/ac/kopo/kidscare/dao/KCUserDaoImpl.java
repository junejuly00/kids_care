package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.KCUser;

@Repository
public class KCUserDaoImpl implements KCUserDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<KCUser> list() {
		return sql.selectList("kcuser.list");
	}

	@Override
	public void add(KCUser item) {
		sql.insert("KCUser.add",item);
	}

	@Override
	public KCUser item(String userId) {
		return sql.selectOne("KCUser.userId",userId);
	}


	@Override
	public void update(KCUser item) {
		sql.update("KCUser.update",item);
	}

}
