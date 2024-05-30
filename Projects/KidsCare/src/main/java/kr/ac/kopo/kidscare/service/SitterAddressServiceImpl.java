package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.SitterAddressDao;
import kr.ac.kopo.kidscare.model.SitterAddress;

@Service
public class SitterAddressServiceImpl implements SitterAddressService {
	
	@Autowired
	SitterAddressDao dao;

	@Override
	public List<SitterAddress> list() {
		return dao.list();
	}

	@Override
	public void add(SitterAddress sitterAddressInfo) {
		dao.add(sitterAddressInfo);
	}

	@Override
	public SitterAddress sitterAddressInfo(String username) {
		return dao.sitterAddressInfo(username);
	}

	@Override
	public void update(SitterAddress sitterAddressInfo) {
		dao.update(sitterAddressInfo);
	}

}
