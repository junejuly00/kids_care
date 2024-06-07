package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.pager.Pager;

public interface BabySitterService {

	List<BabySitter> list();

	void add(BabySitter sitterInfo);

	BabySitter sitterInfo(String username);

	void update(BabySitter sitterInfo);

	List<BabySitter> detail(String username);

	List<BabySitter> list(Pager pager);

	SitterPhoto itemImage(Long code);

	boolean deleteImage(Long code);

}
