package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.Notice;

public interface NoticeDao {

	List<Notice> list();

	void add(Notice item);

	Notice item(Integer code);

	void update(Notice item);

}
