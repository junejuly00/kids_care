package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.Address;

public interface AddressService {

	List<Address> list();

	void add(Address addressInfo);

	Address addressInfo(String userId);

	void update(Address addressInfo);

}
