package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.BabySitter;

@Repository
public class BabySitterDaoImpl implements BabySitterDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<BabySitter> list() {
		return sql.selectList("babysitter.list");
	}

	@Override
	public void add(BabySitter sitterInfo) {
		sql.insert("babysitter",sitterInfo);
	}

	@Override
	public BabySitter sitterInfo(String username) {
		return sql.selectOne("babySitter.username",username);
	}

	@Override
	public void update(BabySitter sitterInfo) {
		sql.update("babySitter.update",sitterInfo);
	}

}
