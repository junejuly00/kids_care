package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.UserReview;
import kr.ac.kopo.kidscare.pager.Pager;

public interface UserReviewService {

	List<UserReview> list(Pager pager);

	void add(UserReview reviewInfo);

	UserReview userreviewInfo(String reviewId);

	void update(UserReview userreviewInfo);

	List<UserReview> findByParent(String username, Pager pager);

	List<UserReview> findBySitter(Pager pager);

}
