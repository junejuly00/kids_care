package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.SitterAddress;

public interface SitterAddressDao {

	List<SitterAddress> list();

	void add(SitterAddress sitterAddressInfo);

	SitterAddress sitterAddressInfo(String username);

	void update(SitterAddress sitterAddressInfo);

}
