package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.NoticeDao;
import kr.ac.kopo.kidscare.model.Notice;
import kr.ac.kopo.kidscare.model.NoticeFile;
import kr.ac.kopo.kidscare.pager.Pager;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao dao;

	@Override
	public List<Notice> list(Pager pager) {
		
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}

	@Override
	public void add(Notice item) {
		dao.add(item);
		
		for(NoticeFile noticefile : item.getNoticeFiles()) {
			noticefile.setCode(item.getCode());
			
			dao.add(noticefile);
		}

	}

	@Override
	public Notice item(Integer code) {
		return dao.item(code);
	}

	@Override
	public void update(Notice item) {
		dao.update(item);

	}

	@Override
	public void hide(Integer code) {
		dao.hide(code);
	}

	@Override
	public List<Notice> mypost(String username) {
		return dao.mypost(username);
	}

	

}
