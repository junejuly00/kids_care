package kr.ac.kopo.kidscare.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.ac.kopo.kidscare.model.KCUser;


@Mapper
public interface KCUserDao {

	KCUser searchById(String username);

}
