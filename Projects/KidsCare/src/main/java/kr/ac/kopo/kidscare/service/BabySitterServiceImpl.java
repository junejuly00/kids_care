package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.BabySitterDao;
import kr.ac.kopo.kidscare.model.BabySitter;

@Service
public class BabySitterServiceImpl implements BabySitterService {
	
	@Autowired
	BabySitterDao dao;
	
	@Override
	public List<BabySitter> list() {
		return dao.list();
	}

	@Override
	public void add(BabySitter sitterInfo) {
		dao.add(sitterInfo);
	}

	@Override
	public BabySitter sitterInfo(String sitterId) {
		return dao.sitterInfo(sitterId);
	}

	@Override
	public void update(BabySitter sitterInfo) {
		dao.update(sitterInfo);
	}

}
