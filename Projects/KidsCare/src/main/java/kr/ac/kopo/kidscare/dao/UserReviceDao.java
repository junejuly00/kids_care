package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.UserReview;

public interface UserReviceDao {

	List<UserReview> list();

	void add(UserReview reviewInfo);

	UserReview userreviewInfo(String reviewId);

	void update(UserReview userreviewInfo);

}
