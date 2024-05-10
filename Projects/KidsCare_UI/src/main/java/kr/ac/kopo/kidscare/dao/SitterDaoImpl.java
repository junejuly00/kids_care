package kr.ac.kopo.kidscare.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.BabySitter;

@Repository
public class SitterDaoImpl implements SitterDao {

	@Autowired
	SqlSession sql;
	@Override
	public BabySitter searchSitterById(String username) {
		
		return sql.selectOne("babysitter.searchById", username);
	}

}
