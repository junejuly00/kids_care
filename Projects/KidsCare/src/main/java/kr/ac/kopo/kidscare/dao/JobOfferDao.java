package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.JobOffer;

public interface JobOfferDao {

	List<JobOffer> list();

	void add(JobOffer item);

	JobOffer item(String offerId);

	void update(JobOffer item);

}
