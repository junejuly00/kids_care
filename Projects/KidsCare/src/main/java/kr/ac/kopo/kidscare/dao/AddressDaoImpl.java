package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Address> list() {
		return sql.selectList("address.list");
	}

	@Override
	public void add(Address addressInfo) {
		sql.insert("address.add",addressInfo);
	}

	@Override
	public Address addressInfo(String username) {
		return sql.selectOne("address.getinfo",username);
	}

	@Override
	public void update(Address addressInfo) {
		sql.update("address.update",addressInfo);
	}

}
