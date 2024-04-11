package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.KCUserDao;
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
	public void add(KCUser item) {
		dao.add(item);
	}

	@Override
	public KCUser item(String userId) {
		return dao.item(userId);
	}

	@Override
	public void update(KCUser item) {
		dao.update(item);
	}

}