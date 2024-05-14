package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.NoticeDao;
import kr.ac.kopo.kidscare.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao dao;

	@Override
	public List<Notice> list() {
		return dao.list();
	}

	@Override
	public void add(Notice item) {
		dao.add(item);

	}

	@Override
	public Notice item(Integer code) {
		return dao.item(code);
	}

	@Override
	public void update(Notice item) {
		dao.update(item);

	}

}
