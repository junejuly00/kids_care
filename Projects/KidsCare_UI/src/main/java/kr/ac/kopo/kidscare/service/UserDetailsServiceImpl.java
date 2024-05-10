package kr.ac.kopo.kidscare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.SitterDao;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	SitterDao dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(username);
		return dao.searchSitterById(username);
	}

}
