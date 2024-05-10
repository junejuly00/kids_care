package kr.ac.kopo.kidscare.dao;

import kr.ac.kopo.kidscare.model.BabySitter;

public interface SitterDao {
	BabySitter searchSitterById(String username);
}
