package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.BabySitter;

public interface BabySitterService {

	List<BabySitter> list();

	void add(BabySitter sitterInfo);

	BabySitter sitterInfo(String username);

	void update(BabySitter sitterInfo);

}
