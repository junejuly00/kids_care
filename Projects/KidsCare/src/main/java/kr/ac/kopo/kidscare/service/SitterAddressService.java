package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.SitterAddress;

public interface SitterAddressService {

	List<SitterAddress> list();

	void add(SitterAddress sitterAddressInfo);

	SitterAddress sitterAddressInfo(String username);

	void update(SitterAddress sitterAddressInfo);

}
