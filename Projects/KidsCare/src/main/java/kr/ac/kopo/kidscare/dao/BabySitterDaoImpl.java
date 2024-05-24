package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.pager.Pager;

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
		sql.insert("babysitter.add",sitterInfo);
	}

	@Override
	public BabySitter sitterInfo(String username) {
		return sql.selectOne("babysitter.item",username);
	}

	@Override
	public void update(BabySitter sitterInfo) {
		sql.update("babysitter.update",sitterInfo);
	}

	@Override
	public List<BabySitter> detail(String username) {
		return sql.selectList("babysitter.detail", username);
	}

	@Override
	public List<BabySitter> list(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectList("babysitter.list", pager);
	}

}
