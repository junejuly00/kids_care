package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.BabySitter;

public interface BabySitterDao {

	List<BabySitter> list();

	void add(BabySitter sitterInfo);

	BabySitter sitterInfo(String username);

	void update(BabySitter sitterInfo);

}
