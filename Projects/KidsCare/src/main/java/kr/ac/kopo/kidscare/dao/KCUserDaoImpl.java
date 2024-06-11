package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.Address;
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

	public void add(KCUser userInfo) {
		sql.insert("kcuser.add",userInfo);
	}

	@Override
	public KCUser getUserInfo(String username) {
		return sql.selectOne("kcuser.search",username);

	}


	@Override
	public void update(KCUser userInfo) {
		sql.update("kcuser.update",userInfo);

	}

	@Override
	public void updateAddress(Address addressInfo) {
		sql.update("kcuser.update", addressInfo);
	}

	@Override
	public void address(KCUser userInfo) {
		sql.insert("kcuser.address",userInfo);
	}

	@Override
	public void newAddr(KCUser userInfo) {
		sql.insert("kcuser.newAddr", userInfo);
	}

}
