package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.SitterPostDao;
import kr.ac.kopo.kidscare.model.SitterPost;

@Service
public class SitterPostServiceImpl implements SitterPostService {
	
	@Autowired
	SitterPostDao dao;

	@Override
	public List<SitterPost> list() {
		return dao.list();
	}

	@Override
	public void add(SitterPost item) {
		dao.add(item);
	}

	@Override
	public SitterPost item(Integer sitterpostid) {
		return dao.item(sitterpostid);
	}

	@Override
	public void update(SitterPost item) {
		dao.update(item);
	}

}
