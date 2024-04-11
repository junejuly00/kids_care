package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.KCUser;

public interface KCUserService {

	List<KCUser> list();

	void add(KCUser item);

	KCUser item(String userid);

	void update(KCUser item);

}
