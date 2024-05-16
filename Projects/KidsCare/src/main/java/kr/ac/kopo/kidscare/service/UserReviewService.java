package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.UserReview;

public interface UserReviewService {

	List<UserReview> list();

	void add(UserReview reviewInfo);

	UserReview userreviewInfo(String reviewId);

	void update(UserReview userreviewInfo);

}
