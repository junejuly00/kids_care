package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.KCUser;

public interface KCUserDao {

	List<KCUser> list();

	void add(KCUser userInfo);

	KCUser getUserInfo(String username);

	void update(KCUser userInfo);

}
