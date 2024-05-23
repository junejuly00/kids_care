package kr.ac.kopo.kidscare.dao;


import kr.ac.kopo.kidscare.model.KCUser;


public interface KCUserDao {

	KCUser searchById(String username);

}
