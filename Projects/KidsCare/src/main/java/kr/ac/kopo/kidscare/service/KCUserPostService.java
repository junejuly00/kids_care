package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;
import kr.ac.kopo.kidscare.pager.Pager;

public interface KCUserPostService {

	List<KcUserPost> list(Pager pager);

	KcUserPost item(Integer userPostId);

	void add(kr.ac.kopo.kidscare.model.KcUserPost item);

	void update(KcUserPost item);

	List<KcUserPost> mypost(String username);

	void hide(Integer userPostId);

	UserFile itemImage(Integer code);

	boolean deleteImage(Integer code);



}
