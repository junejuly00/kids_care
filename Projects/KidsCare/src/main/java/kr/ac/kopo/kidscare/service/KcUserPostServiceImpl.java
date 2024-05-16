package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.KCUserPostDao;
import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;

@Service
public class KcUserPostServiceImpl implements KCUserPostService {
	
	@Autowired
	KCUserPostDao dao;

	@Override
	public List<KcUserPost> list() {
		return dao.list();
	}

	@Override
	public KcUserPost item(Integer userPostId) {
		return dao.item(userPostId);
	}

	@Override
	public void add(KcUserPost item) {
		dao.add(item);
		
		for(UserFile userFile : item.getUserFiles()) {
			userFile.setUserPostId(item.getUserPostId());
			
			dao.add(userFile);
		}
	}

	@Override
	public void update(KcUserPost item) {
		dao.update(item);
	}

	@Override
	public List<KcUserPost> mypost(String username) {
		
		return dao.mypost(username);
	}
	
	

}
