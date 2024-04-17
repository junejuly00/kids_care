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
		return sql.selectList("mapper.kcuser.list");
	}

	@Override

	public void add(KCUser userInfo) {
		sql.insert("mapper.kcuser.add",userInfo);
	}

	@Override
	public KCUser getUserInfo(String username) {
		return sql.selectOne("mapper.kcuser.username",username);

	}


	@Override
	public void update(KCUser userInfo) {
		sql.update("mapper.kcuser.update",userInfo);

	}

}
