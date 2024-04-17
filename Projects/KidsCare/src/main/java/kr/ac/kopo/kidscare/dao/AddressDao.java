package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.Address;

public interface AddressDao {

	List<Address> list();

	void add(Address addressInfo);

	Address addressInfo(String username);

	void update(Address addressInfo);

}
