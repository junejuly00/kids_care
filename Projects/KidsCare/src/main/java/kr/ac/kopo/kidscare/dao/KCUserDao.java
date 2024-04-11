package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.KCUser;

public interface KCUserDao {

	List<KCUser> list();

	void add(KCUser item);

	KCUser item(String userId);

	void update(KCUser item);

}
