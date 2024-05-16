package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.SitterPost;

public interface SitterPostService {

	List<SitterPost> list();

	void add(SitterPost item);

	SitterPost item(Integer sitterpostid);

	void update(SitterPost item);

}
