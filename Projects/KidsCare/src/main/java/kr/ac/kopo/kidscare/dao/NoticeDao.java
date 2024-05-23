package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.Notice;
import kr.ac.kopo.kidscare.pager.Pager;

public interface NoticeDao {

	List<Notice> list(Pager pager);

	void add(Notice item);

	Notice item(Integer code);

	void update(Notice item);

	void hide(Integer code);

	List<Notice> mypost(String username);

	int total(Pager pager);

	List<Notice> list();

}
