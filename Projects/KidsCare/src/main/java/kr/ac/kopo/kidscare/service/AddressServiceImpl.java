package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.AddressDao;
import kr.ac.kopo.kidscare.model.Address;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressDao dao;

	@Override
	public List<Address> list() {
		return dao.list();
	}

	@Override
	public void add(Address addressInfo) {
		dao.add(addressInfo);
	}

	@Override
	public Address addressInfo(String userId) {
		return dao.addressInfo(userId);
	}

	@Override
	public void update(Address addressInfo) {
		dao.update(addressInfo);
	}

}
