package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.kidscare.dao.KCUserPostDao;
import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;
import kr.ac.kopo.kidscare.pager.Pager;

@Service
public class KcUserPostServiceImpl implements KCUserPostService {
	
	@Autowired
	KCUserPostDao dao;


	@Override
	public List<KcUserPost> list(Pager pager) {
		
		int total = dao.total(pager);
		pager.setTotal(total);
		return dao.list(pager);
	}
	



	@Override
	public KcUserPost item(Integer userPostId) {
		return dao.item(userPostId);
	}
	
	@Transactional
	@Override
	public void add(KcUserPost item) {
		dao.add(item);
		
		for(UserFile userfile : item.getUserFiles()) {
			userfile.setUserPostId(item.getUserPostId());
			
			dao.add(userfile);
		}
		
	}
		
	
	@Transactional
	@Override
	public void update(KcUserPost item) {
		dao.update(item);
		
		for(UserFile userfile : item.getUserFiles()) {
			userfile.setUserPostId(item.getUserPostId());
			dao.add(userfile);
		}
	}

	@Override
	public List<KcUserPost> mypost(String username) {
		
		return dao.mypost(username);
	}

	@Override
	public void hide(Integer userPostId) {
		dao.hide(userPostId);
	}




	@Override
	public boolean deleteImage(Integer code) {
		if(dao.deleteImage(code) > 0)
			return true;
		
		return false;
	}




	@Override
	public UserFile itemImage(Integer code) {
		return dao.itemImage(code);
	}





	
	

}
