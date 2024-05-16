package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;

public interface KCUserPostDao {

	KcUserPost item(Integer userPostId);

	void add(KcUserPost item);

	void update(KcUserPost item);

	List<KcUserPost> list();

	void add(UserFile userFile);

}
