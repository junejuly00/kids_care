package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.UserReviceDao;
import kr.ac.kopo.kidscare.model.UserReview;
import kr.ac.kopo.kidscare.pager.Pager;

@Service
public class UserReviewServiceImpl implements UserReviewService {
	
	@Autowired
	UserReviceDao dao;

	@Override
	public List<UserReview> list(Pager pager) {
		return dao.list(pager);
	}

	@Override
	public void add(UserReview userreviewInfo) {
		dao.add(userreviewInfo);
	}

	@Override
	public UserReview userreviewInfo(String reviewId) {
		return dao.userreviewInfo(reviewId);
	}

	@Override
	public void update(UserReview userreviewInfo) {
		dao.update(userreviewInfo);
	}

	@Override
	public List<UserReview> findByParent(String username, Pager pager) {
		
		return dao.findByParent(username, pager);
	}

	@Override
	public List<UserReview> findBySitter(Pager pager) {
		return dao.findBySitter(pager);
	}

}
