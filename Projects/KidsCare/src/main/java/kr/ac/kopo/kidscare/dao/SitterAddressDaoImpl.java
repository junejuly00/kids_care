package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.SitterAddress;

@Repository
public class SitterAddressDaoImpl implements SitterAddressDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<SitterAddress> list() {
		return sql.selectList("sitterAddress.list");
	}

	@Override
	public void add(SitterAddress sitterAddressInfo) {
		sql.insert("sitterAddress.add",sitterAddressInfo);
	}

	@Override
	public SitterAddress sitterAddressInfo(String username) {
		return sql.selectOne("sitterAddress.search",username);
	}

	@Override
	public void update(SitterAddress sitterAddressInfo) {
		sql.update("sitterAddress.update",sitterAddressInfo);
	}

}
