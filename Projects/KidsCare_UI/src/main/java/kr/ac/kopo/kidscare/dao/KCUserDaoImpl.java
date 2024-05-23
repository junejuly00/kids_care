package kr.ac.kopo.kidscare.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.KCUser;

@Repository
public class KCUserDaoImpl implements KCUserDao {

	@Autowired
	SqlSession sql;
	@Override
	public KCUser searchById(String username) {
		
		return sql.selectOne("kcuser.searchById", username);
	}

}
