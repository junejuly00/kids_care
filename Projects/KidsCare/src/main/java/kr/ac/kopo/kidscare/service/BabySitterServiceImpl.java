package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.BabySitterDao;
import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.SitterAddress;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.pager.Pager;

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
		dao.newAddr(sitterInfo);
	}

	@Override
	public BabySitter sitterInfo(String username) {
		return dao.sitterInfo(username);
	}

	@Override
	public void update(BabySitter sitterInfo) {
		dao.update(sitterInfo);
		dao.address(sitterInfo);
		
		
		SitterPhoto sitterphoto = sitterInfo.getPhotos();
		if(sitterphoto != null) {
			sitterphoto.setUsername(sitterInfo.getUsername());
		}
        dao.add(sitterphoto);
	}

	@Override
	public List<BabySitter> detail(String username) {

		return dao.detail(username);
	}

	@Override
	public List<BabySitter> list(Pager pager) {
		return dao.list(pager);
	}

	@Override
	public SitterPhoto itemImage(Long code) {
		return dao.itemImage(code);
	}

	@Override
	public boolean deleteImage(Long code) {
		if(dao.deleteImage(code) > 0)
			return true;
		
		return false;
	}
}


