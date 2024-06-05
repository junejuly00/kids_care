package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.KCUserDao;
import kr.ac.kopo.kidscare.model.Address;
import kr.ac.kopo.kidscare.model.KCUser;

@Service
public class KCUserServiceImpl implements KCUserService {

	@Autowired
	KCUserDao dao;
	
	@Override
	public List<KCUser> list() {
		return dao.list();
	}

	@Override
	public void add(KCUser userInfo) {
		dao.add(userInfo);
	}

	@Override
	public KCUser getUserInfo(String username) {
		return dao.getUserInfo(username);
	}

	@Override
	public void update(KCUser userInfo) {
		dao.update(userInfo);
		dao.address(userInfo);
	}
	
	@Override
	public void updateAddress(Address addressInfo) {
		dao.updateAddress(addressInfo);
	}

	@Override
	public void updateAddress(Address addressInfo) {
		
	}
	


}
