package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.KcUserPost;

public interface KCUserPostDao {

	KcUserPost item(Integer userPostId);

	void add(KcUserPost item);

	void update(KcUserPost item);

	List<KcUserPost> list();

	List<KcUserPost> mypost(String username);

}
