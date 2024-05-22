package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.Notice;
import kr.ac.kopo.kidscare.pager.Pager;

public interface NoticeService {

	List<Notice> list(Pager pager);

	void add(Notice item);

	Notice item(Integer code);

	void update(Notice item);

	void hide(Integer code);

	List<Notice> mypost(String username);

}
