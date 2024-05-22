package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;
import kr.ac.kopo.kidscare.pager.Pager;

public interface KCUserPostDao {

	KcUserPost item(Integer userPostId);

	void add(KcUserPost item);

	void update(KcUserPost item);

	List<KcUserPost> list(Pager pager);

	List<KcUserPost> mypost(String username);

	void add(UserFile userFile);

	void hide(Integer userPostId);

	int total(Pager pager);

	List<KcUserPost> list();

}
