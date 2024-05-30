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
		return sql.selectList("mapper.address.list");
	}

	@Override
	public void add(Address addressInfo) {
		sql.insert("mapper.address.add",addressInfo);
	}

	@Override
	public Address addressInfo(String username) {
		return sql.selectOne("address.getinfo",username);
	}

	@Override
	public void update(Address addressInfo) {
		sql.update("mapper.address.update",addressInfo);
	}

}
