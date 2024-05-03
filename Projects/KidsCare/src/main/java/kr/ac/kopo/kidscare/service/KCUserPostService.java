package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.KcUserPost;

public interface KCUserPostService {

	List<KcUserPost> list();

	KcUserPost item(Integer userPostId);

	void add(kr.ac.kopo.kidscare.model.KcUserPost item);

	void update(KcUserPost item);

}
