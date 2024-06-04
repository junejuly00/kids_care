package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.pager.Pager;

public interface BabySitterDao {

	List<BabySitter> list();

	void add(BabySitter sitterInfo);

	BabySitter sitterInfo(String username);

	void update(BabySitter sitterInfo);

	List<BabySitter> detail(String username);

	List<BabySitter> list(Pager pager);

	void add(SitterPhoto sitterphoto);

}
